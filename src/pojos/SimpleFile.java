package pojos;

public class SimpleFile {
	
	
	private String fileName;
	private String hashedFileName;
	private String path;
	private String type; 
	
	
	
	public SimpleFile(String fileName, String hashedFileName, String path, String type) {
		super();
		this.fileName = fileName;
		this.hashedFileName = hashedFileName;
		this.path = path;
		this.type = type;
	}
	
	
	
	public String getFileName() {
		return fileName;
	}
	public String getHashedFileName() {
		return hashedFileName;
	}
	public String getPath() {
		return path;
	}



	public String getType() {
		return type;
	}
	
	
	
	
	

}
