package IP.TodoListApplication;

import IP.TodoListApplication.App.*;

public class Main {

    /**
     * To run the program, we will create a TodoList Object
     * then we will run start on it
     *
     * Example of a task to add (pay attention to white space):
     * 5, brew beer,01-12-2020,in-progress,Hangouts
     *
     * Example of a file path to read from or save to
     * /XXXX/XXXX/XXXX/file.txt
     *
     *
     * After reading press 5 to display the tasks that were read from the file.
     *
     * Enjoy using the program!
     *
     */
    public static void main(String[] args) {


        TodoList toDoList = new TodoList();

        toDoList.start();
    }


}
