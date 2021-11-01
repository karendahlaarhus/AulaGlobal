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
	private String idUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date_time")
	private java.util.Date startDateTime;

	public UserSessionPK() {
	}
	public String getIdUser() {
		return this.idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public java.util.Date getStartDateTime() {
		return this.startDateTime;
	}
	public void setStartDateTime(java.util.Date startDateTime) {
		this.startDateTime = startDateTime;
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
			this.idUser.equals(castOther.idUser)
			&& this.startDateTime.equals(castOther.startDateTime);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser.hashCode();
		hash = hash * prime + this.startDateTime.hashCode();
		
		return hash;
	}
}