package java;

import java.util.Map;

public class GPAService {
    public static double calculateGPA(Map<String, Integer> marks) {
        if (marks.isEmpty()) return 0.0;
        double sum = 0;
        for (int score : marks.values()) {
            sum += score;
        }
        return sum / marks.size();
    }
}
