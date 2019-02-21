package fr.nadeva.javaee.cdi.model;

public class User {
	private String name;
	
	private String email;
	
	public User(String userName, String userEmail) {
		name=userName;
		email=userEmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		return ("name: ["+name+"] email: ["+email+"]");
	}
}
