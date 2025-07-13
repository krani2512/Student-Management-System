package java;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable {
    private int rollNo;
    private String name;
    private String department;

    public Student(int rollNo, String name, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Dept: " + department;
    }
}
