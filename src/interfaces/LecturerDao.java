package interfaces;

import java.util.ArrayList;

import pojos.Lecturer;

public interface LecturerDao {
	
	
	public Lecturer getLecturerBySchooID(int schoolID);
	
	public ArrayList<Lecturer> getAllLecturers();
	
	public ArrayList<Lecturer> getLecturersByName(String name);
	
	

}
