package newSchoolInfo.grade;

/*
 * 作者:付全镇
 * 类名:Grade
 * 作用:封装属性
 * 日期:5/1
 */
public class Grade {
	private long id;
	private String name;

	public Grade() {
	}

	public Grade(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
