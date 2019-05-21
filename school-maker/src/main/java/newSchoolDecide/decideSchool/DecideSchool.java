package newSchoolDecide.decideSchool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import newSchoolInfo.school.School;

/*
 * 作者:付全镇
 * 类名:DecideSchool
 * 作用:查看数据库里插入了多少条数据,返回还需要插入的数据
 * 日期:5/16
 */
public class DecideSchool {

	/*
	 * 返回还需要插入的school数据
	 */
	public static List<School> decide(List<School> buildSchoolList, List<Map<String, Object>> existsSchoolList) {
		// 建一个集合,用来存储id
		List<School> realSchoolList = new ArrayList<School>();
		HashMap<String, Long> map = new HashMap<String, Long>();
		// 遍历集合existsSchoolList
		for (Map<String, Object> schoolInfo : existsSchoolList) {
			// 获得name列的name信息
			Object objName = schoolInfo.get("name");
			// 将name转成String类型
			String schoolName = objName.toString();
			// 获得id列的id信息
			Object objId = schoolInfo.get("id");
			// 将id转为long类型
			long schoolId = Long.valueOf(String.valueOf(objId));
			map.put(schoolName, schoolId);
		}
		// 遍历传入的buildSchoolList参数集合
		for (School school : buildSchoolList) {
			// 取得buildSchoolList集合的name信息
			String schName = school.getName();
			// 如果map集合中的key值不包括schName的值,执行if分支的内容
			if (!map.containsKey(schName)) {
				// 把name不在map中的school信息存入realSchoolList中
				realSchoolList.add(school);
			}
		}
		// 返回realSchoolList
		return realSchoolList;
	}

}
