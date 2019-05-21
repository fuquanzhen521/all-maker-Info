package newSchoolBuild.teacherBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import newSchoolInfo.teacher.Teacher;

/*
 * 作者:付全镇
 * 类名:TeacherBuilder
 * 作用:生成teacher信息
 * 日期:5/1
 */
public class TeacherBuilder {

	/*
	 * 生成teacher信息
	 */
	public static List<Teacher> batchBuild(List<Long> courseList, List<Map<String, Object>> existsList) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		// 存入一些姓氏数组元素
		String x[] = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈" };
		// 存入一些名字数组元素
		String m[] = { "华", "夏", "雷", "锋", "好", "榜", "样", "学", "习", "好" };
		// 打乱courseList集合的顺序
		Collections.shuffle(courseList);
		// map以courseId作为key值,以teacherId作为values值
		Map<Long, Long> map = new HashMap<Long, Long>();
		// 遍历传入的查询集合
		for (Map<String, Object> teacher : existsList) {
			// 取得cid列的信息
			Object objCid = teacher.get("cid");
			// 转成long类型
			long cid = Long.valueOf(String.valueOf(objCid));
			// 取得id列的信息
			Object objId = teacher.get("id");
			// 转成long类型
			long teacherId = Long.valueOf(String.valueOf(objId));
			// 存入map
			map.put(cid, teacherId);
		}
		for (long courseId : courseList) {
			// 如果map的key值不包含courseId,执行if分支的内容
			if (!map.containsKey(courseId)) {
				// 随机取得数组x的下标值
				int a = (int) Math.abs(x.length * Math.random());
				// 随机取得数组m的下标值
				int b = (int) Math.abs(m.length * Math.random());
				// 取得姓名
				String name = x[a] + m[b];
				// 生成老师信息
				Teacher teacher = new Teacher(name, courseId);
				// 存入teacherList中
				teacherList.add(teacher);
			}
		}
		// 返回teacherList
		return teacherList;
	}
}
