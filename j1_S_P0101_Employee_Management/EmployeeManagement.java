package j1_S_P0101_Employee_Management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class EmployeeManagement {

    public static Employee getEmployeeByID(String id, List<Employee> employees) {
        //loop and return employee have id equal with id input
        for (Employee e : employees) {
            if (id.equals(e.getId())) {
                return e;
            }
        }
        return null;
    }

    static void updateEmployee(Employee e, String id, List<Employee> employees) {
        //loop and find index with employee have id equal with id input
        //update employee at index 
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(employees.get(i).getId(), id)) {
                employees.set(i, e);
                break;
            }
        }
    }

    static void removeEmployee(String id, List<Employee> employees) {
        //loop and find index with employee have id equal with id input
        //remove employee at index         
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equalsIgnoreCase(id)) {
                employees.remove(i);
                return;
            }
        }
    }

    static List<Employee> searchByName(List<Employee> employee, String searchValue) {
        //loop and add employee to list with employee have first 
        //or last name equal with search value        
        List<Employee> matchingList = new ArrayList<>();
        for (Employee e : employee) {
            if (e.getFirstName().contains(searchValue) || e.getLastName().contains(searchValue)) {
                matchingList.add(e);
            }
        }
        return matchingList;
    }

    static void sortBySalary(List<Employee> employees) {
        // use Comparator to sort list
        // comparingDouble to sort value double, because salary is double type
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
    }

    static void displayMenu() {
    	System.out.println("\n\n");
        System.out.println("=======MAIN MENU=======");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }
}
