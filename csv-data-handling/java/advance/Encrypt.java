package advance;

import java.io.*;
import java.util.Base64;

public class Encrypt {
    public static void main(String[] args) throws IOException {
        // Encryption
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("encrypted_employees.csv"))) {
            String header = br.readLine();
            bw.write(header + "\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                d[3] = Base64.getEncoder().encodeToString(d[3].getBytes()); // Encrypt salary
                bw.write(String.join(",", d) + "\n");
            }
        }

        // Decryption
        try (BufferedReader br = new BufferedReader(new FileReader("encrypted_employees.csv"))) {
            String header = br.readLine();
            System.out.println(header);
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                d[3] = new String(Base64.getDecoder().decode(d[3]));
                System.out.println(String.join(",", d));
            }
        }
    }
}
