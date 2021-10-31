package beans;

public class Course {
	
	private int id;
	private String name, school, description, academicCourse;
	
	public Course(int id, String name, String school, String description, String academicCourse) {
		this.id = id;
		this.name = name;
		this.school = school;
		this.description = description;
		this.academicCourse = academicCourse;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSchool() {
		return school;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getAcademicCourse() {
		return this.academicCourse;
	}
	
	public void setAcademic_course(String academicCourse) {
		this.academicCourse = academicCourse;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}