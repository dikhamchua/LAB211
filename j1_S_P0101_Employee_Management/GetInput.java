package j1_S_P0101_Employee_Management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class GetInput {

    static String phoneRegex = "^[0-9]{9,12}$";
    static String emailRegex = "^[a-zA-Z]+[a-z0-9A-Z]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}+$";
    static Scanner scanner = new Scanner(System.in);

    static int inputChoice(int min, int max) {
        // loop until have valid choice were inputted
        while (true) {
            String input = scanner.nextLine().trim();
            //while input empty, then display message
            while (input.isEmpty()) {
                System.out.print("Choice can not empty, enter again: ");
                input = scanner.nextLine().trim();
            }
            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.print("Choice must in range [" + min + "-"
                            + max + "], enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Choice must be an integer, enter again: ");
            }
        }
    }

    static String inputID(List<Employee> employee) {

        System.out.print("ID: ");
        // loop until have valid name were inputted
        while (true) {
            String id = scanner.nextLine().trim();
            //while input empty, then display message
            while (id.isEmpty()) {
                System.out.print("ID can not empty, enter again: ");
                id = scanner.nextLine().trim();
            }
            //not special character ~> next condition
            if (checkID(id)) {
                // not duplicate ~> finish
                if (!isDuplicatedID(id, employee)) {
                    return id;
                } else {
                    System.out.print("ID is already in use "
                            + " please enter another ID: ");
                }
            } else {
                System.out.print("ID unvalible, enter again: ");
            }
        }
    }

    private static boolean checkID(String id) {
        for (int i = 0; i < id.length(); i++) {
            if ((id.charAt(i) < '0' || id.charAt(i) > '9')
                    && (id.charAt(i) < 'a' || id.charAt(i) > 'z')
                    && (id.charAt(i) < 'A' || id.charAt(i) > 'Z')) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicatedID(String id, List<Employee> employee) {
        for (Employee em : employee) {
            if (em.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    static String inputExistedID(List<Employee> employee) {
        System.out.print("Employee ID: ");
        // loop until have valid choice were inputted
        while (true) {
            String id = scanner.nextLine().trim();
            // if not empty ~> check next condition
            if (!id.isEmpty()) {
                //if duplicate ~> finish
                if (isDuplicatedID(id, employee)) {
                    return id;
                } else {
                    System.out.print("ID not found, enter again: ");
                }
                // empty string ~> display error & re-enter
            } else {
                System.out.print("ID can not empty, enter again: ");
            }
        }
    }

    static String inputString(String name) {
        System.out.print(name + ": ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            // not empty ~> finish
            if (!string.isEmpty()) {
                return upperCaseFirstChar(string);
                // empty string ~> display error & re-enter
            } else {
                System.out.print(name + " can not empty, enter again: ");
            }
        }
    }

    static String inputName(String name) {
        System.out.print(name + ": ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!string.isEmpty()) {
                if (isValidStringLetter(string)) {
                    return upperCaseFirstChar(string);
                } else {
                    System.out.print(name + " can not contain special "
                            + "characters or digits, enter again: ");
                }
                // empty string ~> display error & re-enter
            } else {
                System.out.print(name + " can not empty, enter again: ");
            }
        }
    }

    private static boolean isValidStringLetter(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    private static String upperCaseFirstChar(String stringInput) {
        String[] strA = stringInput.replaceAll("\\s+", " ").trim().split(" ");
        if (stringInput.replaceAll(" ", "").isEmpty()) {
            return null;
        }
        String tmp;
        StringBuilder result = new StringBuilder();
        for (String s : strA) {
            s = s.toLowerCase();
            if (s.length() == 1) {
                result.append(s.toUpperCase()).append(" ");
                continue;
            }
            tmp = s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
            result.append(tmp);
        }
        return result.toString().trim();
    }

    static String inputPhone() {
        System.out.print("Phone number: ");
        // loop until have valid phone number were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            // not empty ~> check next condition
            if (!raw.isEmpty()) {
                if (checkPhone(raw)) {
                    return raw;
                }
                // empty string ~> display error & re-enter
            } else {
                System.out.print("Phone number can not empty, enter again: ");
            }
        }
    }

    private static boolean checkPhone(String stringPhone) {
        Pattern p = Pattern.compile(phoneRegex);
        String s = stringPhone.substring(1);
        if (stringPhone.charAt(0) == '0') {
            //if empty ~> display message
            if (s.isEmpty()) {
                System.out.print("Phone number can not empty, enter again: ");
                return false;
            }
            if (p.matcher(s).find()) {
                return true;
            } else {
                System.out.print("Phone must a string of numbers and has 10 or 11 digits, enter again: ");
                return false;
            }
        } else {
            System.out.print("Phone number must start by '0', enter again: ");
            return false;
        }
    }

    static String inputEmail() {
        System.out.print("Email: ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            string = string.replace("\\s+", " ");
            Pattern p = Pattern.compile(emailRegex);
            if (!string.isEmpty()) { // not empty ~> finish
                if (p.matcher(string).find()) {
                    return string;
                } else {
                    System.out.print("Email must in format "
                            + "[Name+Name or number@Domain(domain.something(.domain2.domain3))(max 3 '.')]\n"
                            + "ex:vinhpkhe153482@fpt.edu.vn\nenter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Email can not empty, enter again: ");
            }
        }
    }

    static String inputSearchValue() {
        System.out.print("Enter search keywords: ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            string = string.replace("\\s+", " ");
            if (!string.isEmpty()) { // not empty ~> finish
                return string;
            } else { // empty string ~> display error & re-enter
                System.out.print("String can not empty, enter again: ");
            }
        }
    }

    static Date inputDate() {
        System.out.print("Date of birth: ");
        // loop until have valid name were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(raw);
                    String result_str = sdf.format(date);
                    if (result_str.equals(raw)) {
                        return date;
                    } else {
                        System.out.print("Please enter a right date, enter again: ");
                    }
                } catch (ParseException e) {
                    System.out.print("Date of birth must in format dd/MM/yyyy, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Date of birth can not empty, enter again: ");
            }
        }
    }

    static boolean checkAge(Date day) {
        Calendar now = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        dob.setTime(day);

        if (dob.after(now)) {
            System.out.println("Can't be born in the future");
            return false;
        }
        int year1 = now.get(Calendar.YEAR);
        int year2 = dob.get(Calendar.YEAR);
        int age = year1 - year2;
        int month1 = now.get(Calendar.MONTH);
        int month2 = dob.get(Calendar.MONTH);
        if (month2 > month1) {
            age--;
        } else if (month1 == month2) {
            int day1 = now.get(Calendar.DAY_OF_MONTH);
            int day2 = dob.get(Calendar.DAY_OF_MONTH);
            if (day2 > day1) {
                age--;
            }
        }
        return true;

    }

    static String inputSex() {
        System.out.println("1.Male");
        System.out.println("2.FeMale");
        System.out.println("3.Other");
        Map<Integer, String> sexMap = new HashMap<>();
        sexMap.put(1, "Male");
        sexMap.put(2, "FeMale");
        sexMap.put(2, "Other");
        System.out.print("Sex: ");
        int choice = inputChoice(1, 3);
        return sexMap.get(choice);
    }

    static double inputSalary() {
        System.out.print("Salary: ");
        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                try {
                    double price = Double.parseDouble(raw);
                    if (price > 0) {
                        return price;
                    } else {
                        System.out.print("Salary must more than 0, enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Salary must be a numberical value, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Salary can not empty, enter again: ");
            }
        }
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
//

    static boolean checkExistedID(List<Employee> employees, String id) {
        for (Employee employee : employees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

}
