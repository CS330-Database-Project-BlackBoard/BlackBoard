package pojos;

public class File {
	private int fileID;
	private int lectureID;
	private int postedBY;
	private String path;
	private String Name;
	private String type;
	private String postedAT;
	private int announcementID;
	
	private Announcement announcement;
	
	
	
	
	
	public File(int fileID, int lectureID, int postedBY, String path, String name, String type, String postedAT,
			int announcementID, Announcement announcement) {
		super();
		this.fileID = fileID;
		this.lectureID = lectureID;
		this.postedBY = postedBY;
		this.path = path;
		Name = name;
		this.type = type;
		this.postedAT = postedAT;
		this.announcementID = announcementID;
		this.announcement = announcement;
	}
	
	
	public Announcement getAnnouncement() {
		return announcement;
	}
	public int getFileID() {
		return fileID;
	}
	public int getLectureID() {
		return lectureID;
	}
	public int getPostedBY() {
		return postedBY;
	}
	public String getPath() {
		return path;
	}
	public String getName() {
		return Name;
	}
	public String getType() {
		return type;
	}
	public String getPostedAT() {
		return postedAT;
	}
	public int getAnnouncementID() {
		return announcementID;
	}
	
	
	

}
