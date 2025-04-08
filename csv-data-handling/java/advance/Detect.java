package advance;

import java.io.*;
import java.util.*;

public class Detect {
    public static void main(String[] args) throws IOException {
        Set<String> seen = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (!seen.add(d[0])) {
                    System.out.println("Duplicate ID found: " + d[0]);
                }
            }
        }
    }
}
