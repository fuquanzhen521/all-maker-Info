package newSchool.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import newSchoolBuild.studentBuilder.StudentBuilder;
import newSchoolDao.classDAO.ClassDAO;
import newSchoolDao.electiveDAO.ElectiveDAO;
import newSchoolDao.studentDAO.StudentDAO;
import newSchoolInfo.classInformation.ClassInformation;
import newSchoolInfo.student.Student;
import newSchoolInfo.teacher.Teacher;

/*
 * 作者:付全镇
 * 类名:InsertIntoClass
 * 作用:插入数据
 * 日期:5/16
 */
public class AllInformationBuilder {

	public static void main(String args[]) {
		// build school
		List<Long> schoolIdList = BuildInformation.buildSchoolInfo();
		// build grade
		List<Long> gradeIdList = BuildInformation.buildGradeInfo();
		// build course
		List<Long> courseIdList = BuildInformation.buildCourseInfo();
		// build teacher
		List<Teacher> teacherInsertList = BuildInformation.buildTeacherInfo(courseIdList);
		// build class
		ClassDAO classDAO = new ClassDAO();
		int f = 0;
		int q = 0;
		// 遍历学校id集合
		for (long schoolId : schoolIdList) {
			f++;
			// 遍历年级id集合
			for (long gradeId : gradeIdList) {
				q++;
				// 查询当前schoolId和gradeId下的班级信息
				List<Map<String, Object>> existsClassList = classDAO.selectFromClass(schoolId, gradeId);
				// 建一个map
				HashMap<String, Long> map = new HashMap<String, Long>();
				// 调用GetAppInformation类的getMap静态方法,得到以name为key,classId为values的map集合
				InformationOperation.getMap(existsClassList, map);
				// 插入25个班级
				for (int i = 1; i <= 25; i++) {
					// 生成班级name
					String className = i + "班";
					// 生成一条班级信息
					ClassInformation classInformation = new ClassInformation(className, schoolId, gradeId);
					// 给classId赋初值
					long classId = 0;
					// 如果map中不包含className,执行if分支的内容
					if (!map.containsKey(className)) {
						// 执行插入操作
						classId = classDAO.insertIntoClass(classInformation);
					} else {
						classId = map.get(className);
					}
					// build student
					StudentDAO studentDAO = new StudentDAO();
					// 查询数据库里当前班级下已有的学生信息
					List<Map<String, Object>> existsStudentList = studentDAO.selectFromStudent(classId);
					// 生成学生信息,并返回需要插入的学生信息的集合
					List<Student> batchStudentBuildList = StudentBuilder.batchBuild(existsStudentList, classId,
							schoolId, gradeId);
					// 插入学生信息,并返回id
					List<Long> studentIdList = studentDAO.insertIntoStudent(batchStudentBuildList);
					// 调用GetAppInformation类的getStudentId静态方法,得到班级内所有学生id
					InformationOperation.getStudentId(existsStudentList, studentIdList);
					// 给studentIdList排序
					Collections.sort(studentIdList);
					// build elective信息
					ElectiveDAO electiveDAO = new ElectiveDAO();
					int z = 0;
					// 调用GetAppInformation类的insertElective静态方法,得到选课信息
					InformationOperation.insertElective(teacherInsertList, f, q, i, studentIdList, electiveDAO, z);
				}
			}
			if (q == 4) {
				q = 0;
			}
		}
	}

}
