package interfaces;

import java.util.ArrayList;

import org.omg.CORBA.INTERNAL;

import pojos.Announcement;

public interface AnnouncementDao {
	
	public ArrayList<Announcement> getAllAnnouncements();

	public ArrayList<Announcement> getAnnouncementsByLecture(int lectureID);
	
	public Announcement getAnnouncementByID(int announcementID);
	
	public ArrayList<Announcement> getAnnouncementsBySchoolID(int schoolID);
	
	public ArrayList<Announcement> getAnnouncementsByRole(int level);
	
	public boolean sendAnnouncement(String title, String content,  String toWho, int sentBy);
	
	public Announcement getMaterialAnnouncementByID(int announcementID);
	
}
