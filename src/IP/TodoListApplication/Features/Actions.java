package IP.TodoListApplication.Features;

/**
 * This abstract class is part of the TodoList application.
 * Actions holds all methods to shared among all features and sorting classes
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */

public abstract class Actions {

    //Capitalizing all letters and separating them by underscores is a java naming
    //convention when naming constant variables

    public static final int ADD_TASK = 1;
    public static final int MARK_AS_DONE = 2;
    public static final int REMOVE_TASK = 3;
    public static final int EDIT_TASK = 4;
    public static final int DISPLAY_ALL_TASKS = 5;
    public static final int SORT_TASKS_BY_DATE = 6;
    public static final int SORT_TASKS_PROJECT = 7;
    public static final int SAVE_TASKS_TO_FILE = 8;
    public static final int READ_FROM_FILE = 9;
    public static final int EXIT = 10;

    /**
     * This method refers to the list of tasks
     * and how it should be used to be printed to the
     * user among all features classes, it's main purpose is
     * to ease usage and minimize crashes
     */
    public abstract void showActionsInformation();

    /**
     * This method will represent all implementations related
     * to reading user input to carry on with performing all tasks
     */
    public abstract String readUserInput();

    /**
     * This method will represent all implementations related
     * to executing each task from user input and user wanted tasks
     * to carry on with performing all implementations necessary
     */
    public abstract void executeAction(String command);


}
