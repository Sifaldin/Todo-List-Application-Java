import IP.TodoListApplication.DataSorting.DateSorting;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class DateSortingTest {


    @Test
    public void isDateValid() {

        String date = "12-12-2020";

        boolean expected = true;

        assertEquals(expected, DateSorting.isDateValid("dd-MM-yyyy", date));


    }

    @Test
    public void convertDateToString() {
        LocalDate dueDate = LocalDate.of(2021, 10, 13);


        String expected = "13-10-2021";

        Assert.assertEquals(expected, DateSorting.convertDateToString(dueDate, "dd-MM-yyyy"));
    }

    @Test
    public void parseDate() {

        LocalDate expected = LocalDate.of(2020, 10, 10);

        String userInput = "10-10-2020";

        assertEquals(expected, DateSorting.parseDate("dd-MM-yyyy", userInput));
    }
}