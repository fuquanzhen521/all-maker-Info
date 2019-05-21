package newSchoolInfo.teacher;

/*
 * 作者:付全镇
 * 类名:Teacher
 * 作用:封装属性
 * 日期:5/1
 */
public class Teacher {
	private long id;
	private String name;
	private long courseId;

	public Teacher(long id, String name, long courseId) {
		this.id = id;
		this.name = name;
		this.courseId = courseId;
	}

	public Teacher(String name, long courseId) {
		this.name = name;
		this.courseId = courseId;
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

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
}
