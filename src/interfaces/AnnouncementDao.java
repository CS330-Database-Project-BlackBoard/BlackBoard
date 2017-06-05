package interfaces;

import java.util.ArrayList;

import pojos.Announcement;

public interface AnnouncementDao {
	
	public ArrayList<Announcement> getAllAnnouncements();

	public ArrayList<Announcement> getAnnouncementsByLecture(int lectureID);
	public Announcement getAnnouncementByID(int AnnouncementID);
	public ArrayList<Announcement> getAnnouncementsBySchoolID(int schoolID);
	public ArrayList<Announcement> getAnnouncementsByRole(int level);
	public boolean sendAnnouncement(String title, String content,  String toWho, int sentBy);
	
}
