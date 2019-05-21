package newSchoolBuild.courseBuilder;

import java.util.ArrayList;
import java.util.List;

import newSchoolInfo.course.Course;

/*
 * 作者:付全镇
 * 类名:CourseBuilder
 * 作用:生成course数据
 * 日期:5/1
 */

public class CourseBuilder {

	/*
	 * 对course数据生成的操作
	 */
	public static Course build(Integer i) {
		String name = "第" + i + "课程";
		return new Course(name);
	}

	/*
	 * 生成course数据
	 */
	public static List<Course> batchBuild(Integer size) {
		List<Course> courseList = new ArrayList<Course>();
		for (int i = 1; i <= size; i++) {
			Course course = build(i);
			courseList.add(course);
		}
		return courseList;
	}

}
