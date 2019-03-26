import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

    static final int BUFFER = 2048;
    // Output folder
     private static final String DEST_FOLDER = "D:\\os club";
       public static void main (String argv[]) {
          try {
              File folder = new File(DEST_FOLDER);
              if(!folder.exists()){
                  folder.mkdir();
              }
             BufferedOutputStream dest = null;
             // zipped input
             FileInputStream fis = new FileInputStream("D:\\os club.zip");
             ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
             ZipEntry entry;
             while((entry = zis.getNextEntry()) != null) {
                System.out.println("Extracting: " +entry);
                int count;
                byte data[] = new byte[BUFFER];
                String fileName = entry.getName();
                File newFile = new File(folder + File.separator + fileName);
                // If directory then just create the directory (and parents if required)
                if(entry.isDirectory()){
                    if(!newFile.exists()){
                        newFile.mkdirs();
                    }
                }else{
                
                // write the files to the disk
                FileOutputStream fos = new FileOutputStream(newFile);
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                   dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
                }
                zis.closeEntry();
                
             }
             zis.close();
          } catch(Exception e) {
             e.printStackTrace();
          }
       }
}