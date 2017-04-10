package model;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class Manager extends Employee implements Leader{
    private String email;

    public Manager(String name, String firstName, String startHour, String endHour, String email) {
        super(name, firstName, startHour, endHour);
        this.email = email;
    }

    public Manager(Employee employee, String email){
        super(employee.getName(), employee.getFirstName(),
                Employee.simpleDateFormatEmployee.format(employee.getStartHour()),
                Employee.simpleDateFormatEmployee.format(employee.getEndHour()));
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object o = null;
        try {
            // We retrieve the instance to return thank to
            // the method super.clone()
            o = super.clone();
        } catch(CloneNotSupportedException e) {
            // Should be never happened if we implement
            // Cloneable
            e.printStackTrace(System.err);
        }
        // We return the object
        return o;
    }
}
