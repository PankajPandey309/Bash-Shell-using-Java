import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.File;

public class ZipFileDemo {
    static final int BUFFER = 1024;
                
                
    public static void main(String[] args) {
     zipFile();
    }
    // Method to zip file
    private static void zipFile(){
        ZipOutputStream zos = null;
        BufferedInputStream bis = null;
        try{
            // source file
            String fileName = "D:\\os club\\codes";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis, BUFFER);
            
            // Creating ZipOutputStream
            FileOutputStream fos = new FileOutputStream("D:\\os club\\codes.zip");
            zos = new ZipOutputStream(fos);                  
            
            // ZipEntry --- Here file name can be created using the source file
            ZipEntry ze = new ZipEntry(file.getName());
            // Putting zipentry in zipoutputstream
            zos.putNextEntry(ze);
            byte data[] = new byte[BUFFER];
            int count;
            while((count = bis.read(data, 0, BUFFER)) != -1) {
                zos.write(data, 0, count);
            }
        }catch(IOException ioExp){
            System.out.println("Error while zipping " + ioExp.getMessage());
        }finally{
          if(zos != null){
            try {
              zos.close();
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          }
          if(bis != null){
            try {
              bis.close();
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          }
        }
    }
}