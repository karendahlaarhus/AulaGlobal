package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Students database table.
 * 
 */
@Entity
@Table(name="Students")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String nie;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String name;

	private String surname;

	//bi-directional many-to-many association to Course
	@ManyToMany
	@JoinTable(
		name="EnrolledStudent"
		, joinColumns={
			@JoinColumn(name="nie_student")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_course")
			}
		)
	private List<Course> courses;

	public Student() {
	}

	public String getNie() {
		return this.nie;
	}

	public void setNie(String nie) {
		this.nie = nie;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}