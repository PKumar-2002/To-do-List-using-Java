import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {

    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the To-Do List Application!");
        System.out.println("Commands:");
        System.out.println("1. add <task> - Add a new task");
        System.out.println("2. list - List all tasks");
        System.out.println("3. remove <index> - Remove a task by its index");
        System.out.println("4. exit - Exit the application");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            if (command.startsWith("add ")) {
                String task = command.substring(4);
                addTask(task);
            } else if (command.equals("list")) {
                listTasks();
            } else if (command.startsWith("remove ")) {
                try {
                    int index = Integer.parseInt(command.substring(7));
                    removeTask(index);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index format. Please enter a number.");
                }
            } else if (command.equals("exit")) {
                System.out.println("Exiting the application.");
                break;
            } else {
                System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid index. No task removed.");
        } else {
            String removedTask = tasks.remove(index - 1);
            System.out.println("Task removed: " + removedTask);
        }
    }
}
