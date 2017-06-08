package pojos;

public class SimpleFile {
	
	
	private String fileName;
	private String hashedFileName;
	private String path;
	
	
	
	
	public SimpleFile(String fileName, String hashedFileName, String path) {
		super();
		this.fileName = fileName;
		this.hashedFileName = hashedFileName;
		this.path = path;
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
	
	
	
	
	

}
