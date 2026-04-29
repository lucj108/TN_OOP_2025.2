package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
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
    }
}