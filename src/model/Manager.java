package model;

import java.time.LocalDateTime;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class Manager extends Employee implements Leader{
    private String email;

    public Manager(String name, String firstName, LocalDateTime startHour, LocalDateTime endHour, String email) {
        super(name, firstName, startHour, endHour);
        this.email = email;
    }

    public Manager(Employee employee, String email){
        super(employee.getName(), employee.getFirstName(), employee.getStartHour(), employee.getEndHour());
        this.email = email;
    }

    @Override
    public String toString() {
        return "Manager : "+super.toString() + ", mail : " + email;
    }

    @Override
    public String getMail() {
        return email;
    }

    @Override
    public void setMail(String email) {
        this.email = email;
    }
}
