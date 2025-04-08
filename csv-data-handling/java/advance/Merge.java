package advance;

import java.io.*;
import java.util.*;

public class Merge {
    public static void main(String[] args) throws IOException {
        Map<String, String[]> map1 = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("students1.csv"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                map1.put(data[0], data); // ID as key
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("students2.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("merged.csv"))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] d2 = line.split(",");
                String[] d1 = map1.get(d2[0]);
                if (d1 != null) {
                    bw.write(String.join(",", d1[0], d1[1], d1[2], d2[1], d2[2]) + "\n");
                }
            }
        }
    }
}
