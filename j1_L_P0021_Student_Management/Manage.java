package j1_L_P0021_Student_Management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manage {

    public static final String REGEX_STRING = "[a-zA-Z0-9. ]+";

    public static void create(List<Student> listStudent) {
        System.out.println("CREATE");
        System.out.println("-------------------------------------------------------");

        // loop to input data
        while (true) {
            String id = GetInput.getString("Enter ID: ", "It must be a string",
                    REGEX_STRING);
            String name;
            while (true) {
                name = GetInput.getString("Enter name: ", "It must be a string",
                        REGEX_STRING);
                if (!Validation.checkWrongName(listStudent, id, name)) {
                    break;
                }
            }
            String semester = GetInput.getString("Enter semester: ",
                    "It must be a string", REGEX_STRING);
            String course = GetInput.getCourse();

            // check duplicate
            if (Validation.checkStudentExist(listStudent, id, semester, course)) {
                System.out.println("This course was enrolled in semester " + semester);
                return;
            } else {
                listStudent.add(new Student(id, name, semester, course));
                System.out.println("Add successfull !!\n");
            }

            // if size >= 4 ask user want to continue ?
            if (listStudent.size() >= 1) {
                System.out.print("In your list have " + listStudent.size() + " student. ");
                if (!Validation.checkYesNo("continue")) {
                    return;
                }
            }
        }

    }

    public static void findAndSort(List<Student> listStudent) {
        // if list student empty => return
        if (listStudent.isEmpty()) {
            System.out.println("List student is empty !!!");
            return;
        }

        System.out.println("FIND AND SORT");
        System.out.println("--------------------------------------");

        List<Student> listSearch = new ArrayList<>();
        String name = GetInput.getString("Enter name: ", "It must be a string", REGEX_STRING);

        // loop to find student contain name and add into listSearch
        for (Student student : listStudent) {
            if (student.name.contains(name)) {
                listSearch.add(student);
            }
        }

        // check list search empty
        if (listSearch.isEmpty()) {
            System.out.println("Not Found Student !!!");
            return;
        }

        // Loop once for each element in the list.
        for (int i = 0; i < listSearch.size(); i++) {
            // Once for each element, minus the i
            for (int j = 0; j < listSearch.size() - 1 - i; j++) {
                // check if need a swap or not
                if (listSearch.get(j).name.compareTo(listSearch.get(j + 1).name) > 0) {
                    Collections.swap(listSearch, j, j + 1);
                }
            }
        }

        for (Student student : listSearch) {
            System.out.println(student);
        }

    }

    public static void updateOrDelete(List<Student> listStudent) {
        // TODO Auto-generated method stub
        // if list student empty => return
        if (listStudent.isEmpty()) {
            System.out.println("List student is empty !!!");
            return;
        }
        String idFinding;
        while (true) {
            idFinding = GetInput.getString("Input ID: ", "It must be a string", REGEX_STRING);
            if (!Validation.checkStudentExistedID(listStudent, idFinding)) {
                System.out.println("Not Found student !!!");
            } else {
                break;
            }

            if (!Validation.checkYesNo("continue")) {
                return;
            }
        }

        // check update or delete. Update == true || Delete == false
        if (Validation.updateOrDelete()) {
            updateStudent(listStudent, idFinding);
        } else {
            deleteStudent(listStudent, idFinding);
        }

    }

    private static void deleteStudent(List<Student> listStudent, String idFinding) {
        // TODO Auto-generated method stub
        List<Student> listFoundByID = GetInput.getListStudentByID(listStudent, idFinding);
        List<Student> listWillBeDelete = new ArrayList<>();
        System.out.println("DELETE");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-10s%-15s%-20s%-10s%-10s\n", "Choice", "ID", "Name",
                "Semester", "Course");
        int count = 1;
        for (Student student : listFoundByID) {
            System.out.printf("%-10s%-10s\n", count, student);
            count++;
        }

        int choice = GetInput.getInt("Student: ", "It must be a decimal positive number ",
                1, listFoundByID.size());

        Student studentInListFound = listFoundByID.get(choice - 1);
        listWillBeDelete.add(studentInListFound);

        listStudent.removeAll(listWillBeDelete);
        System.out.println("DELETE SUCCESSFULL\n");
    }

    private static void updateStudent(List<Student> listStudent, String idFinding) {
        // TODO Auto-generated method stub
        List<Student> listFoundByID = GetInput.getListStudentByID(listStudent, idFinding);
        System.out.println("UPDATE");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-10s%-15s%-20s%-10s%-10s\n", "Choice", "ID", "Name",
                "Semester", "Course");
        int count = 1;
        for (Student student : listFoundByID) {
            System.out.printf("%-10s%-10s\n", count, student);
            count++;
        }

        int choice = GetInput.getInt("Student: ", "It must be a decimal positive number ",
                 1, listFoundByID.size());

        Student studentInListFound = listFoundByID.get(choice - 1);
        // Student studentBeUpdate =
        // listStudent.get(listStudent.indexOf(studentInListFound));
        String idCanBeUpdate = studentInListFound.ID;
        String nameCanBeUpdate = studentInListFound.name;
        String semesterCanBeUpdate = studentInListFound.semester;
        String courseCanBeUpdate = studentInListFound.courseName;

        idCanBeUpdate = GetInput.getString("Enter id: ", "It must be a string ",
                REGEX_STRING);

        while (true) {
            nameCanBeUpdate = GetInput.getString("Enter name: ", "It must be"
                    + " a string", REGEX_STRING);
            if (!Validation.checkWrongName(listStudent, idCanBeUpdate,
                    nameCanBeUpdate)) {
                break;
            }
        }

        semesterCanBeUpdate = GetInput.getString("Enter semester: ", "It must"
                + " be a string", REGEX_STRING);

        courseCanBeUpdate = GetInput.getCourse();

        // check duplicate
        if (Validation.checkStudentExist(listStudent, idCanBeUpdate, semesterCanBeUpdate,
                courseCanBeUpdate)) {
            if (Validation.checkNotUpdate(idCanBeUpdate, nameCanBeUpdate,
                    semesterCanBeUpdate, courseCanBeUpdate, studentInListFound)) {
                System.out.println("You not update !!!!\n");
                return;
            }

            System.out.println("DUPLICATE !!");
            System.out.println(nameCanBeUpdate + " was enroll " + courseCanBeUpdate + " in " + semesterCanBeUpdate);
            System.out.println();
            return;
        } else {
            listStudent.get(listStudent.indexOf(studentInListFound)).setID(idCanBeUpdate);
            listStudent.get(listStudent.indexOf(studentInListFound)).setName(nameCanBeUpdate);
            listStudent.get(listStudent.indexOf(studentInListFound)).setSemester(semesterCanBeUpdate);
            listStudent.get(listStudent.indexOf(studentInListFound)).setCourseName(courseCanBeUpdate);
            System.out.println("UPDATE SUCCESSFULL\n");
        }

    }

    public static void report(List<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> listReport = new ArrayList<>();

        for (Student student1 : listStudent) {
            int total = 0;
            for (Student student2 : listStudent) {
                if (student1.ID.equalsIgnoreCase(student2.ID)
                        && student1.courseName.equalsIgnoreCase(student2.courseName)) {
                    total++;
                }
            }
            if (Validation.checkReportExist(listReport, student1.name, student1.courseName, total)) {
                listReport.add(new Report(student1.name, student1.courseName, total));
            }
        }

        // print report
        System.out.println("REPORT");
        System.out.println("-----------------------------------------------------------");
        for (Report report : listReport) {
            System.out.println(report);
        }

    }

    public static void showData(List<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List is empty");
        }
        System.out.println("SHOW DATA");
        System.out.println("-------------------------------------------------------------");
        for (Student student : listStudent) {
            System.out.println(student);
        }

    }

}
