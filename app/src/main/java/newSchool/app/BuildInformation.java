package newSchool.app;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import newSchoolBuild.courseBuilder.CourseBuilder;
import newSchoolBuild.gradeBuilder.GradeBuilder;
import newSchoolBuild.schoolBuilder.SchoolBuilder;
import newSchoolBuild.teacherBuilder.TeacherBuilder;
import newSchoolDao.courseDAO.CourseDAO;
import newSchoolDao.gradeDAO.GradeDAO;
import newSchoolDao.schoolDAO.SchoolDAO;
import newSchoolDao.teacherDAO.TeacherDAO;
import newSchoolDecide.decideCourse.DecideCourse;
import newSchoolDecide.decideGrade.DecideGrade;
import newSchoolDecide.decideSchool.DecideSchool;
import newSchoolInfo.course.Course;
import newSchoolInfo.grade.Grade;
import newSchoolInfo.school.School;
import newSchoolInfo.teacher.Teacher;

/*
 * 作者:付全镇
 * 类名:BuildInformation
 * 作用:生成信息
 * 日期:5/21
 */
public class BuildInformation {
	/*
	 * 生成teacher信息
	 */
	public static List<Teacher> buildTeacherInfo(List<Long> courseIdList) {
		TeacherDAO teacherDAO = new TeacherDAO();
		// 查询数据库里的教师信息
		List<Map<String, Object>> existsTeacherList = teacherDAO.selectFromTeacher();
		// 生成教师信息,batchBuildTeacherList里面的教师信息为需要插入的信息
		List<Teacher> batchBuildTeacherList = TeacherBuilder.batchBuild(courseIdList, existsTeacherList);
		// 插入教师信息
		List<Teacher> teacherInsertList = teacherDAO.insertIntoTeacher(batchBuildTeacherList);
		// 调用GetAppInformation类的getTeacherId静态方法,得到所有教师信息
		InformationOperation.getTeacherId(existsTeacherList, teacherInsertList);
		return teacherInsertList;
	}

	/*
	 * 生成course信息,并返回id
	 */
	public static List<Long> buildCourseInfo() {
		CourseDAO courseDAO = new CourseDAO();
		// 生成10个课程信息
		List<Course> batchBuildList = CourseBuilder.batchBuild(10);
		// 查询数据库里的课程信息
		List<Map<String, Object>> existsList = courseDAO.selectFromCourse();
		// 返回需要插入的课程信息
		List<Course> courseList = DecideCourse.decide(batchBuildList, existsList);
		// 查询课程信息,返回id
		List<Long> courseIdList = courseDAO.insertIntoCourse(courseList);
		// 调用GetAppInformation类的getCourseId静态方法,得到所有课程id
		InformationOperation.getCourseId(existsList, courseIdList);
		// 给courseIdList排序
		Collections.sort(courseIdList);
		return courseIdList;
	}

	/*
	 * 生成grade信息,并返回id
	 */
	public static List<Long> buildGradeInfo() {
		GradeDAO gradeDAO = new GradeDAO();
		// 生成4个年级信息
		List<Grade> buildGradeList = GradeBuilder.batchBuild(4);
		// 查询数据
		List<Map<String, Object>> existsGradeList = gradeDAO.selectFromGrade();
		// 获得还需要插入的年级信息的集合
		List<Grade> gradeList = DecideGrade.decide(buildGradeList, existsGradeList);
		// 执行插入,返回id
		List<Long> gradeIdList = gradeDAO.insertIntoGrade(gradeList);
		// 调用GetAppInformation类的getGradeId静态方法,得到所有年级的id
		InformationOperation.getGradeId(existsGradeList, gradeIdList);
		// 给id集合gradeIdList排序
		Collections.sort(gradeIdList);
		return gradeIdList;
	}

	/*
	 * 生成学校信息,并返回id
	 */
	public static List<Long> buildSchoolInfo() {
		SchoolDAO schoolDAO = new SchoolDAO();
		// 生成100个合肥学校信息
		List<School> buildSchoolList = SchoolBuilder.batchBuild("合肥", 100);
		// 查询合肥的学校信息
		List<Map<String, Object>> existsSchoolList = schoolDAO.selectFromSchool("合肥%");
		// 获得还需要插入的学校数据集合
		List<School> schoolList = DecideSchool.decide(buildSchoolList, existsSchoolList);
		// 执行插入,返回id
		List<Long> schoolIdList = schoolDAO.insertSchool(schoolList);
		// 调用GetAppInformation类的getSchoolId静态方法,得到所有学生的id
		InformationOperation.getSchoolId(existsSchoolList, schoolIdList);
		// 给id集合schoolIdList排序
		Collections.sort(schoolIdList);
		return schoolIdList;
	}
}
