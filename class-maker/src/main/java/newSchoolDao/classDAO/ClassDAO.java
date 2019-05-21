package newSchoolDao.classDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import newSchoolDao.base.BaseDao;
import newSchoolInfo.classInformation.ClassInformation;

/*
 * 作者:付全镇
 * 类名:ClassDAO
 * 作用:class表的增删查改操作
 * 日期:5/1
 */
public class ClassDAO extends BaseDao {

	/*
	 * 插入数据
	 */
	public long insertIntoClass(ClassInformation classInfo) {
		// sql语句
		String sql = "insert into schooldatabase.class(name,sch_id,gra_id)values(:name,:sch_id,:gra_id)";
		// 建立parameters集合,用来传入集合
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		// 传入name列信息
		parameters.addValue("name", classInfo.getName());
		// 传入sch_id列信息
		parameters.addValue("sch_id", classInfo.getSchoolId());
		// 传入gra_id列信息
		parameters.addValue("gra_id", classInfo.getGradeId());
		// 调用父类的insert方法,返回id
		long classId = super.insert(sql, parameters);
		// 返回id
		return classId;
	}

	/*
	 * 查询数据
	 */
	public List<Map<String, Object>> selectFromClass(long schoolId, long gradeId) {
		// 建立parameters集合
		Map<String, Object> parameters = new HashMap<String, Object>();
		// sql语句
		String sql = "select * from class where sch_id=:sch_id and gra_id=:gra_id";
		// 传入sch_id列参数
		parameters.put("sch_id", schoolId);
		// 传入gra_id列参数
		parameters.put("gra_id", gradeId);
		// 调用父类的namedParameterJdbcTemplateSelect方法,查询数据
		List<Map<String, Object>> existsGradeList = super.namedParameterJdbcTemplateSelect(sql, parameters);
		// 返回existsGradeList查询集合
		return existsGradeList;
	}

}
