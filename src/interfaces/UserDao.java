package interfaces;

import pojos.User;

public interface UserDao {
	
	public User getUser();
	
	public boolean signIn(String email, String password);
	public boolean signOut();

}
