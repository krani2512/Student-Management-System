package java;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        List<Student> students = new ArrayList<>();
        MarksService marksService = new MarksService();
        AttendanceService attendanceService = new AttendanceService();

        System.out.println("--- Student Management System ---");
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (!auth.login(user, pass)) {
            System.out.println("Login failed!");
            return;
        }

        while (true) {
            System.out.println("\n1. Add Student\n2. View Profile\n3. Update Marks\n4. Record Attendance\n5. Sort by GPA\n6. Display All\n7. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Roll No: "); int roll = sc.nextInt(); sc.nextLine();
                    if (!RollNumberValidator.isUnique(roll, students)) {
                        System.out.println("Duplicate Roll No.");
                        break;
                    }
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Department: "); String dept = sc.nextLine();
                    students.add(new Student(roll, name, dept));
                    System.out.println("Student added.");
                }
                case 2 -> {
                    System.out.print("Roll No: "); int roll = sc.nextInt();
                    Student s = students.stream().filter(stu -> stu.getRollNo() == roll).findFirst().orElse(null);
                    if (s != null) ProfileService.printProfile(s, marksService, attendanceService);
                    else System.out.println("Not found");
                }
                case 3 -> {
                    System.out.print("Roll No: "); int roll = sc.nextInt(); sc.nextLine();
                    System.out.print("Subject: "); String subj = sc.nextLine();
                    System.out.print("Mark: "); int mark = sc.nextInt();
                    marksService.addMark(roll, subj, mark);
                }
                case 4 -> {
                    System.out.print("Roll No: "); int roll = sc.nextInt(); sc.nextLine();
                    System.out.print("Date (dd-mm): "); String date = sc.nextLine();
                    System.out.print("Present (true/false): "); boolean pres = sc.nextBoolean();
                    attendanceService.markAttendance(roll, date, pres);
                }
                case 5 -> {
                    StudentSorter.sortByGPA(students, marksService);
                    System.out.println("Students sorted by GPA.");
                }
                case 6 -> students.forEach(System.out::println);
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
