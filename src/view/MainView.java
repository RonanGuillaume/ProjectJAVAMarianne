package view;

import model.Company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Ronan
 * on 11/04/2017.
 */
public class MainView extends AbstractView{
    private JPanel mainPanel;
    private JButton exitButton;
    private JButton button2;
    private JTabbedPane tabbedPanel;
    private JPanel staffManagementPanel;
    private JPanel departmentManagementPanel;
    private JPanel globalCheckInOutHistoryPanel;
    private JPanel howIsYourDayPanel;
    private JButton addEmployeeButton;
    private JButton fireThisEmployeeButton;
    private JButton modifyThisEmployeeButton;
    private JTable employeeTable;
    private JButton addDepartmentButton;
    private JButton deleteThisDepartmentButton;
    private JButton modifyThisDepartmentButton;
    private JTable departmentTable;
    private JTable tallyTodayTable;
    private JTable tallyTable;

    private EmployeeTableModel employeeTableModel;

    public MainView(ActionListener actionListener) {
        super("House of cards");

        //Set margin
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        setContentPane(mainPanel);

        if(actionListener != null){
            registerListener(actionListener);
        }

        employeeTableModel = new EmployeeTableModel(new ArrayList<>());
        employeeTable.setModel(employeeTableModel);
        employeeTable.updateUI();

        improvePlacement();

        //Action when we click on exit
        exitButton.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        //Default button
//        getRootPane().setDefaultButton(startAGameButton);

        setVisible(true);
    }

    @Override
    public void registerListener(ActionListener actionListener) {

    }

    @Override
    public void update(Observable o, Object arg) {
        Company company = (Company) o;

        employeeTableModel.setEmployees(new ArrayList<>(company.getAllEmployees().values()));
        employeeTable.updateUI();
    }
}
