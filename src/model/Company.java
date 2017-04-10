package model;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public class Company {
    private Boss boss;
    private ManagementDepartment managementDepartment;
    private HashMap<String, StandardDepartment> departmentsList;

    public Company(Boss boss) {
        this.boss = boss;
        this.managementDepartment = new ManagementDepartment(boss);
        this.departmentsList = new HashMap<>();
    }

    public Boss getBoss() {
        Boss result = null;
        try {
            result = (Boss) boss.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
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
    }

    public void removeDepartment(StandardDepartment standardDepartment){
        if(departmentsList.remove(standardDepartment.getName()) == null){
            throw new IllegalArgumentException("This department doesn't exist in this company");
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
