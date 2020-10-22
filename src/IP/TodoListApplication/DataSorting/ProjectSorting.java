package IP.TodoListApplication.DataSorting;


import IP.TodoListApplication.Features.Actions;
import IP.TodoListApplication.App.*;

import java.util.*;

/**
 * This class is part of the TodoList application.
 * ProjectSorting holds all methods and functions to sort tasks by their project name
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */
public class ProjectSorting extends Actions {

    /**
     * This is an unsupported operation added for the sake of extending my
     * abstract class, therefore its unused.
     */

    @Override
    public void showActionsInformation() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
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
     * In this overridden method resides the implementation
     * to compare our tasks and sort them according to their project name value
     * <p>
     * then our map will be cleared, sorted data will be inserted
     * and a message confirming the completion of tast to the user will be printed
     *
     * @param command command to look up
     */
    @Override
    public void executeAction(String command) {
        List<Map.Entry<String, Task>> entries = new ArrayList<>(TodoList.tasks.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Task>>() {
            @Override
            public int compare(Map.Entry<String, Task> firstTask, Map.Entry<String, Task> secondTask) {
                String firstProject = firstTask.getValue().getProjectName();
                String secondProject = secondTask.getValue().getProjectName();

                int result = firstProject.compareTo(secondProject);
                return result;
            }


        });

        TodoList.tasks.clear();
        entries.forEach(entry -> {
            TodoList.tasks.put(entry.getKey(), entry.getValue());
        });

        System.out.println("Tasks successfully sorted");
    }
}
