package IP.TodoListApplication.App;

import IP.TodoListApplication.DataSorting.*;

import java.time.LocalDate;


/**
 * This class is part of the TodoList application.
 * <p>
 * IP.TodoListApplication.App.Task facilitates the structure of the tasks to be added,
 * help connect classes and implement features.
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */


public class Task {

    private String id;
    private String title;
    private LocalDate dueDate;
    private String status;
    private String projectName;

    /**
     * @return task's ID
     */

    public String getId() {
        return id;
    }

    /**
     * @return IP.TodoListApplication.App.Task's title
     */

    public String getTitle() {
        return title;
    }

    /**
     * @return IP.TodoListApplication.App.Task's due date
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * @return IP.TodoListApplication.App.Task's status
     */

    public String getStatus() {
        return status;
    }

    /**
     * @return IP.TodoListApplication.App.Task's project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param id IP.TodoListApplication.App.Task's ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param title IP.TodoListApplication.App.Task's title to set
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param dueDate IP.TodoListApplication.App.Task's due date to set
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @param status IP.TodoListApplication.App.Task's status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @param projectName IP.TodoListApplication.App.Task's project name to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * buildTask is used to acquire task's elements and components
     * then uses all the setters methods to build one accordingly
     *
     * @param id          IP.TodoListApplication.App.Task's ID to be set
     * @param title       IP.TodoListApplication.App.Task's title to be set
     * @param dueDate     IP.TodoListApplication.App.Task's due date to be set
     * @param status      IP.TodoListApplication.App.Task's status to be set
     * @param projectName IP.TodoListApplication.App.Task's project name to set
     * @return task task that was built accordingly with acquired elements and components
     */
    public static Task buildTask(String id, String title, LocalDate dueDate, String status, String projectName) {
        Task task = new Task();

        task.setId(id);
        task.setTitle(title);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setProjectName(projectName);

        return task;
    }

    /**
     * toString is used to represent all task's components as strings
     *
     * @return the string representation of different objects
     */

    @Override
    public String toString() {
        return id + "," + title + "," + DateSorting.convertDateToString(dueDate, "dd-MM-yyyy") + "," + status + "," + projectName;
    }

}
