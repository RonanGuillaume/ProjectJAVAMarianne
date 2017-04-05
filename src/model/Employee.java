package model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class Employee extends Person{
    private UUID id;
    private Date startHour;
    private Date endHour;
    private Date creditHour;

    public Employee(String name, String firstName, Date startHour, Date endHour, Date creditHour) {
        super(name, firstName);
        this.id = UUID.randomUUID();
        this.startHour = startHour;
        this.endHour = endHour;
        this.creditHour = creditHour;
    }

    public UUID getId() {
        return id;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
    }

    public Date getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(Date creditHour) {
        this.creditHour = creditHour;
    }

    @Override
    public String toString() {
        return super.toString()+", ID : "+id.toString();
    }
}
