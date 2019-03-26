import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {

    public static void main(String[] args) {
        Path path = Paths.get("D:\\JAVA\\intro\\README.txt");
        // Using Lines
        try(Stream<String> stream = Files.lines(path)){
            stream.forEach(System.out::println);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // Using newBufferedReader
        try(BufferedReader br = Files.newBufferedReader(path)){
            Stream<String> stream = br.lines();
            stream.forEach(System.out::println);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}