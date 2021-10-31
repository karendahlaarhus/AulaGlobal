package beans;

import java.util.Date;

public class Student {
	private int NIE;
	private String name;
	private String surname;
	private Date date_of_birth;
	
	
	public Student(int NIE, String name, String surname, Date date_of_birth) {
		this.NIE = NIE;
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
	}


	public int getNIE() {
		return NIE;
	}


	public void setNIE(int nIE) {
		NIE = nIE;
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


	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	

}
