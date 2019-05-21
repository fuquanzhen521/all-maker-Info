package newSchoolBuild.gradeBuilder;

import java.util.ArrayList;
import java.util.List;

import newSchoolInfo.grade.Grade;

/*
 * 作者:付全镇
 * 类名:GradeBuilder
 * 作用:生成grade数据
 * 日期:5/1
 */
public class GradeBuilder {

	/*
	 * 对grade表信息的生成操作
	 */
	public static Grade build(Integer i) {
		String name = "第" + i + "年级";
		return new Grade(name);
	}

	/*
	 * 生成grade数据
	 */
	public static List<Grade> batchBuild(Integer size) {
		List<Grade> gradeList = new ArrayList<Grade>();
		for (int i = 1; i <= size; i++) {
			Grade grade = build(i);
			gradeList.add(grade);
		}
		return gradeList;
	}

}
