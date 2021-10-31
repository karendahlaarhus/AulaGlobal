package beans;

public class Course {
	
	private int courseId;
	private String name;
	private String description;
	private String academic_course;
	
	public Course(int courseId, String name, String description, String academic_course) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.academic_course = academic_course;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAcademic_course() {
		return academic_course;
	}
	public void setAcademic_course(String academic_course) {
		this.academic_course = academic_course;
	}
	
	
	

}
