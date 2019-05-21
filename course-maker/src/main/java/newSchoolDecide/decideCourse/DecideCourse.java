package newSchoolDecide.decideCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import newSchoolInfo.course.Course;

/*
 * 作者:付全镇
 * 类名:DecideCourse
 * 作用:返回需要插入的course信息集合
 * 日期:5/16
 */
public class DecideCourse {

	public static List<Course> decide(List<Course> batchBuildList, List<Map<String, Object>> existsList) {
		// courseList用来存储course信息
		List<Course> courseList = new ArrayList<Course>();
		// 如果查询的数据库里已有的集合existsList等于null,或existsList里面的元素build的batchBuildList,执行if分支内容
		if (existsList == null || existsList.size() < batchBuildList.size()) {
			// 让index等于existsList元素个数,并作为batchBuildList下标值
			int index = existsList.size();
			// 让i=index的值,每次加1,并小于batchBuildList元素个数
			for (int i = index; i < batchBuildList.size(); i++) {
				// 取得对应i位置的course
				Course course = batchBuildList.get(i);
				// 把course存入courseList
				courseList.add(course);
			}
		}
		// 返回courseList
		return courseList;
	}
}
