package java;

import java.util.List;

public class RollNumberValidator {
    public static boolean isUnique(int rollNo, List<Student> students) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return false;
            }
        }
        return true;
    }
}
