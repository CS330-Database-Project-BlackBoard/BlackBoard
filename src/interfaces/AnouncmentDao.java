package interfaces;

import java.util.ArrayList;

import pojos.Anouncment;

public interface AnouncmentDao {
	
	public ArrayList<Anouncment> getAllAnouncments();

	public ArrayList<Anouncment> getAnouncmentsByLecture(int lectureID);
	public Anouncment getAnouncmentByID(int anouncmentID);
	public ArrayList<Anouncment> getAnouncmentsBySchoolID(int schoolID);
	public ArrayList<Anouncment> getAnouncmentsByRole(int level);
	public boolean sendAnouncment(String title, String content,  String toWho, int sentBy);
	
}
