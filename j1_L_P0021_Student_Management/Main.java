package j1_L_P0021_Student_Management;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
        while (true) {
            displayMenu();
            int option = GetInput.getInt("Choice: ", "It must be a decimal postive number", 1, 6);
            switch (option) {
                case 1:
                    Manage.create(listStudent);
                    break;
                case 2:
                    Manage.findAndSort(listStudent);
                    break;
                case 3:
                    Manage.updateOrDelete(listStudent);
                    break;
                case 4:
                    Manage.report(listStudent);
                    break;
                case 5:
                    System.exit(0);
                    break;
                case 6:
                    Manage.showData(listStudent);
            }
        }
    }

    private static void displayMenu() {
        // TODO Auto-generated method stub
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1.	Create");
        System.out.println("2.	Find and Sort");
        System.out.println("3.	Update/Delete");
        System.out.println("4.	Report");
        System.out.println("5.	Exit\n");
    }

}
