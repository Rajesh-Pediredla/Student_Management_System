package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SMSManager manager = new SMSManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main application loop
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Delete Student by Roll Number"); // NEW MENU OPTION
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        manager.addStudent();
                        break;
                    case 2:
                        manager.displayAllStudents();
                        break;
                    case 3:
                        manager.searchStudent();
                        break;
                    case 4:
                        manager.deleteStudent();
                        break;
                    case 5:
                        System.out.println("\n👋 Exiting System. Goodbye!");
                        scanner.close(); 
                        return;
                    default:
                        System.out.println("\n⚠️ Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("\n⚠️ Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}