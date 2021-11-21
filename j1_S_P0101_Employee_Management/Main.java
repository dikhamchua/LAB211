package j1_S_P0101_Employee_Management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        // init List employee
        List<Employee> employee = new ArrayList<>();
        // loop until user want to exit program

        while (true) {
            
            EmployeeManagement.displayMenu();
            
            int choice = GetInput.inputChoice(1, 6);
            switch (choice) {
                case 1: {
                    //call funtion to add employee to list
                    EmployeeService.addEmployee(employee);
                    break;
                }
                case 2: {
                    //call funtion to update employee from list
                    EmployeeService.updateEmployee(employee);
                    break;
                }
                case 3: {
                    //call funtion to remove employee from list
                    EmployeeService.removeEmployee(employee);
                    break;
                }
                case 4: {
                    //call funtion to find employee by name
                    EmployeeService.searchEmployeeByName(employee);
                    break;
                }
                case 5: {
                    //call funtion to sort employee by salary
                    EmployeeService.sortBySalary(employee);
                    break;
                }
                //exit program
                case 6: {
                    return;
                }
            }
        }
    }
}
