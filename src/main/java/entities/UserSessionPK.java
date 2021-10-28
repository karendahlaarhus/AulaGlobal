package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the UserSessions database table.
 * 
 */
@Embeddable
public class UserSessionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_user", insertable=false, updatable=false)
	private int idUser;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private java.util.Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private java.util.Date startTime;

	public UserSessionPK() {
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	public java.util.Date getStartTime() {
		return this.startTime;
	}
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserSessionPK)) {
			return false;
		}
		UserSessionPK castOther = (UserSessionPK)other;
		return 
			(this.idUser == castOther.idUser)
			&& this.startDate.equals(castOther.startDate)
			&& this.startTime.equals(castOther.startTime);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser;
		hash = hash * prime + this.startDate.hashCode();
		hash = hash * prime + this.startTime.hashCode();
		
		return hash;
	}
}