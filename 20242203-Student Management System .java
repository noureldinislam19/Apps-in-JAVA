import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int id;
    double grade;

    Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Grade Point Average");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    calculateAverage();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Name: ");
        input.nextLine();
        String name = input.nextLine();

        System.out.print("Enter ID: ");
        int id = input.nextInt();

        System.out.print("Enter Grade: ");
        double grade = input.nextDouble();

        students.add(new Student(name, id, grade));
        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            System.out.println("Name: " + s.name + 
                               ", ID: " + s.id + 
                               ", Grade: " + s.grade);
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = input.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found:");
                System.out.println("Name: " + s.name + 
                                   ", Grade: " + s.grade);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = input.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double sum = 0;

        for (Student s : students) {
            sum += s.grade;
        }

        System.out.println("Average Grade = " + (sum / students.size()));
    }
}
