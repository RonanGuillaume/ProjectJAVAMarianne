package model;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class Boss extends Person implements Leader{
    private String email;

    public Boss(String name, String firstName, String email) {
        super(name, firstName);
        this.email = email;
    }

    @Override
    public String toString() {
        return "Boss : "+super.toString() + ", mail : " + email;
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
