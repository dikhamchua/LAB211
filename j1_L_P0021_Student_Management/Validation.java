package j1_L_P0021_Student_Management;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private static final String REGEX_UPDATE_DELETE = "[uUdD]";
    private static final String REGEX_YES_NO = "^[yYnN]$";

    public static boolean checkStudentExist(List<Student> listStudent, String id, String semester, String course) {
        for (Student student : listStudent) {
            if (student.ID.equalsIgnoreCase(id) && student.semester.equalsIgnoreCase(semester)
                    && student.courseName.equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkYesNo(String msg) {
        String result = GetInput.getString("Do you want to " + msg + " (Y/N)? ",
                "Please enter (Y/N) !!!", REGEX_YES_NO);
        if (result.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    public static boolean checkStudentExistedID(List<Student> listStudent, String id) {
        // TODO Auto-generated method stub
        for (Student student : listStudent) {
            if (student.ID.equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkReportExist(ArrayList<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.studentName)
                    && course.equalsIgnoreCase(report.courseName)
                    && total == report.totalCourse) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWrongName(List<Student> listStudent, String id, String name) {
        // TODO Auto-generated method stub
        for (Student student : listStudent) {
            if (student.ID.equalsIgnoreCase(id) && !student.name.equalsIgnoreCase(name)) {
                System.out.println(id + " must be has name " + student.name);
                return true;
            }
        }
        return false;
    }

    public static boolean updateOrDelete() {
        // TODO Auto-generated method stub
        String result = GetInput.getString("Do you want to update (U) or delete (D) student? ",
                 "It must be in [U or D]", REGEX_UPDATE_DELETE);
        if (result.equalsIgnoreCase("u")) {
            return true;
        }
        return false;
    }

    public static boolean checkNotUpdate(String idCanBeUpdate, String nameCanBeUpdate, String semesterCanBeUpdate,
            String courseCanBeUpdate, Student studentInListFound) {
        if (idCanBeUpdate.equals(studentInListFound.ID)
                && nameCanBeUpdate.equals(studentInListFound.name)
                && semesterCanBeUpdate.equals(studentInListFound.semester)
                && courseCanBeUpdate.equals(studentInListFound.courseName)) {
            return true;
        }
        return false;
    }

}
