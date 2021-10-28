package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


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

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="end_time")
	private Timestamp endTime;

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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}