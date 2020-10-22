package IP.TodoListApplication.Features;

import IP.TodoListApplication.App.Task;
import IP.TodoListApplication.App.TodoList;

import java.util.Scanner;

/**
 * This class is part of the TodoList application.
 * MarkAsDone holds all methods related to setting a task as a
 * done with task in our TodoList
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */

public class MarkAsDone extends Actions {

    /**
     * This method purpose is to act as a user guide
     * on how marking a task as done should be used for the user to
     * to ease usage and minimize crashes
     */
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("To mark a task as done, enter ID and press ENTER: ");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }


    /**
     * In this overridden method reside the implementation of
     * how this program read user's input by using a scanner inside a while loop
     * and then checking multiple points to ensure a successful performance
     * <p>
     * it will check against components completion
     * ID and task existence
     *
     * @return userInput user's inserted information
     */
    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.print("Enter task id:");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if (userInputAsNum != 0) {
                    Task task = TodoList.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("There is no task with this ID, try again: ");
                    }
                } else {
                    return userInput;
                }
            } catch (Exception err) {
                System.out.println("Enter a valid ID or 0 to RETURN");
            }
        }
    }

    /**
     * In this overridden method reside the implementation of
     * of how marking a task as done method is executed and will later be used
     * in the switch statement that runs the program
     * <p>
     * its main purpose is to set a task's status with a given ID to Done
     *
     * @param command command to look up
     */
    @Override
    public void executeAction(String command) {
        TodoList.tasks.get(command).setStatus("Done");
        System.out.println("Status is set as Done for the task with ID: " + command);

    }
}
