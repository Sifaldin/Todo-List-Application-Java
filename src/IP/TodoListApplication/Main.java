package IP.TodoListApplication;

import IP.TodoListApplication.App.*;

public class Main {

    /**
     *
     * Example of a task: 5, brew beer,01-12-2020,in-progress,Hangouts
     *
     * Example of a file path to read from or save to /Users/sifaldinabbas/Downloads/ToDoList/file.txt
     *
     */

    
    public static void main(String[] args) {


        ToDoList toDoList = new ToDoList();

        toDoList.start();
    }


}
