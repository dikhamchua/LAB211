package j1_L_P0021_Student_Management;

public class Report {
	protected String studentName;
	protected String courseName;
	protected int totalCourse;
	public Report(String studentName, String courseName, int totalCourse) {
		super();
		this.studentName = studentName;
		this.courseName = courseName;
		this.totalCourse = totalCourse;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setTotalCourse(int totalCourse) {
		this.totalCourse = totalCourse;
	}
	@Override
	public String toString() {
		return String.format("%-15s|%-10s|%-5d\n", studentName,courseName,totalCourse);
	}
	
	

}
