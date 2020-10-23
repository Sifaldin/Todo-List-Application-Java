package IP.TodoListApplication.Features;

import IP.TodoListApplication.App.*;



import java.util.Scanner;


/**
 * This class is part of the TodoList application.
 * RemoveTask holds all methods related to removing a task as a
 * from our TodoList
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */


public class RemoveTask extends Actions {
    /**
     * This method purpose is to act as a user guide
     * on how removing a task is done and how it should be used for the user to
     * to ease their usage and minimize related crashes
     */
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("To remove a task, enter ID and press ENTER");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    /**
     * In this overridden method reside the implementation of
     * how this program read user's input by using a scanner inside a while loop
     * and then checking multiple points to ensure a successful performance
     * <p>
     * it will check against components completion
     * ID and task to be removed existence
     * and if the user correctly followed instructions
     *
     * @return userInput user's inserted information
     */
    @Override
    public String readUserInput() {

        while (true) {
            System.out.println("");
            System.out.print("Enter ID: ");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if (userInputAsNum != 0) {
                    Task task = TodoList.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("ID doesn't exist, try another ID: ");
                    }
                } else {
                    return userInput;
                }

            } catch (Exception err) {
                System.out.println("Please enter a valid ID or 0 to RETURN");
            }

        }

    }

    /**
     * In this overridden method reside the implementation of
     * of how removing an existing task is done and how the method is executed and will later be used
     * in the switch statement that runs the program
     * <p>
     * its main purpose is to remove the wanted task and confirms the completion to the user
     *
     * @param command command to look up
     */
    @Override
    public void executeAction(String command) {
        TodoList.tasks.remove(command);

        System.out.println("IP.TodoListApplication.App.Task with ID: " + command + ", was successfully removed...");

    }
}
