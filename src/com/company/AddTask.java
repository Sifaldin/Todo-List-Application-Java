package com.company;

import java.util.Scanner;

public class AddTask extends Actions {


    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("To add a new task, please follow the instructions and press ENTER:");
        System.out.println("Task ID, Task Title, Due Date (format: dd-mm-yyyy), Task Status, Project Name");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput() {
        while(true){
            System.out.println("");
            System.out.print("Enter Information: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if(!userInput.equals("0")){
                String[] parts = userInput.split(",");
                if(parts.length == 5){
                    if(DateSorting.isDateValid("dd-mm-yyyy", parts[2])){
                        if(Main.tasks.get(parts[0]) == null){
                            return userInput;
                        } else{
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

    @Override
    public void executeAction(String command) {
        String [] parts = command.split(",");
        Task task = Task.buildTask(parts[0], parts[1], DateSorting.parseDate("dd-mm-yyyy", parts[2]),
                parts[3], parts[4]);

        Main.tasks.put(task.getId(), task);
        System.out.println("Task successfully added!");

    }
}
