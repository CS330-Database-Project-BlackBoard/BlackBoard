package pojos;

import security.AppSecurity;

public class Manager extends User{
	
	private String password;
	private String roleDescription = "";
	
	
	public Manager(int schoolID, String email, String name, String surname, int role) {
		super(schoolID, email, name, surname, role);
	}
	
	public Manager(int schoolID, String email, String name, String surname, int role, String roleDescription) {
		super(schoolID, email, name, surname, role);
		this.roleDescription = roleDescription;
	}
	
	public Manager(int schoolID, String email, String password, String name, String surname, int role) {
		super(schoolID, email, name, surname, role);
		this.password = AppSecurity.md5(password);
	}

	public String getPassword() {
		return password;
	}

	public String getRoleDescription() {
		return roleDescription;
	}
	
	

}
