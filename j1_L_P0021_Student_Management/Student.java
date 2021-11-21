package j1_L_P0021_Student_Management;

public class Student {
	protected  String ID;
	protected String name;
	protected String semester;
	protected String courseName;
	
	public Student(String iD, String name, String semester,String courseName) {
		super();
		ID = iD;
		this.name = name;
		this.semester = semester;
		this.courseName = courseName;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return String.format("%-15s%-20s%-10s%-10s", ID, name, semester, courseName);
	}
	
	
	
	
}
