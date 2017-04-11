package view;

import model.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ronan
 * on 11/04/2017.
 */
public class EmployeeTableModel extends AbstractTableModel {
    private ArrayList<Employee> employees;
    private String[] columnName = {"Id", "Name","First name", "Credit"};

    public EmployeeTableModel(List<Employee> employees) {
        super();
        if (employees==null){
            this.employees = new ArrayList<>();
        }
        else {
            this.employees = (ArrayList<Employee>) employees;
        }
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnName[columnIndex]){
            case "Id":
                return UUID.class;
            case "Credit":
                return Date.class;
            default:
                return String.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnName[columnIndex]){
            case "Id" :
                return employees.get(rowIndex).getId();
            case "Name" :
                return employees.get(rowIndex).getName();
            case "First name" :
                return employees.get(rowIndex).getFirstName();
            case "Credit" :
                return employees.get(rowIndex).getCreditHour();
            default:
                return null;
        }
    }

    public Employee getElementAt(int index){
        return employees.get(index);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        String employeeRowToString = employee.getId().toString();
        for (Employee myPlayerRow : employees) {
            if (myPlayerRow.getId().toString().equalsIgnoreCase(employeeRowToString)){
                employees.remove(myPlayerRow);
                break;
            }
        }
    }

    public void removeEmployeeRowAt(int index) throws Exception {
        if(index < 0 || index >= employees.size()){
            throw new Exception("Invalid index");
        }
        employees.remove(index);
    }

    public void removeAllEmployeeRows(){
        while (employees.size()>0){
            removeEmployee(getElementAt(0));
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
