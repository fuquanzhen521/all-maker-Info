package newSchoolInfo.elective;

/*
 * 作者:付全镇
 * 类名:Elective
 * 作用:封装属性
 * 日期:5/1
 */
public class Elective {
	private long studentId;
	private long courseId;
	private long teacherId;
	private float score;

	public Elective() {
	}

	public Elective(long studentId, long courseId, long teacherId, float score) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.score = score;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}
