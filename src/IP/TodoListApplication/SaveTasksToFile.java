package IP.TodoListApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SaveTasksToFile extends Actions {
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Please enter path to file:");

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
            PrintWriter print = new PrintWriter(new FileOutputStream(path));

            List<String> files = ToDoList.tasks.entrySet().stream().map(entry -> entry.getValue().toString()).collect((Collectors.toList()));

            files.forEach(file -> {
                print.println(file);
            });

            print.close();
            System.out.println("Task successfully saved into file:   " + path);
        } catch (FileNotFoundException e) {
            System.out.println("Path or file do not exist...");
        }

    }
}
