package beans;

import java.util.Date;

public class Student {
	
	private String nie, name, surname;
	private Date birthdate;
	
	public Student(String nie, String name, String surname, Date birthdate) {
		this.nie = nie;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getNie() {
		return nie;
	}
	
	public void setNie(String nie) {
		this.nie = nie;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

}