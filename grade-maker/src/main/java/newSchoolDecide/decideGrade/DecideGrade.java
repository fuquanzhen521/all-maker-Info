package newSchoolDecide.decideGrade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import newSchoolInfo.grade.Grade;

/*
 * 作者:付全镇
 * 类名:DecideGrade
 * 作用:返回还需要插入的数据
 * 日期:5/16
 */
public class DecideGrade {

	/*
	 * 返回还需要插入的grade信息集合
	 */
	public static List<Grade> decide(List<Grade> buildGradeList, List<Map<String, Object>> existsSchoolList) {
		// realGradeList用来存储grade信息
		List<Grade> realGradeList = new ArrayList<Grade>();
		// 判断查询的数据库集合existsSchoolList是否为null或是否小于四个元素
		if (existsSchoolList == null || existsSchoolList.size() < 4) {
			// 让index等于existsSchoolList的元素个数,作为buildGradeList的下标值
			int index = existsSchoolList.size();
			// 让i等于index,每次加1,知道i的值小于4
			for (int i = index; i < 4; i++) {
				// 取得buildGradeList在当前i位置的grade信息
				Grade grade = buildGradeList.get(i);
				// 把grade信息存入集合
				realGradeList.add(grade);
			}
		}
		// 返回realGradeList集合
		return realGradeList;
	}

}
