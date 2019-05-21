package newSchoolDao.studentDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import newSchoolDao.base.BaseDao;
import newSchoolInfo.student.Student;

/*
 * 作者:付全镇
 * 类名:StudentDAO
 * 作用:student表的增删查改操作
 * 日期:5/1
 */
public class StudentDAO extends BaseDao {

	/*
	 * 插入多条数据
	 */
	public List<Long> insertIntoStudent(List<Student> studentList) {
		// studentIdList用来存储id
		List<Long> studentIdList = new ArrayList<Long>();
		// 遍历传入的studentList集合
		for (Student student : studentList) {
			// 创建parameters集合
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			// sql语句
			String sql = "insert into schooldatabase.student(name,birthday,sex,sch_id,gra_id,cla_id)values(:name,:birthday,:sex,:sch_id,:gra_id,:cla_id)";
			// 传入name列参数
			parameters.addValue("name", student.getName());
			// 传入birthday列参数
			parameters.addValue("birthday", student.getBirthday());
			// 传入sex列参数
			parameters.addValue("sex", student.getSex());
			// 传入sch_id列参数
			parameters.addValue("sch_id", student.getSchoolId());
			// 传入gra_id列参数
			parameters.addValue("gra_id", student.getGradeId());
			// 传入cla_id列参数
			parameters.addValue("cla_id", student.getClassId());
			// 调用父类的insert方法,并返回id
			long studentId = super.insert(sql, parameters);
			// 将id存入studentIdList
			studentIdList.add(studentId);
		}
		// 返回studentIdList
		return studentIdList;
	}

	/*
	 * 查询数据
	 */
	public List<Map<String, Object>> selectFromStudent(long classId) {
		// sql语句
		String sql = "select * from student where cla_id=:cla_id";
		// 创建parameters集合,用来传递参数
		Map<String, Object> parameters = new HashMap<String, Object>();
		// 传入cla_id列参数
		parameters.put("cla_id", classId);
		// 调用父类的namedParameterJdbcTemplateSelect方法,返回existsList
		List<Map<String, Object>> existsList = super.namedParameterJdbcTemplateSelect(sql, parameters);
		// 返回existsList
		return existsList;
	}
}
