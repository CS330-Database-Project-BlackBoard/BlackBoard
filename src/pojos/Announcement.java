package pojos;

public class Announcement {
	private int announcementID;
	private int postedBy;
	private String title;
	private String content;
	private String postedAt;

	
	
	
	
	public Announcement(int anouncmentID, int postedBy, String title, String content, String postedAt) {
		super();
		this.announcementID = anouncmentID;
		this.postedBy = postedBy;
		this.title = title;
		this.content = content;
		this.postedAt = postedAt;
	}


	public int getAnnouncementID() {
		return announcementID;
	}

	public int getpostedBy() {
		return postedBy;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getPostedAt() {
		return postedAt;
	}

	
	@Override
	public boolean equals(Object obj) {
		Announcement other = (Announcement) obj;
		if(other.getTitle() == this.getTitle() && other.getContent() == this.getContent())
		{
			return false;
		}
		return true;
	}
	
}
