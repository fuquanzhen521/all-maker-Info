package newSchoolDao.schoolDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import newSchoolInfo.school.School;

/*
 * 作者:付全镇
 * 类名:SchoolDAO
 * 作用:school表的增删查改操作
 * 日期:5/15
 */

public class SchoolDAO extends newSchoolDao.base.BaseDao {

	/*
	 * 查询数据
	 */
	public List<Map<String, Object>> selectFromSchool(String name) {
		String sql = "select * from school where name like:name";
		// 创建Map<String, Object> parameters
		Map<String, Object> parameters = new HashMap<String, Object>();
		// 让sql中name的column对应传入的参数name
		parameters.put("name", name);
		// 调用父类的namedParameterJdbcTemplateSelect方法,他是一个Map<String,Object>类型的list集合
		List<Map<String, Object>> schoolList = super.namedParameterJdbcTemplateSelect(sql, parameters);
		// 返回集合
		return schoolList;
	}

	/*
	 * 插入多条信息
	 */
	public List<Long> insertSchool(List<School> schoolList) {
		List<Long> idSchoolList = new ArrayList<Long>();
		// 遍历传入的schoolList参数集合
		for (School school : schoolList) {
			// sql语句
			String sql = "insert into schooldatabase.school(name,`985`,`211`)values(:name,:jbw,:eyy)";
			// 定义一个MapSqlParameterSource类型集合,用来传递参数
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			// 传入name列的信息
			parameters.addValue("name", school.getName());
			// 传入985列的信息
			parameters.addValue("jbw", school.isJbw());
			// 传入211列的信息
			parameters.addValue("eyy", school.isEyy());
			// 调用父类的insert方法,它返回的是一个id
			long schoolId = super.insert(sql, parameters);
			idSchoolList.add(schoolId);
		}
		return idSchoolList;
	}
}