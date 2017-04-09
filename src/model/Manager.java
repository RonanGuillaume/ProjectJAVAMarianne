package model;

import java.util.Date;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class Manager extends Employee implements Leader{
    private String email;

    public Manager(String name, String firstName, Date startHour, Date endHour, Date creditHour, String email) {
        super(name, firstName, startHour, endHour, creditHour);
        this.email = email;
    }

    public Manager(Employee employee, String email){
        super(employee.getName(), employee.getFirstName(), employee.getStartHour(), employee.getEndHour(), employee.getCreditHour());
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
