package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\DELL\\Downloads\\Lab-3_Basic OO Techniques.pdf"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {							// Sua phan nay
            outputStringBuilder.append((char)b);
        }
        
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
