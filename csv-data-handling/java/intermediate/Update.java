package intermediate;

import java.io.*;
import java.util.*;

public class Update {
    public static void main(String[] args) throws IOException {
        List<String[]> updatedData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equals("ID") && data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    salary *= 1.10;
                    data[3] = String.valueOf((int) salary);
                }
                updatedData.add(data);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("updated_employees.csv"))) {
            for (String[] row : updatedData) {
                bw.write(String.join(",", row) + "\n");
            }
        }
        System.out.println("Salaries updated and written to updated_employees.csv");
    }
}
