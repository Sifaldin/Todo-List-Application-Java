package com.company;

import java.util.Scanner;

public class MarkAsDone extends Actions {

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("To mark a task as done, enter ID and press ENTER: ");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput() {
        while(true){
            System.out.println("");
            System.out.print("Enter task id:");
            Scanner in = new Scanner(System.in);
            try{
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if(userInputAsNum != 0){
                    Task task = Main.tasks.get(userInput);
                    if(task != null){
                        return userInput;
                    } else {
                        System.out.println("There is no task with this ID, try again: ");
                    }
                } else {
                    return userInput;
                }
            } catch (Exception err)   {
                System.out.println("Enter a valid ID or 0 to RETURN");
            }
        }
    }

    @Override
    public void executeAction(String command) {
        Main.tasks.get(command).setStatus("Done");
        System.out.println("Status is set as Done for the task with ID: " + command);

    }
}
