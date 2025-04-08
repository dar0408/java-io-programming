package advance;

import java.io.*;

public class Read {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("large.csv"))) {
            br.readLine(); // skip header
            String line;
            int chunk = 0, count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                if (count % 100 == 0) {
                    chunk++;
                    System.out.println("Processed chunk: " + chunk * 100);
                }
            }
            System.out.println("Total records processed: " + count);
        }
    }
}
