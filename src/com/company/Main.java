package com.company;

import java.util.*;

public class Main {

    // Decided to use a LinkedHashMap because it maintains the insertion order

    public static Map<String, Task> tasks = new LinkedHashMap<>();
    public static boolean applicationRunning = true;





    public static void main(String[] args) {


                        new Main().start();

    }

    public void start(){
        showApplicationTitle();
        while (Main.applicationRunning){
            showAvailableActions();
            int actionNumber  = readAction();
            executeAction(actionNumber);

        }
    }

    public void executeAction(int actionNumber){
        Actions action;
        switch(actionNumber){
            case Actions.ADD_TASK:
                action = new AddTask();
                action.showActionsInformation();
                String command = action.readUserInput();
                if (!command.equals("0"))
                    action.executeAction(command);
                break;

            case Actions.MARK_AS_DONE:
                if(Main.tasks.size() > 0) {
                    action = new MarkAsDone();
                    action.showActionsInformation();
                    String id = action.readUserInput();
                    if (!id.equals("0"))
                        action.executeAction(id);

                } else {
                    System.out.println("Your List is empty, add tasks first! ");

                }
                break;

            case Actions.REMOVE_TASK:
                if(Main.tasks.size() > 0){
                    action = new RemoveTask();
                    action.showActionsInformation();
                    String id = action.readUserInput();
                    if(!id.equals("0"))
                        action.executeAction(id);
                }  else {
                    System.out.println("Your list is empty, add tasks first! ");
                }
                break;

            case Actions.EDIT_TASK:
                if(Main.tasks.size() > 0){
                    action = new EditTask();
                    action.showActionsInformation();
                    String editCommand = action.readUserInput();
                    if(!editCommand.equals(0))
                        action.executeAction(editCommand);
                }   else {
                    System.out.println("Your list is empty, add tasks first! ");
                }
                      break;

                case Actions.DISPLAY_ALL_TASKS:
                    if (Main.tasks.size() > 0){
                        action = new TasksDisplay();
                        action.showActionsInformation();
                        action.executeAction(null);
                    }  else {
                         System.out.println("Your list is empty, add tasks first! ");
                    }
                    break;

                    case Actions.SORT_TASKS_BY_DATE:
                        action = new DateSorting();
                        action.executeAction(null);
                        break;

            case Actions.EXIT:
                Main.applicationRunning = false;
                break;


        }
    }

    public void showApplicationTitle(){
        System.out.println("To DO List Application");
        System.out.println("-----------------------");
    }
    public void showAvailableActions(){
        System.out.println("");
        System.out.println("1. Add a task");
        System.out.println("2. Mark task as done");
        System.out.println("3. Remove task ");
        System.out.println("4. Edit task");
        System.out.println("5. Display all tasks");
        System.out.println("6. Sort tasks by date");
        System.out.println("7. sort tasks by project");
        System.out.println("8. save tasks to file");
        System.out.println("9. read tasks from file");
        System.out.println("10. Exit");
        System.out.println("");
    }
    public int readAction(){
        List<Integer> availableActions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        while(true){
            try{
                System.out.print("Enter action: ");
                Scanner scan = new Scanner(System.in);
                int action = scan.nextInt();
                if (availableActions.contains(action)){
                    return action;
                }else {
                    System.out.println("Please enter a valid action from the list: ");
                }
            } catch (Exception err){
                System.out.println("Action must be a number...");

            }
        }
    }



}
