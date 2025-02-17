import java.util.*;

class Student {
    private int id;
    private String name;
    private HashMap<String, Double> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void updateGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void displayGrades() {
        System.out.println("Grades for " + name + ": " + grades);
    }
}

class StudentManagementSystem {
    private HashMap<Integer, Student> students;

    public StudentManagementSystem() {
        this.students = new HashMap<>();
    }

    public void addStudent(int id, String name) {
        if (!students.containsKey(id)) {
            students.put(id, new Student(id, name));
            System.out.println("Student added: " + name);
        } else {
            System.out.println("Student ID already exists!");
        }
    }

    public void updateStudentGrade(int id, String subject, double grade) {
        Student student = students.get(id);
        if (student != null) {
            student.updateGrade(subject, grade);
            System.out.println("Grade updated for " + student.getName());
        } else {
            System.out.println("Student not found!");
        }
    }

    public void getStudentAverage(int id) {
        Student student = students.get(id);
        if (student != null) {
            System.out.println("Average grade for " + student.getName() + ": " + student.getAverageGrade());
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayAllStudents() {
        for (Student student : students.values()) {
            student.displayGrades();
        }
    }
}

    class Test {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        sms.addStudent(1, "Abhishek");
        sms.addStudent(2, "Shoaib");

        sms.updateStudentGrade(1, "Math", 85.5);
        sms.updateStudentGrade(1, "Science", 90.0);
        sms.updateStudentGrade(2, "Math", 78.5);
        sms.updateStudentGrade(2, "English", 88.0);

        sms.getStudentAverage(1);
        sms.getStudentAverage(2);

        sms.displayAllStudents();
    }
}
