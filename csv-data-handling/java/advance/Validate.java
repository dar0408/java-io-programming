package advance;

import java.io.*;

public class Validate {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String email = data[2];
                String phone = data[3];
                if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                    System.out.println("Invalid email for: " + data[1]);
                }
                if (!phone.matches("\\d{10}")) {
                    System.out.println("Invalid phone number for: " + data[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

