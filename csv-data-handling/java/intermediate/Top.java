package intermediate;

import java.io.*;
import java.util.*;

public class Top {
    public static void main(String[] args) throws IOException {
        List<String[]> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String header = br.readLine(); // store header
            String line;
            while ((line = br.readLine()) != null) {
                employees.add(line.split(","));
            }

            employees.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(Arrays.toString(employees.get(i)));
            }
        }
    }
}
