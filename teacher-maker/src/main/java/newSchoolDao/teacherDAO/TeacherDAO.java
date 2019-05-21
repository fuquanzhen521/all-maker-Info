package newSchoolDao.teacherDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import newSchoolDao.base.BaseDao;
import newSchoolInfo.teacher.Teacher;

/*
 * 作者:付全镇
 * 类名:TeacherDAO
 * 作用:teacher表的增删查改操作
 * 日期:5/1
 */
public class TeacherDAO extends BaseDao {

	/*
	 * 插入数据
	 */
	public List<Teacher> insertIntoTeacher(List<Teacher> teacherList) {
		List<Teacher> teacherInsertList = new ArrayList<Teacher>();
		// 遍历传入的集合teacherList
		for (Teacher teacher : teacherList) {
			// sql语句
			String sql = "insert into schooldatabase.teacher(name,cid)values(:name,:cid)";
			// 创建parameters集合,用来传入参数
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			// 传入name列的信息
			parameters.addValue("name", teacher.getName());
			// 传入cid列的信息
			parameters.addValue("cid", teacher.getCourseId());
			// 调用父类的insert方法,插入数据
			long teacherId = super.insert(sql, parameters);
			Teacher teacherInfo = new Teacher(teacherId, teacher.getName(), teacher.getCourseId());
			teacherInsertList.add(teacherInfo);
		}
		return teacherInsertList;
	}

	/*
	 * 查询数据
	 */
	public List<Map<String, Object>> selectFromTeacher() {
		// sql语句
		String sql = "select * from schooldatabase.teacher";
		// 调用父类的queryTest方法
		List<Map<String, Object>> teacherList = super.queryTest(sql);
		// 返回teacherList
		return teacherList;
	}
}
