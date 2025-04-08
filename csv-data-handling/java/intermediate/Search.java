package intermediate;

import java.io.*;

public class Search {
    public static void main(String[] args) {
        String searchName = "John Doe";
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + data[2] + ", Salary: " + data[3]);
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
