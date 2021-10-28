package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Courses database table.
 * 
 */
@Entity
@Table(name="Courses")
@NamedQuery(name="Cours.findAll", query="SELECT c FROM Cours c")
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_course")
	private int idCourse;

	@Column(name="academic_course")
	private String academicCourse;

	private String description;

	private String name;

	private String name;

	private int section;

	//bi-directional many-to-many association to Student
	@ManyToMany(mappedBy="courses")
	private List<Student> students;

	public Cours() {
	}

	public int getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getAcademicCourse() {
		return this.academicCourse;
	}

	public void setAcademicCourse(String academicCourse) {
		this.academicCourse = academicCourse;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSection() {
		return this.section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}