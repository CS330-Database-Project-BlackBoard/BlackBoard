package interfaces;

import pojos.User;

public interface UserDao {
	
	User getUser();
	boolean signIn(String email, String password);
	boolean signOut();

}
