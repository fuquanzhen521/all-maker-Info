package newSchoolDao.electiveDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import newSchoolDao.base.BaseDao;
import newSchoolInfo.elective.Elective;

/*
 * 作者:付全镇
 * 类名:ElectiveDAO
 * 作用:elective表的增删查改操作
 * 日期:5/1
 */
public class ElectiveDAO extends BaseDao {

	/*
	 * 插入数据
	 */
	public void insertIntoElective(List<Elective> electiveList) {
		for (Elective elective : electiveList) {
			// 创建parameters集合,用来传递参数
			Map<String, Object> parameters = new HashMap<String, Object>();
			// sql语句
			String sql = "insert into schooldatabase.elective(sid,cid,tid,score)values(:sid,:cid,:tid,:score)";
			// 传入sid信息
			parameters.put("sid", elective.getStudentId());
			// 传入cid列信息
			parameters.put("cid", elective.getCourseId());
			// 传入tid列信息
			parameters.put("tid", elective.getTeacherId());
			// 传入score列信息
			parameters.put("score", elective.getScore());
			// 调用父类方法insert,插入数据
			super.onlyInsert(sql, parameters);
		}
	}

	/*
	 * 查询数据
	 */
	public List<Map<String, Object>> selectFromElective(long studentId) {
		// sql语句
		String sql = "select * from elective where sid=:sid";
		// 创建parameters集合,用来传递参数
		Map<String, Object> parameters = new HashMap<String, Object>();
		// 传入sid列参数
		parameters.put("sid", studentId);
		// 执行sql查询,返回集合existsList
		List<Map<String, Object>> existsList = super.namedParameterJdbcTemplateSelect(sql, parameters);
		// 返回existsList
		return existsList;
	}
}
