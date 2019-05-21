package newSchoolInfo.classInformation;

/*
 * 作者:付全镇
 * 类名:ClassInformation
 * 作用:封装属性
 * 日期:5/1
 */
public class ClassInformation {
	private long id;
	private String name;
	private long schoolId;
	private long gradeId;

	public ClassInformation(long id, String name, long schoolId, long gradeId) {
	}

	public ClassInformation(String name, long schoolId, long gradeId) {
		this.name = name;
		this.schoolId = schoolId;
		this.gradeId = gradeId;
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

	public long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	public long getGradeId() {
		return gradeId;
	}

	public void setGradeId(long gradeId) {
		this.gradeId = gradeId;
	}

}
