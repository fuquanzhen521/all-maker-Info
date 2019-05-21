package newSchoolInfo.student;

import java.sql.Date;

/*
 * 作者:付全镇
 * 类名:Student
 * 作用:封装属性
 * 日期:5/1
 */
public class Student {
	private long id;
	private String name;
	private Date birthday;
	private byte sex;
	private long schoolId;
	private long gradeId;
	private long classId;

	public Student() {
	}

	public Student(String name, Date birthday, byte sex, long schoolId, long gradeId, long classId) {
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.schoolId = schoolId;
		this.gradeId = gradeId;
		this.classId = classId;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public byte getSex() {
		return sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
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

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}
}
