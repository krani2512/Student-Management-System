package java;

import java.util.*;

public class AttendanceService {
    private Map<Integer, Map<String, Boolean>> attendanceRecord = new HashMap<>();

    public void markAttendance(int rollNo, String date, boolean present) {
        attendanceRecord.putIfAbsent(rollNo, new HashMap<>());
        attendanceRecord.get(rollNo).put(date, present);
    }

    public Map<String, Boolean> getAttendance(int rollNo) {
        return attendanceRecord.getOrDefault(rollNo, new HashMap<>());
    }
}
