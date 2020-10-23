package IP.TodoListApplication.Features;

import IP.TodoListApplication.App.TodoList;
import IP.TodoListApplication.DataSorting.DateSorting;

import java.util.Scanner;


/**
 * This class is part of the TodoList application.
 * EditTask holds all methods related to edit an existing task
 * to our TodoList
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */
public class EditTask extends Actions {


    /**
     * This method purpose is to act as a user guide
     * on how editing a task should be used for the user to
     * to ease usage and minimize crashes
     */
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("to update a task, follow the instructions and press ENTER: ");
        System.out.println("IP.TodoListApplication.App.Task ID, IP.TodoListApplication.App.Task Title, Due Date (format: dd-mm-yyyy), IP.TodoListApplication.App.Task Status, Project Name");
        System.out.println("ID here represent the ID of the task where an update will occur");
        System.out.println("insert a (-) when an update is not needed to that specific parameter");
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
            System.out.println("Enter information");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals(0)) {
                String[] parts = userInput.split(",");
                if (parts.length == 5) {
                    boolean dateValidationRequired = true;
                    if (parts[2].equals("-")) {
                        dateValidationRequired = false;
                    }

                    boolean isDateValid = true;
                    if (dateValidationRequired) {
                        isDateValid = DateSorting.isDateValid("dd-mm-yyyy", parts[2]);
                    }

                    if (isDateValid) {
                        if (TodoList.tasks.get(parts[0]) != null) {
                            return userInput;
                        } else {
                            System.out.println("ID doesn't exist, try again: ");
                        }
                    } else {
                        System.out.println("Please follow instructions or enter 0 to RETURN");
                    }
                } else {
                    return userInput;
                }
            }
        }


    }

    /**
     * In this overridden method reside the implementation of
     * of how editing a task method is executed and will later be used
     * in the switch statement that runs the program
     * <p>
     * and it will check against all components
     * to see if a change is applied or not
     *
     * @param command command to look up
     */
    @Override
    public void executeAction(String command) {

        String[] parts = command.split(",");

        boolean isTaskEdited = false;
        if (!parts[1].equals("-")) {
            TodoList.tasks.get(parts[0]).setTitle(parts[1]);
            isTaskEdited = true;
        }

        if (!parts[2].equals("-")) {
            TodoList.tasks.get(parts[0]).setDueDate(DateSorting.parseDate("dd-mm-yyyy", parts[2]));
            isTaskEdited = true;
        }

        if (!parts[3].equals("-")) {
            TodoList.tasks.get(parts[0]).setStatus(parts[3]);
            isTaskEdited = true;
        }
        if (!parts[4].equals("-")) {
            TodoList.tasks.get(parts[0]).setProjectName(parts[4]);
            isTaskEdited = true;
        }
        if (isTaskEdited) {
            System.out.println("Tasks successfully updated!!");
        } else {
            System.out.println("No change was applied...");
        }
    }
}
