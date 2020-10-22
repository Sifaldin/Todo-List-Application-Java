package IP.TodoListApplication.Features;

import IP.TodoListApplication.DataSorting.*;
import IP.TodoListApplication.App.*;

/**
 * This class is part of the TodoList application.
 * TasksDisplay holds all methods related to printing out
 * all the tasks to the user
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */
public class TasksDisplay extends Actions {
    /**
     * inserts a title
     */
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Here are all the tasks: ");
    }

    /**
     * This is an unsupported operation added for the sake of extending my
     * abstract class, therefore its unused.
     */
    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    /**
     * In this overridden method reside the implementation of
     * of how to display all existing tasks and how the method is executed and will later be used
     * in the switch statement that runs the program
     * <p>
     * its main purpose is to print out all existing tasks to the user
     *
     * @param command command to look up
     */
    @Override
    public void executeAction(String command) {
        TodoList.tasks.forEach((key, task) -> {
            System.out.println("ID: " + key + ", Title: " + task.getTitle() + ", Due Date: "
                    + DateSorting.convertDateToString(task.getDueDate(), "dd-MM-yyyy") + ", Status: "
                    + task.getStatus() + ", Project: " + task.getProjectName());
        });

    }
}
