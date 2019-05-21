package newSchoolDao.gradeDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import newSchoolDao.base.BaseDao;
import newSchoolInfo.grade.Grade;

/*
 * 作者:付全镇
 * 类名:GradeDAO
 * 作用:grade表的增删查改操作
 * 日期:5/1
 */
public class GradeDAO extends BaseDao {

	/*
	 * 插入数据
	 */
	public List<Long> insertIntoGrade(List<Grade> gradeList) {
		// gradeIdList用来存储id
		List<Long> gradeIdList = new ArrayList<Long>();
		// 遍历传入的gradeList集合
		for (Grade grade : gradeList) {
			// sql语句
			String sql = "insert into schooldatabase.grade(name)values(:name)";
			// 建立MapSqlParameterSource类型的parameters集合,用来传入参数
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			// 传入name列的信息
			parameters.addValue("name", grade.getName());
			// 调用父类的insert方法,并返回id
			long gradeId = super.insert(sql, parameters);
			// 把id存入gradeIdList集合
			gradeIdList.add(gradeId);
		}
		// 返回集合
		return gradeIdList;
	}

	/*
	 * 查询数据
	 */
	public List<Map<String, Object>> selectFromGrade() {
		// sql语句
		String sql = "select * from schooldatabase.grade";
		// 调用父类的queryTest方法,返回集合users
		List<Map<String, Object>> gradeList = super.queryTest(sql);
		// 返回集合users
		return gradeList;
	}

}
