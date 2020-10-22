package IP.TodoListApplication.SaveRead;

import IP.TodoListApplication.App.TodoList;
import IP.TodoListApplication.Features.Actions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * This class is part of the TodoList application.
 * SaveTasksToFile holds all methods related to save
 * the tasks inserted by the user to a local existing file
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */

public class SaveTasksToFile extends Actions {

    /**
     * This method purpose is to act as a user guide
     * on how saving a task is done and how it should be used for the user to
     * to ease their usage and minimize related crashes
     */

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Please enter path to file:");

        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    /**
     * In this overridden method reside the implementation of
     * how this program read user's input
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
     * logged into to save information of tasks inserted by the user
     * <p>
     * it used a PrintWriter and print out a message to confirm success or failure
     *
     * @param path path to the local files for tasks to be saved in
     */
    @Override
    public void executeAction(String path) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(path));

            List<String> lines = TodoList.tasks.entrySet().stream().map(entry -> entry.getValue().toString()).collect(Collectors.toList());

            lines.forEach((line) -> {
                pw.println(line);
            });
            pw.close();
            System.out.println("task succesfully saved into file: " + path);
        } catch (FileNotFoundException e) {
            System.out.println("Path or file do not exist...");
        }

    }
}
