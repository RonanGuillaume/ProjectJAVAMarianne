package model;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class Company extends Observable {
    private Boss boss;
    private ManagementDepartment managementDepartment;
    private HashMap<String, StandardDepartment> departmentsList;
    private ArrayList<Tally> talliesOfTheDay;

    public Company(Boss boss) {
        this.boss = boss;
        this.managementDepartment = new ManagementDepartment(boss);
        this.departmentsList = new HashMap<>();
        this.talliesOfTheDay = new ArrayList<>();
    }

    public Boss getBoss() {
        return boss;
    }

    public ManagementDepartment getManagementDepartment() {
        return managementDepartment;
    }

    public int getNbDepartments(){
        return departmentsList.size();
    }

    public StandardDepartment getDepartmentByName(String name){
        StandardDepartment result = departmentsList.get(name);

        if(result == null){
            throw new IllegalArgumentException("This department doesn't exist in this company");
        }
        return result;
    }

    public void addDepartment(StandardDepartment department){
        departmentsList.put(department.getName(), department);

        setChanged();
    }

    public void removeDepartment(StandardDepartment standardDepartment){
        if(departmentsList.remove(standardDepartment.getName()) == null){
            throw new IllegalArgumentException("This department doesn't exist in this company");
        }
        setChanged();
    }

    public void addTally(Tally tally){
        talliesOfTheDay.add(tally);
        setChanged();
    }

    //In order to refresh our list if we are another day. We must use this method each time we make an action into the controller
    public void checkTalliesOfTheDay(){
        if (talliesOfTheDay.size() != 0){
            Date today = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (!simpleDateFormat.format(today).equalsIgnoreCase(simpleDateFormat.format(talliesOfTheDay.get(0).getCheckDate()))){
                talliesOfTheDay = new ArrayList<>();
                setChanged();
            }
        }
    }

    public HashMap<UUID, Employee> getAllEmployees(){
        HashMap<UUID, Employee> result = new HashMap<>();

        result.putAll(managementDepartment.getEmployeesList());

        for (StandardDepartment standardDepartment : departmentsList.values()) {
            result.putAll(standardDepartment.getEmployeesList());
        }

        return result;
    }


}
