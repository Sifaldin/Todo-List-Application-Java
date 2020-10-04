package com.company;

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
    public static final int READ_TASKS_FROM_FILE = 9;
    public static final int EXIT = 10;

    public abstract void showActionsInformation();

    public abstract String readUserInput();

    public abstract void executeAction(String command);



}
