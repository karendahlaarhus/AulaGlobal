package beans;

import java.util.Date;

public class UserSession {
	private String idUser;
	private Date startDateTime;
	private Date endDateTime;
	
	/**
	 * This constructor is used when first creating a user session
	 * @param idUser
	 */
	
	public UserSession(String idUser) {
		this.idUser = idUser;
		this.startDateTime = new Date();
	}
	
	/**
	 *  This constructor is used when ending a user session
	 * @param idUser
	 * @param start: start of the user session
	 */
	
	public UserSession(String idUser, Date start) {
		this.idUser = idUser;
		this.startDateTime = start;
		this.endDateTime = new Date();
	}
	 /**
	  * This constructor is used when creating a list of user sessions
	  * @param idUser
	  * @param start
	  * @param end
	  */
	
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
