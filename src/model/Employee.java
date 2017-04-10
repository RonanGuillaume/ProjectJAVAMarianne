package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private ArrayList<Tally> tallies;


    public static SimpleDateFormat simpleDateFormatEmployee = new SimpleDateFormat("HH:mm");

    public Employee(String name, String firstName, String startHour, String endHour) {
        super(name, firstName);
        tallies = new ArrayList<>();
        this.id = UUID.randomUUID();
        try {

            this.startHour = simpleDateFormatEmployee.parse(startHour);
            this.endHour = simpleDateFormatEmployee.parse(endHour);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.creditHour = new Date(0);
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

    public Tally getLastTally(){
        return tallies.get(tallies.size() - 1);
    }

    public void addTally(Tally tally){
        // TODO: 10/04/2017 Update credits
        tallies.add(tally);
    }

    @Override
    public String toString() {
        return super.toString()+", ID : "+id.toString();
    }
}
