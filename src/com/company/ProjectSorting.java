package com.company;

import java.util.*;

public class ProjectSorting extends Actions {
    @Override
    public void showActionsInformation() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public String readUserInput() {

        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public void executeAction(String command) {
        List<Map.Entry<String, Task>> entries = new ArrayList<>(ToDoList.tasks.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Task>>() {
            @Override
            public int compare(Map.Entry<String, Task> firstTask, Map.Entry<String, Task> secondTask) {
                String firstProject = firstTask.getValue().getProjectName();
                String secondProject = secondTask.getValue().getProjectName();

                int result = firstProject.compareTo(secondProject);
                return result;
            }


        });
        ToDoList.tasks.clear();
        entries.forEach((entry) -> {
            ToDoList.tasks.put(entry.getKey(), entry.getValue());

        });

        System.err.println("");
        System.out.println("Tasks successfully sorted");
    }
}
