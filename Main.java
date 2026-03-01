import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Double> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(double grade) {
        grades.add(grade);
    }

    double calculateAverage() {
        if (grades.size() == 0)
            return 0;
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n1- Add Student");
            System.out.println("2- Show Students");
            System.out.println("3- Search Student");
            System.out.println("4- Delete Student");
            System.out.println("5- Exit");
            System.out.print("Choose: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();
                    Student student = new Student(name);

                    System.out.print("How many grades? ");
                    int count = input.nextInt();

                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter grade: ");
                        double grade = input.nextDouble();
                        student.addGrade(grade);
                    }

                    students.add(student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    for (Student s : students) {
                        System.out.println("Name: " + s.name +
                                " | Average: " + s.calculateAverage());
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = input.nextLine();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.name.equalsIgnoreCase(searchName)) {
                            System.out.println("Found!");
                            System.out.println("Grades: " + s.grades);
                            System.out.println("Average: " + s.calculateAverage());
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = input.nextLine();
                    students.removeIf(s -> s.name.equalsIgnoreCase(deleteName));
                    System.out.println("Deleted if existed.");
                    break;

                case 5:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}