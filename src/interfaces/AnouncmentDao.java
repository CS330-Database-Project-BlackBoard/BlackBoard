package interfaces;

import java.util.ArrayList;

import pojos.Anouncment;

public interface AnouncmentDao {
	
	public ArrayList<Anouncment> getAllAnouncment();
	public ArrayList<Anouncment> getAnouncmentsByLecture(int lectureID);
	public Anouncment getAnouncmentByID(int AnouncmentID);
	public ArrayList<Anouncment> getAnouncmentsBySchoolID(int schoolID);
	public ArrayList<Anouncment> getAnouncmentsByRole(int level);
	
}
