package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author gutongxue
 * @date 2019/11/2 9:14
 **/
public class IOTest {
    public static void main(String[] args) throws IOException{
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 11);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        //输出
        try (PrintWriter out = new PrintWriter("employee.txt", StandardCharsets.UTF_8)) {
            writeData(staff, out);
        }

        //输入
        try (Scanner in = new Scanner(new FileInputStream("employee.txt"), "UTF-8")) {
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }



    private static void writeData(Employee[] staff, PrintWriter out) throws IOException {
        out.println(staff.length);
        for (Employee e : staff) {
            writeEmployee(out, e);
        }
    }

    private static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }
}
