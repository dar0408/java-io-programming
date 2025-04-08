package basic;

import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ID,Name,Department,Salary\n");
            bw.write("101,John Doe,IT,60000\n");
            bw.write("102,Jane Smith,HR,55000\n");
            bw.write("103,Robert Brown,Marketing,58000\n");
            bw.write("104,Linda Lee,Finance,62000\n");
            bw.write("105,David Clark,IT,61000\n");
            System.out.println("Data written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

