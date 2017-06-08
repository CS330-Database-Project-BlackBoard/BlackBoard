package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Format;

import javax.servlet.http.Part;

import pojos.SimpleFile;
import security.AppSecurity;

public class Uploader {
	
	private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;
    private static final String DATA_DIRECTORY = "/home/farisi/student-files";
    
    
    
    
    public static SimpleFile uploadFile(int schoolID, Part filePart) {
    	
    	
    	SimpleFile simpleFile = null;
    	
        String fileName = getFileName(filePart);
        String newName = String.format("%d_%s_%s", schoolID, TimeZone.getDateTime(), fileName) ;
        String hashedName = String.format("%s.pdf",AppSecurity.md5(newName));
        String path = String.format("%s/%s", DATA_DIRECTORY, hashedName);
       
        OutputStream outputStream = null;
        InputStream fileContent = null;
       

       try {
	           outputStream = new FileOutputStream(new File(DATA_DIRECTORY + File.separator + hashedName));
	           fileContent = filePart.getInputStream();
	           int read = 0;
	           final byte[] bytes = new byte[4096];
	           while ((read = fileContent.read(bytes)) != -1) {
	               outputStream.write(bytes, 0, read);
	               
	               
	           }

	           simpleFile = new SimpleFile(fileName, hashedName, path);
       }
       catch (Exception e){
    	   e.printStackTrace();
       } 
       finally {
           if(outputStream != null){
               try {
				outputStream.close();
               }
               catch (IOException e) {
				e.printStackTrace();
               }
           }
           if(fileContent != null){
                try {
					fileContent.close();
				} 
                catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
               
           
       	}
       
    	
    	
    	return simpleFile;
    	
    	
    	
    }
    
    
    private static String getFileName(Part filePart){
        String header = filePart.getHeader("content-disposition");
        String name = header.substring(header.indexOf("filename=\"")+10);
        return name.substring(0, name.indexOf("\""));
    }

}
