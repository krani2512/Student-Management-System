package java;

import java.util.*;

public class MarksService {
    private Map<Integer, Map<String, Integer>> studentMarks = new HashMap<>();

    public void addMark(int rollNo, String subject, int mark) {
        studentMarks.putIfAbsent(rollNo, new HashMap<>());
        studentMarks.get(rollNo).put(subject, mark);
    }

    public Map<String, Integer> getMarks(int rollNo) {
        return studentMarks.getOrDefault(rollNo, new HashMap<>());
    }
}