package model;

import java.time.LocalDateTime;

/**
 * Created by Ronan
 * on 10/04/2017.
 */
public class Tally {
    private Employee employee;
    private LocalDateTime checkDate;

    public Tally(Employee employee, LocalDateTime checkDate) {
        this.employee = employee;
        this.checkDate = checkDate;
    }

    public LocalDateTime getCheckDate() {
        return checkDate;
    }

    public Employee getEmployee() {
        return employee;
    }
}
