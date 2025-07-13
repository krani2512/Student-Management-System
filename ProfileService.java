package java;

public class ProfileService {
    public static void printProfile(Student student, MarksService marksService, AttendanceService attendanceService) {
        System.out.println(student);
        System.out.println("Marks: " + marksService.getMarks(student.getRollNo()));
        System.out.println("Attendance: " + attendanceService.getAttendance(student.getRollNo()));
    }
}
