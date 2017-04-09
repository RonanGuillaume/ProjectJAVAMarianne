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
        return boss;
    }

    public ManagementDepartment getManagementDepartment() {
        return managementDepartment;
    }

    public int getNbDepartments(){
        return departmentsList.size();
    }

    public StandardDepartment getDepartmentByName(String name){
        // TODO: 04/04/2017 Exception if wrong name
        return departmentsList.get(name);
    }

    public void addDepartment(StandardDepartment department){
        departmentsList.put(department.getName(), department);
    }

    public void removeDepartment(StandardDepartment standardDepartment){
        // TODO: 05/04/2017 Exception if wrong department
        departmentsList.remove(standardDepartment.getName());
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
