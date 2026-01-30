package Project;

public class Student {
    // 1. Attributes (State) - Encapsulation via private access
    private String name;
    private int rollNumber;
    private String branch; 
    private double gpa; // Using GPA (Scale 0.0 - 10.0)

    // 2. Constructor
    public Student(String name, int rollNumber, String branch, double gpa) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.branch = branch;
        this.gpa = gpa;
    }

    // 3. Getters (Accessors) - Allow reading private data
    public int getRollNumber() {
        return rollNumber;
    }
    
    // 4. toString() Method - Overridden for easy printing
    @Override
    public String toString() {
        return "Roll No: " + rollNumber + 
               " | Name: " + name + 
               " | Branch: " + branch + 
               " | GPA: " + String.format("%.2f", gpa);
    }
}