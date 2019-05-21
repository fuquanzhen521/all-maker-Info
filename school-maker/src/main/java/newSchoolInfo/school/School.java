package newSchoolInfo.school;

/*
 * 作者:付全镇
 * 类名:School
 * 作用:封装属性
 * 日期:5/1
 */
public class School {
	private long id;
	private String name;
	// 定义985
	private boolean jbw;
	// 定义211
	private boolean eyy;

	public School() {
	}

	public School(String name, boolean jbw, boolean eyy) {
		this.name = name;
		this.jbw = jbw;
		this.eyy = eyy;
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

	public boolean isJbw() {
		return jbw;
	}

	public void setJbw(boolean jbw) {
		this.jbw = jbw;
	}

	public boolean isEyy() {
		return eyy;
	}

	public void setEyy(boolean eyy) {
		this.eyy = eyy;
	}

}
