package IP.TodoListApplication.Features;

import IP.TodoListApplication.DataSorting.*;
import IP.TodoListApplication.App.*;

import java.util.Scanner;


/**
 * This class is part of the TodoList application.
 * AddTask holds all methods related to adding new tasks to our
 * TodoList
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */
public class AddTask extends Actions {

    /**
     * This method purpose is to act as a user guide
     * on how adding a task should be used for the user to
     * to ease usage and minimize crashes
     */
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("To add a new task, please follow the instructions and press ENTER:");
        System.out.println("IP.TodoListApplication.App.Task ID, IP.TodoListApplication.App.Task Title, Due Date (format: dd-mm-yyyy), IP.TodoListApplication.App.Task Status, Project Name");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }


    /**
     * In this overridden method reside the implementation of
     * how this program read user's input by using a scanner inside a while loop
     * and then checking multiple points to ensure a successful performance
     * <p>
     * it will check against components completion
     * ID existence
     * validity of date
     * and if the user correctly followed instructions
     *
     * @return userInput user's inserted information
     */
    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.print("Enter Information: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals("0")) {
                String[] parts = userInput.split(",");
                if (parts.length == 5) {
                    if (DateSorting.isDateValid("dd-MM-yyyy", parts[2])) {
                        if (TodoList.tasks.get(parts[0]) == null) {
                            return userInput;
                        } else {
                            System.out.println("A task with this ID already exists, try again: ");
                        }
                    } else {
                        System.out.println("The date entered is invalid, try again: ");
                    }
                } else {
                    System.out.println("Please follow instructions, try again: ");
                }
            } else {
                return userInput;
            }
        }
    }

    /**
     * In this overridden method reside the implementation of
     * how adding a task method is executed and will later be used
     * in the switch statement that runs the program
     *
     * @param command command to look up
     */
    @Override
    public void executeAction(String command) {
        String[] parts = command.split(",");
        Task task = Task.buildTask(parts[0], parts[1], DateSorting.parseDate("dd-MM-yyyy", parts[2]),
                parts[3], parts[4]);

        TodoList.tasks.put(task.getId(), task);
        System.out.println("IP.TodoListApplication.App.Task successfully added!");

    }
}
