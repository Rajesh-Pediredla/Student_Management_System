package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SMSManager {
    private List<Student> studentList;
    private Scanner scanner;

    public SMSManager() {
        this.studentList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to add a new student
    public void addStudent() {
        System.out.println("\n--- Adding New Student ---");
        System.out.print("Enter Name: ");
        String name = scanner.next();
        
        System.out.print("Enter Roll Number: ");
        // Basic error handling for integer input
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid Roll Number (integer): ");
            scanner.next(); // consume the invalid input
        }
        int rollNumber = scanner.nextInt();

        System.out.print("Enter Branch (e.g., ECE, CSE): ");
        String branch = scanner.next();

        System.out.print("Enter GPA (0.0 - 10.0): ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid GPA (double): ");
            scanner.next();
        }
        double gpa = scanner.nextDouble();
        
        // Create the object and add to the list
        Student newStudent = new Student(name, rollNumber, branch, gpa);
        studentList.add(newStudent);
        
        System.out.println("\n✅ Student added successfully!");
    }

    // Method to display all students
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("\n❌ The student list is currently empty.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("-------------------------");
    }

    // Method to search for a student by roll number
    public void searchStudent() {
        System.out.print("\nEnter Roll Number to search: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll Number must be an integer.");
            scanner.next();
            return;
        }
        int searchRoll = scanner.nextInt();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getRollNumber() == searchRoll) {
                System.out.println("\n🔍 Student Found:");
                System.out.println(student);
                found = true;
                break; 
            }
        }
        
        if (!found) {
            System.out.println("\n❌ Student with Roll No. " + searchRoll + " not found.");
        }
    }
    
    // --- NEW METHOD: deleteStudent() ---
    public void deleteStudent() {
        if (studentList.isEmpty()) {
            System.out.println("\n❌ The student list is empty. Nothing to delete.");
            return;
        }
        
        System.out.print("\nEnter Roll Number of the student to DELETE: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll Number must be an integer.");
            scanner.next();
            return;
        }
        int deleteRoll = scanner.nextInt();
        
        // Using an enhanced for loop with an index or Iterator is safer 
        // when deleting, but for simplicity, we use a standard loop here.
        Student studentToRemove = null;
        
        for (Student student : studentList) {
            if (student.getRollNumber() == deleteRoll) {
                studentToRemove = student;
                break;
            }
        }
        
        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            System.out.println("\n✅ Student with Roll No. " + deleteRoll + " has been successfully deleted.");
        } else {
            System.out.println("\n❌ Deletion failed. Student with Roll No. " + deleteRoll + " not found.");
        }
    }
}