import java.util.HashMap;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private static HashMap<Integer, Student> studentRecords = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student");
            System.out.println("5. List All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> removeStudent();
                case 4 -> viewStudent();
                case 5 -> listAllStudents();
                case 6 -> {
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, age, grade);
        studentRecords.put(id, student);
        System.out.println("Student added successfully!");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        if (studentRecords.containsKey(id)) {
            Student student = studentRecords.get(id);
            System.out.println("Current Details: " + student);
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Name (leave blank to keep unchanged): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) student.setName(name);

            System.out.print("Enter new Age (0 to keep unchanged): ");
            int age = scanner.nextInt();
            if (age > 0) student.setAge(age);

            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Grade (leave blank to keep unchanged): ");
            String grade = scanner.nextLine();
            if (!grade.isBlank()) student.setGrade(grade);

            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();
        if (studentRecords.remove(id) != null) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static void viewStudent() {
        System.out.print("Enter Student ID to view: ");
        int id = scanner.nextInt();
        Student student = studentRecords.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static void listAllStudents() {
        if (studentRecords.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("--- All Students ---");
            for (Student student : studentRecords.values()) {
                System.out.println(student);
            }
        }
    }
}
