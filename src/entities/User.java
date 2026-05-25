package entities;

import java.util.Objects;

public class User {

	private String username;
	private Integer userId;
	private String email;
	private String address;
	
	public User() {
	}

	public User(String username, Integer userId, String email, String address) {
		this.username = username;
		this.userId = userId;
		this.email = email;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    
	    sb.append("\n").append("User: ").append(username).append("\n");
	    sb.append("User Id: ").append(userId).append("\n");
	    sb.append("Email: ").append(email).append("\n");
	    sb.append("Address: ").append(address).append("\n");
	    
	    return sb.toString();
	}
	
	
}
