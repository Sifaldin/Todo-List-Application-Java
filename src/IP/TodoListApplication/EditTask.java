package IP.TodoListApplication;

import java.util.Scanner;

public class EditTask extends Actions {


    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("to update a task, follow the instructions and press ENTER: ");
        System.out.println("Task ID, Task Title, Due Date (format: dd-mm-yyyy), Task Status, Project Name");
        System.out.println("ID here represent the ID of the task where an update will occur");
        System.out.println("insert a (-) when an update is not needed to that specific parameter");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

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
                        if (ToDoList.tasks.get(parts[0]) != null) {
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

    @Override
    public void executeAction(String command) {

        String[] parts = command.split(",");

        boolean isTaskEdited = false;
        if (!parts[1].equals("-")) {
            ToDoList.tasks.get(parts[0]).setTitle(parts[1]);
            isTaskEdited = true;
        }

        if (!parts[2].equals("-")) {
            ToDoList.tasks.get(parts[0]).setDueDate(DateSorting.parseDate("dd-mm-yyyy", parts[2]));
            isTaskEdited = true;
        }

        if (!parts[3].equals("-")) {
            ToDoList.tasks.get(parts[0]).setStatus(parts[3]);
            isTaskEdited = true;
        }
        if (!parts[4].equals("-")) {
            ToDoList.tasks.get(parts[0]).setProjectName(parts[4]);
            isTaskEdited = true;
        }
        if (isTaskEdited) {
            System.out.println("Tasks successfully updated!!");
        } else {
            System.out.println("No change was applied...");
        }
    }
}
