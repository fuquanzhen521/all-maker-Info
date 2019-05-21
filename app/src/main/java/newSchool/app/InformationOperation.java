package newSchool.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import newSchoolBuild.electiveBuilder.ElectiveBuilder;
import newSchoolDao.electiveDAO.ElectiveDAO;
import newSchoolInfo.elective.Elective;
import newSchoolInfo.teacher.Teacher;

/*
 * 作者:付全镇
 * 类名:GetAppInformation
 * 作用:操作方法的提取
 * 日期:5/21
 */
public class InformationOperation {

	/*
	 * 插入一个班级内所有学生的选课信息
	 */
	public static void insertElective(List<Teacher> teacherInsertList, int f, int q, int i, List<Long> studentIdList,
			ElectiveDAO electiveDAO, int z) {
		// 遍历studentIdList集合
		for (long studentId : studentIdList) {
			z++;
			// 查询当前学生id下数据里的选课信息
			List<Map<String, Object>> existsElectiveList = electiveDAO.selectFromElective(studentId);
			// 获得还需要插入的选课信息集合batchBuildElectiveList
			List<Elective> batchBuildElectiveList = ElectiveBuilder.batchBuild(existsElectiveList, teacherInsertList,
					studentId);
			// 插入elective信息
			electiveDAO.insertIntoElective(batchBuildElectiveList);
			System.out.println("第" + f + "中学" + "第" + q + "年级" + i + "班" + "第" + z + "个学生的信息");
		}
	}

	/*
	 * 得到一个班级内所有学生的集合
	 */
	public static void getStudentId(List<Map<String, Object>> existsStudentList, List<Long> studentIdList) {
		// 遍历查询的学生信息集合existsStudentList
		for (Map<String, Object> student : existsStudentList) {
			// 获得id列的信息
			Object objId = student.get("id");
			// 转成long类型
			long studentId = Long.valueOf(String.valueOf(objId));
			// 把id存入studentIdList,获得班级下所有学生的id信息
			studentIdList.add(studentId);
		}
	}

	/*
	 * 把查询到的班级信息的name作为key,id作为values,得到一个map集合
	 */
	public static void getMap(List<Map<String, Object>> existsClassList, HashMap<String, Long> map) {
		// 遍历查询到的existsClassList集合
		for (Map<String, Object> classInfo : existsClassList) {
			// 取得name列的信息
			Object objName = classInfo.get("name");
			// 转成String类型
			String className = objName.toString();
			// 取得id列信息
			Object objId = classInfo.get("id");
			// 转成long类型
			long classId = Long.valueOf(String.valueOf(objId));
			// name作为map的key值,id作为map的values值
			map.put(className, classId);
		}
	}

	/*
	 * 得到所有教师信息集合
	 */
	public static void getTeacherId(List<Map<String, Object>> existsTeacherList, List<Teacher> teacherInsertList) {
		// 遍历查询的集合existsTeacherList
		for (Map<String, Object> teacher : existsTeacherList) {
			// 取得id列的信息
			Object objId = teacher.get("id");
			// 转成long类型
			long teacherId = Long.valueOf(String.valueOf(objId));
			// 取得name列信息
			Object objName = teacher.get("name");
			// 转成String类型
			String teacherName = objName.toString();
			// 取得cid列信息
			Object objCid = teacher.get("cid");
			// 转成long类型
			long cid = Long.valueOf(String.valueOf(objCid));
			// 生成一条学生信息
			Teacher teacherInfo = new Teacher(teacherId, teacherName, cid);
			// 将学生信息插入到teacherInsertList
			teacherInsertList.add(teacherInfo);
		}
	}

	/*
	 * 得到所有课程id信息集合
	 */
	public static void getCourseId(List<Map<String, Object>> existsList, List<Long> courseIdList) {
		// 遍历查询的集合existsList
		for (Map<String, Object> course : existsList) {
			// 取得id列的信息
			Object objId = course.get("id");
			// 转成long类型
			long courseId = Long.valueOf(String.valueOf(objId));
			// 把id存入courseIdList
			courseIdList.add(courseId);
		}
	}

	/*
	 * 得到所有年级id信息集合
	 */
	public static void getGradeId(List<Map<String, Object>> existsGradeList, List<Long> gradeIdList) {
		// 遍历查询的集合existsGradeList
		for (Map<String, Object> grade : existsGradeList) {
			// 获得id列信息
			Object objId = grade.get("id");
			// 转成long类型
			long gradeId = Long.valueOf(String.valueOf(objId));
			gradeIdList.add(gradeId);
		}
	}

	/*
	 * 得到所有学校id信息集合
	 */
	public static void getSchoolId(List<Map<String, Object>> existsSchoolList, List<Long> schoolIdList) {
		// 遍历查询的集合existsSchoolList
		for (Map<String, Object> school : existsSchoolList) {
			// 获得id列的信息
			Object objId = school.get("id");
			// 转成long类型
			Long schoolId = Long.valueOf(String.valueOf(objId));
			schoolIdList.add(schoolId);
		}
	}
}
