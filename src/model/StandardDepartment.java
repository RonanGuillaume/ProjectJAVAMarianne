package model;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class StandardDepartment extends VirtualDepartment{
    private Manager manager;

    public StandardDepartment(String name, Manager manager) {
        super(name);
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
