package model;

/**
 * Created by Ronan
 * on 05/04/2017.
 */
public interface Leader{
    String getMail();
    void setMail(String email);
    Object clone() throws CloneNotSupportedException;
}
