package com.company;

public class TasksDisplay extends Actions {
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Here are all the tasks: ");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public void executeAction(String command) {
        ToDoList.tasks.forEach((key, task) -> {
            System.out.println("ID: " + key + ", Title: " + task.getTitle() + ", Due Date: "
                    + DateSorting.convertDateToString(task.getDueDate(), "dd-MM-yyyy") + ", Status: "
                    + task.getStatus() + ", Project: " + task.getProjectName());
        });

    }
}
