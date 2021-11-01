package beans;

public class User {
	
	private String userId;
	private String password;

	private String name;
	private String surname;
	
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public User(String userId, String name, String surname) {
		this.userId = userId;
		this.name = name;
		this.surname = surname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
