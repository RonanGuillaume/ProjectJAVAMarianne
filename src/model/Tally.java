package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ronan
 * on 10/04/2017.
 */
public class Tally {
    private Employee employee;
    private Date checkDate;

    public static SimpleDateFormat simpleDateFormatTally = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public Tally(Employee employee, String checkDate) {
        try {
            this.employee = employee;
            this.checkDate = simpleDateFormatTally.parse(checkDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public Employee getEmployee() {
        return employee;
    }
}
