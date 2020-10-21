package IP.TodoListApplication.SaveRead;

import IP.TodoListApplication.App.Task;
import IP.TodoListApplication.App.TodoList;
import IP.TodoListApplication.DataSorting.DateSorting;
import IP.TodoListApplication.Features.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * This class is part of the TodoList application.
 * ReadTasksFromFile holds all methods related to printing out
 * the tasks to the user from a local existing file
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */
public class ReadFromFile extends Actions {
    /**
     * This method purpose is to act as a user guide
     * on how reading a task is done and how it should be used for the user to
     * to ease their usage and minimize related crashes
     */
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Please enter path to read:");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    /**
     * In this overridden method reside the implementation of
     * how this program read user's input by using a scanner inside a while loop
     *
     * @return userInput user's inserted information
     */

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

    /**
     * In this overridden method reside the implementation of
     * of how a given path is taken from the user
     * logged into to fetch information and display it to user
     * <p>
     * IMPORTANT after executing read, press 5 to display the files that was read
     * from the file
     *
     * @param path path of the local file to be read by the program
     */

    @Override
    public void executeAction(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String file = scanner.nextLine();
                String[] parts = file.split(",");
                Task task = Task.buildTask(parts[0], parts[1], DateSorting.parseDate("dd-MM-yyyy", parts[2]),
                        parts[3], parts[4]);
                if (TodoList.tasks.get(parts[0]) != null) {
                    TodoList.tasks.replace(parts[0], task);
                } else {
                    TodoList.tasks.put(parts[0], task);
                }

            }
            scanner.close();
            System.out.println("Tasks are being read!");
        } catch (FileNotFoundException e) {
            System.out.println("Path or file do not exist...");

        }

    }
}
