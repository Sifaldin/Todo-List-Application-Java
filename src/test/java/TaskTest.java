import IP.TodoListApplication.App.Task;
import IP.TodoListApplication.DataSorting.DateSorting;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class TaskTest {

    @Test
    public void getId() {
        Task task = new Task();

        task.setId("1");

        String expected = "1";
        assertEquals(expected, task.getId());

    }

    @Test
    public void getTitle() {
        Task task = new Task();

        task.setId("1");

        String expected = "1";
        assertEquals(expected, task.getId());
    }

    @Test
    public void getDueDate() {


        Task task = new Task();

        LocalDate dueDate = LocalDate.of(2020, 12, 12);
        task.setDueDate(dueDate);

        LocalDate expected = LocalDate.of(2020, 12, 12);

        assertEquals(expected, task.getDueDate());

    }


    @Test
    public void getStatus() {
        Task task = new Task();

        task.setTitle("Working");

        String expected = "Working";
        assertEquals(expected, task.getTitle());

    }

    @Test
    public void getProjectName() {
        Task task = new Task();

        task.setProjectName("Coding");

        String expected = "Coding";
        assertEquals(expected, task.getProjectName());

    }

    @Test
    public void setId() {
        Task task = new Task();

        task.setId("1122");

        String expected = "1122";
        assertEquals(expected, task.getId());
    }

    @Test
    public void setTitle() {
        Task task = new Task();

        task.setTitle("Clear-Cache");

        String expected = "Clear-Cache";
        assertEquals(expected, task.getTitle());

    }

    @Test
    public void setDueDate() {


        Task task = new Task();

        LocalDate dueDate = LocalDate.of(2021, 10, 13);

        task.setDueDate(dueDate);

        LocalDate expected = LocalDate.of(2021, 10, 13);

        assertEquals(expected, task.getDueDate());

    }

    @Test
    public void setStatus() {
        Task task = new Task();

        task.setStatus("in-progress");

        String expected = "in-progress";
        assertEquals(expected, task.getStatus());

    }

    @Test
    public void setProjectName() {
        Task task = new Task();

        task.setProjectName("Monthly-Supply");

        String expected = "Monthly-Supply";
        assertEquals(expected, task.getProjectName());
    }

}