package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.txt"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            
            // dung stringbuilder de tranh tao rac bo nho
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}