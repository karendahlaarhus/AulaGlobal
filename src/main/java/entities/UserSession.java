package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the UserSessions database table.
 * 
 */
@Entity
@Table(name="UserSessions")
@NamedQuery(name="UserSession.findAll", query="SELECT u FROM UserSession u")
public class UserSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserSessionPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date_time")
	private Date endDateTime;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public UserSession() {
	}

	public UserSessionPK getId() {
		return this.id;
	}

	public void setId(UserSessionPK id) {
		this.id = id;
	}

	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}