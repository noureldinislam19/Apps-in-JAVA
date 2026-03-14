import java.util.Scanner;

public class Main {

    static String[] tasks = new String[100];
    static int taskindex = 0;

    public static void main(String[] args) {

        System.out.println("Welcome To My Task Tracker");
        System.out.println("--------------------------");

        while (true) {

            System.out.println("Please Enter Your Choice From 1 To 5!");
            System.out.println("1 to add");
            System.out.println("2 to view");
            System.out.println("3 to complete");
            System.out.println("4 to remove");
            System.out.println("5 to exit");

            Scanner input = new Scanner(System.in);
            int userchoise = input.nextInt();

            switch (userchoise) {

                case 1:
                    AddTask();
                    break;

                case 2:
                    ViewTasks();
                    break;

                case 3:
                    MarkTaskComplete();
                    break;

                case 4:
                    removetask();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter your choice from 1 to 5");
                    break;
            }
        }
    }

    static void AddTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Task:");
        tasks[taskindex] = input.nextLine();
        taskindex++;
    }

    static void ViewTasks() {
        System.out.println("Task List:");
        for (int i = 0; i < taskindex; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }

    static void MarkTaskComplete() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter task number to mark complete:");
        int taskID = input.nextInt();
        tasks[taskID - 1] += " ---> completed";
    }

    static void removetask() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter task number to remove:");
        int taskID = input.nextInt();
        tasks[taskID - 1] = "Empty";
    }
}