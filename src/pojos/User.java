package pojos;

public class User {
	 
	private int schoolID;
	private String email;
	private String name;
	private String surname;
	private int role;
	
	public User(int schoolID, String email, String name, String surname, int role) {
		super();
		this.schoolID = schoolID;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSchoolID() {
		return schoolID;
	}
	public String getSurname() {
		return surname;
	}

	public int getRole() {
		return role;
	}
	
	public void printUser() {
		System.out.println(getName() + " " + getSurname() + " " + getRole());
	}
	
	
}
