package advance;

import org.json.*;
import java.io.*;

public class JsonToCsv {
    public static void main(String[] args) throws Exception {
        String json = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("students.json")));
        JSONArray arr = new JSONArray(json);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students_from_json.csv"))) {
            bw.write("ID,Name,Age,Marks\n");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                bw.write(obj.getString("id") + "," + obj.getString("name") + "," +
                        obj.getInt("age") + "," + obj.getInt("marks") + "\n");
            }
        }
    }
}
