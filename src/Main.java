import controller.MainController;
import model.Boss;
import model.Company;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        Employee employee = new Employee("GUILLAUME", "Ronan", "08:30", "19:00");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd");
//        GregorianCalendar calendar = new GregorianCalendar(2017, 1, 0, 0, 0);
//        System.out.println(simpleDateFormat2.format(calendar.getTime()) + " day(s) " + simpleDateFormat.format(calendar.getTime()));
//        System.out.println(employee);
//        System.out.println(Employee.simpleDateFormatEmployee.format(employee.getStartHour()));
//        Tally tally = new Tally(employee, "23-15-2017 12:56");
//        System.out.println(Tally.simpleDateFormatTally.format(tally.getCheckDate()));

        Boss boss = new Boss("BOST", "Marianne", "marianne.bost@etu.univ-tours.fr");

        Company company = new Company(boss);

        MainController mainController = new MainController(company);
    }
}
