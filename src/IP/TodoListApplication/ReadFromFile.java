package IP.TodoListApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile extends Actions {
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Please enter path to read:");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.print("path:");

            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();

            return userInput;
        }
    }

    @Override
    public void executeAction(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String file = scanner.nextLine();
                String[] parts = file.split(",");
                Task task = Task.buildTask(parts[0], parts[1], DateSorting.parseDate("dd-MM-yyyy", parts[2]),
                        parts[3], parts[4]);
                if (ToDoList.tasks.get(parts[0]) != null) {
                    ToDoList.tasks.replace(parts[0], task);
                } else {
                    ToDoList.tasks.put(parts[0], task);
                }

            }
            scanner.close();
            System.out.println("Tasks are being read!");
        } catch (FileNotFoundException e) {
            System.out.println("Path or file do not exist...");

        }

    }
}
