package intermediate;

import java.io.*;

public class Scores {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]);
                if (marks > 80) {
                    System.out.println("Qualified: " + data[1] + " with " + marks + " marks");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
