package model;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Ronan
 * on 04/04/2017.
 */
public abstract class VirtualDepartment implements Cloneable{
    private Leader leader;
    private String name;
    private HashMap<UUID, Employee> employeesList;

    public VirtualDepartment(String name, Leader leader) {
        this.leader = leader;
        this.name = name;
        this.employeesList = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public HashMap<UUID, Employee> getEmployeesList() {
        return employeesList;
    }

    public int getNbEmployees(){
        return employeesList.size();
    }

    public Employee getEmployeeById(UUID id){
        Employee result = employeesList.get(id);
        if(result == null){
            throw new IllegalArgumentException("This employee doesn't exist in this department");
        }
        return result;
    }

    public void addEmployee(Employee employee){
        employeesList.put(employee.getId(), employee);
    }

    public void removeEmployee(Employee employee){
        if(employeesList.remove(employee.getId()) == null){
            throw new IllegalArgumentException("This employee doesn't exist in this department");
        }
    }

    @Override
    public String toString() {
        return "Department : "+name+", Nb of members : "+getNbEmployees()+"Leader : "+leader;
    }
}
