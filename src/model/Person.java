package model;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public abstract class Person implements Cloneable{
    private String name;
    private String firstName;

    public Person(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Name : "+name+", First name : "+firstName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
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
