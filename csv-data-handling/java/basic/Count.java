package basic;

import java.io.*;

public class Count {
    public static void main(String[] args) {
        String filePath = "students.csv";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            while (br.readLine() != null) {
                count++;
            }
            System.out.println("Total records (excluding header): " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
