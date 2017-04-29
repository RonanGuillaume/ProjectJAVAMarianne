package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class Employee extends Person{
    private UUID id;
    private LocalDateTime startHour;
    private LocalDateTime endHour;
    private LocalDateTime creditHour;
    private ArrayList<Tally> tallies;

    public Employee(String name, String firstName, LocalDateTime startHour, LocalDateTime endHour) {
        super(name, firstName);
        tallies = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.startHour = startHour;
        this.endHour = endHour;
        this.creditHour = LocalDateTime.of(0, 1, 1, 0, 0);
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalDateTime startHour) {
        this.startHour = startHour;
    }

    public LocalDateTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalDateTime endHour) {
        this.endHour = endHour;
    }

    public LocalDateTime getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(LocalDateTime creditHour) {
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
