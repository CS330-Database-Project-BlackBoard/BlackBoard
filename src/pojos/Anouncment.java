package pojos;

public class Anouncment {
	private int anouncmentID;
	private int postedBy;
	private String title;
	private String content;
	private String postedAt;
	private String filePath;
	private String fileName;
	private String fileType;
	private int postedTo;
	
	
	
	
	public Anouncment(int anouncmentID, int postedBy, String title, String content, String postedAt, int postedTo) {
		super();
		this.anouncmentID = anouncmentID;
		this.postedBy = postedBy;
		this.title = title;
		this.content = content;
		this.postedAt = postedAt;
		this.postedTo = postedTo;
	}

	public Anouncment(int anouncmentID, int postedBy, String title, String content, String postedAt, String filePath,
			String fileName, String fileType, int postedTo) {
		super();
		this.anouncmentID = anouncmentID;
		this.postedBy = postedBy;
		this.title = title;
		this.content = content;
		this.postedAt = postedAt;
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileType = fileType;
		this.postedTo = postedTo;
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

	public String getFilePath() {
		return filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileTpye() {
		return fileType;
	}

	public int getPostedTo() {
		return postedTo;
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
