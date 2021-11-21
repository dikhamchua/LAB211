package j1_S_P0101_Employee_Management;

import static j1_S_P0101_Employee_Management.GetInput.scanner;
import java.util.Date;
import java.util.List;

public class EmployeeService {

    static Employee inputEmployee(List<Employee> employees) {
        String id = GetInput.inputID(employees);
        String firstName = GetInput.inputName("First name");
        String lastName = GetInput.inputName("Last name");
        String phone = GetInput.inputPhone();
        String email = GetInput.inputEmail();
        String address = GetInput.inputString("Address");
        Date DOB = GetInput.inputDate();
        while (!GetInput.checkAge(DOB)) {
            System.out.println("Re-enter DOB");
            DOB = GetInput.inputDate();
        }

        String sex = GetInput.inputSex();
        double salary = GetInput.inputSalary();
        String acency = GetInput.inputString("Agency");
        return new Employee(id, firstName, lastName, phone, email, address, DOB, sex, salary, acency);
    }

    // add Employee
    static void addEmployee(List<Employee> employees) {
        // loop until user inout value correct.
        while (true) {
            Employee employee = inputEmployee(employees);
            if (employee == null) {
                if (checkYesNo("Press \"Y\" if you want to add another employee,"
                        + " press \"N\" if you want to end the action.")) {
                    return;
                } else {
                    continue;
                }
            }
            employees.add(employee);
            System.out.println("\n\n");
            System.out.println("Add employee successful.");
            System.out.println("LIST EMPLOYEES");
            displayAll(employees);
            System.out.println("\n");
        }
        
    }

    //displayAll
    static void displayAll(List<Employee> employees) {
        displayHeader();
        //loop list employee to display
        for (Employee e : employees) {
            e.display();
        }
    }
    static boolean checkExistedID(List<Employee> employees, String id) {
        for (Employee employee : employees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    
    //update Employee
    static void updateEmployee(List<Employee> employees) {
        //check size list, if list empty ~> return
        if (!checkList(employees)) {
            return;
        }

        do {
            //check id is existed
            String id = GetInput.inputExistedID(employees);

            Employee employee = EmployeeManagement.getEmployeeByID(id, employees);
            if (checkYesNo("Do you want to update id? Choose Yes(Y) to update, No(N) to continue.")) {
                String idUpdate = GetInput.inputString("ID");
                while (checkExistedID(employees, idUpdate)) {
                    System.out.println("ID existed, please choose another ID");
                    idUpdate = GetInput.inputString("Re-enter ID");
                }
                employee.setId(idUpdate);
            }

            if (checkYesNo("Do you want to update first name? Choose Yes(Y)"
                    + " to update, No(N) to continue.")) {
                String firstName = GetInput.inputName("First name");
                employee.setFirstName(firstName);
            }
            if (checkYesNo("Do you want to update last name? Choose Yes(Y)"
                    + " to update, No(N) to continue.")) {
                String lastName = GetInput.inputName("Last name");
                employee.setLastName(lastName);
            }
            if (checkYesNo("Do you want to update phone? Choose Yes(Y) to"
                    + " update, No(N) to continue.")) {
                String phone = GetInput.inputPhone();
                employee.setPhoneNumber(phone);
            }
            if (checkYesNo("Do you want to update email? Choose Yes(Y) to "
                    + "update, No(N) to continue.")) {
                String email = GetInput.inputEmail();
                employee.setEmail(email);
            }
            if (checkYesNo("Do you want to update addres? Choose Yes(Y) to "
                    + "update, No(N) to continue.")) {
                String address = GetInput.inputString("Address");
                employee.setAddress(address);
            }
            if (checkYesNo("Do you want to update date of birth? Choose Yes(Y)"
                    + " to update, No(N) to continue.")) {
                Date DOB = GetInput.inputDate();
                while (!GetInput.checkAge(DOB)) {
                    System.out.println("Re-enter DOB");
                    DOB = GetInput.inputDate();
                }
                employee.setDOB(DOB);
            }
            if (checkYesNo("Do you want to update sex? Choose Yes(Y)"
                    + " to update, No(N) to continue.")) {
                String sex = GetInput.inputSex();
                employee.setSex(sex);
            }
            if (checkYesNo("Do you want to update salary? Choose Yes(Y)"
                    + " to update, No(N) to continue.")) {
                double salary = GetInput.inputSalary();
                employee.setSalary(salary);
            }
            if (checkYesNo("Do you want to update agency? Choose Yes(Y)"
                    + " to update, No(N) to continue.")) {
                String acency = GetInput.inputString("Agency");
                employee.setAgency(acency);
            }
            EmployeeManagement.updateEmployee(employee, id, employees);
            System.out.println("Update employee successful.");
            System.out.println("LIST PRODUCTS");
            displayAll(employees);
        } while (checkYesNo("Press \"Y\" if you want to keep taking action,"
                + " press \"N\" if you want to end the action."));
        System.out.println("Update all employees successful.");

    }

    //remove Employee
    static void removeEmployee(List<Employee> employees) {
        do {
            //if list empty ~> return
            if (!checkList(employees)) {
                return;
            }
            String id = GetInput.inputExistedID(employees);
            EmployeeManagement.removeEmployee(id, employees);
            System.out.println("Remove employee successful.");
            System.out.println("LIST PRODUCTS");
            displayAll(employees);

        } while (checkYesNo("Press \"Y\" if you want to keep taking action,"
                + " press \"N\" if you want to end the action."));
    }

    //search Employee by name
    static void searchEmployeeByName(List<Employee> employees) {
        //if list empty ~> return
        if (!checkList(employees)) {
            return;
        }
        do {
            String searchValue = GetInput.inputSearchValue();
            List<Employee> searched = EmployeeManagement.searchByName(employees, searchValue);
            if (searched.isEmpty()) {
                System.out.println("There are no employee match with "
                        + "\"" + searchValue + "\"");
                return;
            }
            System.out.println("LIST OF EMPLOYEES FOUND");
            displayAll(employees);
        } while (checkYesNo("Press \"Y\" if you want to keep taking action,"
                + " press \"N\" if you want to end the action."));
    }

    //sort by salary
    static void sortBySalary(List<Employee> employees) {
        //if list empty ~> return
        if (!checkList(employees)) {
            return;
        }

        System.out.println("LIST BEFORE SORT:");
        displayAll(employees);
        EmployeeManagement.sortBySalary(employees);
        System.out.println("LIST AFTER SORT:");
        displayAll(employees);
    }

    static boolean checkList(List<Employee> employees) {
        //if list employee empty,then display message
        if (employees.isEmpty()) {
            System.out.println("Please enter employee first.");
            return false;
        }
        return true;
    }

    private static void displayHeader() {
        System.out.printf("%-10s | %-11s | %-11s | %-20s | %-20s | %-18s | "
                + "%-15s | %-8s | %-10s | %-15s\n",
                "Id", "FirstName", "LastName", "Phone number", "Email",
                "Address", "Date of birth", "Sex", "Salary", "Agency");
    }
    
    static boolean checkYesNo(String notification) {
        System.out.println(notification);
        System.out.print("Enter your choice: ");
        while (true) {
            String s = scanner.nextLine();
            if (!s.isEmpty()) {
                s = s.replaceAll(" ", "");
                if (s.equalsIgnoreCase("Y")) {
                    return true;
                }
                if (s.equalsIgnoreCase("N")) {
                    return false;
                }
                System.out.print("You must choose Yes(Y) or No(N)!\nEnter again: ");
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }
}
