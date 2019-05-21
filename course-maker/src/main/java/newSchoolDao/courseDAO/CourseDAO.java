package newSchoolDao.courseDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import newSchoolDao.base.BaseDao;
import newSchoolInfo.course.Course;

/*
 * 作者:付全镇
 * 类名:CourseDAO
 * 作用:course表的增删查改操作
 * 日期:5/1
 */
public class CourseDAO extends BaseDao {

	/*
	 * 插入多条数据
	 */
	public List<Long> insertIntoCourse(List<Course> courseList) {
		List<Long> courseIdList = new ArrayList<Long>();
		// 遍历传入的参数集合courseList
		for (Course course : courseList) {
			// 建立parameters,用来传送参数
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			// sql语句
			String sql = "insert into schooldatabase.course(name)values(:name)";
			// 传入name列的参数
			parameters.addValue("name", course.getName());
			// 调用父类的insert方法,并返回id
			long courseId = super.insert(sql, parameters);
			courseIdList.add(courseId);
		}
		// 返回id集合
		return courseIdList;
	}

	/*
	 * 查询数据
	 */
	public List<Map<String, Object>> selectFromCourse() {
		// sql语句
		String sql = "select * from schooldatabase.course";
		// 调用父类的queryTest方法,并返回id
		List<Map<String, Object>> courseList = super.queryTest(sql);
		// 返回id集合
		return courseList;
	}
}
