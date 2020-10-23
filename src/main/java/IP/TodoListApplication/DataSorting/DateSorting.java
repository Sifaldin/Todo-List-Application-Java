package IP.TodoListApplication.DataSorting;

import IP.TodoListApplication.Features.Actions;
import IP.TodoListApplication.App.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


/**
 * This class is part of the TodoList application.
 * DateSorting holds all methods and functions to sort tasks by their due date
 *
 * @author Sif Aldin Abbas
 * @version 2020.10.24
 */

public class DateSorting extends Actions {

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
     * to compare our tasks and sort them according to their date value
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
            public int compare(Map.Entry<String, Task> task1, Map.Entry<String, Task> task2) {
                LocalDate dueDateFirstTask = task1.getValue().getDueDate();
                LocalDate dueDateSecondTask = task2.getValue().getDueDate();
                int result = dueDateFirstTask.compareTo(dueDateSecondTask);
                return result;
            }

        });

        TodoList.tasks.clear();
        entries.forEach((entry) -> {
            TodoList.tasks.put(entry.getKey(), entry.getValue());
        });

        System.out.println("Tasks successfully Sorted!");

    }

    /**
     * isDateValid confirms the validity of the inserted date
     * by creating Local Date and parsing it then formatting it
     * to the pattern inserted in the method parameter
     *
     * @param format correct format of the date
     * @param value  value that equals the component in the task format
     * @return result result as a boolean expression
     */

    public static boolean isDateValid(String format, String value) {
        DateTimeFormatter formattings = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate localDate = LocalDate.parse(value, formattings);

            String result = localDate.format(formattings);

            return result.equals(value);
        } catch (DateTimeParseException err) {

        }
        return false;
    }

    /**
     * This method return a string format of the LocalDate date
     * to be added and returned to the console
     *
     * @param date   due date
     * @param format date format pattern
     * @return date as a string
     */
    public static String convertDateToString(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String result = null;
        try {
            result = date.format(formatter);

        } catch (DateTimeParseException e) {

        }
        return result;
    }

    /**
     * parseDate parses a string representation of the given date
     *
     *
     * @param format date format pattern
     * @param value  value that equals the component in the task format
     * @return localDate  parsed of the given String date
     */
    public static LocalDate parseDate(String format, String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(value, formatter);
        return localDate;
    }
}
