package controller;

import model.Company;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ronan
 * on 11/04/2017.
 */
public class MainController implements ActionListener{
    private Company company;
    private MainView mainView;

    public MainController(Company company) {
        this.company = company;
        this.mainView = new MainView(this);
        this.company.addObserver(mainView);
        mainView.update(company, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            default:
                mainView.showError("Invalid action performed");
        }
    }
}
