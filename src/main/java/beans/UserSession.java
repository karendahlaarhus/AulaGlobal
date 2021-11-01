package beans;

import java.util.Date;

public class UserSession {
	private String idUser;
	private Date startDateTime;
	private Date endDateTime;
	
	
	public UserSession(String idUser) {
		this.idUser = idUser;
		this.startDateTime = new Date();
	}
	
	public UserSession(String idUser, Date start) {
		this.idUser = idUser;
		this.startDateTime = start;
		this.endDateTime = new Date();
	}
	
	public UserSession(String idUser, Date start, Date end) {
		this.idUser = idUser;
		this.startDateTime = start;
		this.endDateTime = end;
	}
	
	public String getIdUser() {
		return idUser;
	}
	
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public Date getStartDateTime() {
		return startDateTime;
	}
	
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public Date getEndDateTime() {
		return endDateTime;
	}
	
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	
	
	
	
	
	

}
