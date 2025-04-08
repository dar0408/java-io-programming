package advance;

import java.io.*;
import java.sql.*;

public class Generate {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "pass");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("db_employees.csv"))) {
            bw.write("Employee ID,Name,Department,Salary\n");
            while (rs.next()) {
                bw.write(rs.getInt("id") + "," + rs.getString("name") + "," +
                        rs.getString("department") + "," + rs.getDouble("salary") + "\n");
            }
        }

        conn.close();
    }
}
