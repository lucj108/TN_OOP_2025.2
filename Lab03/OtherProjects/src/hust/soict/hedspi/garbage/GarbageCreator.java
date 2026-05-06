package hust.soict.hedspi.garbage;
<<<<<<< HEAD

=======
import java.io.IOException;
>>>>>>> hotfix/redo-lab03
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
<<<<<<< HEAD
    public static void main(String[] args) {
        // can tao mot file van ban lon (vi du: test.txt) trong thu muc goc cua project
        String filename = "test.txt"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
=======
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\DELL\\Downloads\\Lab-3_Basic OO Techniques.pdf"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char)b;
        }
        
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
>>>>>>> hotfix/redo-lab03
    }
}