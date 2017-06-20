package interfaces;

import java.io.File;
import java.util.ArrayList;

import org.omg.CORBA.INTERNAL;

import pojos.Announcement;
import pojos.SimpleFile;

public interface AnnouncementDao {
	
	public ArrayList<Announcement> getAllAnnouncements();

	public ArrayList<Announcement> getAnnouncementsByLecture(int lectureID);
	
	public Announcement getAnnouncementByID(int announcementID);
	
	public ArrayList<Announcement> getAnnouncementsBySchoolID(int schoolID);
	
	public ArrayList<Announcement> getAnnouncementsByRole(int level);
	
	public boolean sendAnnouncement(String title, String content,  String toWho, int schoolID);
	
	public Announcement getMaterialAnnouncementByID(int announcementID);
	
	public boolean saveMaterialAnnouncement(SimpleFile file, int lectureID, String title, String content, int schoolID);
	
}
