package practice_problem;

import org.json.JSONObject;

public class CreateJson {

    public static void main(String[] args) {

        JSONObject subject = new JSONObject();

        subject.put("1", "English");
        subject.put("2", "Math");
        subject.put("3", "Science");

        JSONObject student = new JSONObject();

        student.put("name", "Simer");
        student.put("age", 23);
        student.put("subject", subject);

        System.out.println(student);

    }
}
