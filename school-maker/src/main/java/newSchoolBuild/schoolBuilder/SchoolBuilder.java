package newSchoolBuild.schoolBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import newSchoolInfo.school.School;

/*
 * 作者:付全镇
 * 类名:SchoolBuilder
 * 作用:生成school信息
 * 日期:5/1
 */
public class SchoolBuilder {

	/*
	 * 对school信息生成的操作
	 */
	public static School build(String schoolName, Integer i) {
		String name = schoolName + "第" + i + "中学";
		Random random = new Random();
		// 随机取10个数
		int r = random.nextInt(10);
		if (r >= 0 && r < 5) {
			return new School(name, false, false);// 当大于等于0且小于5时,既不是985,也不是211;
		} else if (r >= 5 && r < 7) {
			return new School(name, true, false);// 当大于等于5且小于7时,是985,但不是211;
		} else if (r >= 7 && r < 9) {
			return new School(name, false, true);// 当大于等于7且小于9时,不是985,但是211;
		} else {
			return new School(name, true, true);// 当等于9时,是985，也是211;
		}
	}

	/*
	 * 生成school数据
	 */
	public static List<School> batchBuild(String schoolName, Integer size) {
		List<School> schoolList = new ArrayList<School>();
		for (int i = 1; i <= size; i++) {
			School school = build(schoolName, i);
			schoolList.add(school);
		}
		return schoolList;
	}

}
