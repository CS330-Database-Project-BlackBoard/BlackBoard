package pojos;

public class Anouncment {
	private int anouncmentID;
	private int postedBy;
	private String title;
	private String content;
	private String postedAt;

	
	
	
	
	public Anouncment(int anouncmentID, int postedBy, String title, String content, String postedAt) {
		super();
		this.anouncmentID = anouncmentID;
		this.postedBy = postedBy;
		this.title = title;
		this.content = content;
		this.postedAt = postedAt;
	}


	public int getAnouncmentID() {
		return anouncmentID;
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
		Anouncment other = (Anouncment) obj;
		if(other.getTitle() == this.getTitle() && other.getContent() == this.getContent())
		{
			return false;
		}
		return true;
	}
	
}
