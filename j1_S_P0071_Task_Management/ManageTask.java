package j1_S_P0071_Task_Management;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManageTask {

    public void showTask(String fileName) {
        List<Task> list = FileProcess.readListTask(fileName);
        //if list is empty then tell user, else show all task
        if (list.isEmpty()) {
            System.out.println("No task in list!!! \n\n");
            return;
        }
        System.out.println("-----------------------"
                + "--------------------------------------- "
                + "Task -------------------------------------------"
                + "--------------------");
        Collections.sort(list, new Comparator<Task>() {

            @Override
            public int compare(Task o1, Task o2) {

                return o1.getId() - o2.getId();
            }
        });
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : list) {
            System.out.println(task);
        }
        System.out.println("\n\n");

    }

    public void addTask(String fileName) {
        List<Task> list = FileProcess.readListTask(fileName);
        //REGEX: 0-9: Matches a character in the range (0-9)
        // A-Z : Matches a character in the range (A-Z) 
        // + : Match 1 or more preceding token
        //\d{1,2} : a number have 1 or 2 two digit number (day and month)
        //\\d{4}  : a number have 4 digit number ( year)
        // [-] : matches character -
        //a -z : matches a character in the range a-f
        String name = GetInput.getString("Requirement Name: ",
                "Name must be a string ", "^[a-zA-Z 0-9]+$");
        int taskType = GetInput.getInt("Task Type: ",
                "Task Type must be decimal integer ", 1, 4);
        String date = GetInput.getDate("Date: ", "Format must be"
                + " dd-MM-yyyy", "\\d{1,2}[-]\\d{1,2}[-]\\d{4}");
        double planFrom = GetInput.getDouble("From: ", "From[8.0"
                + " - 17.5]", 8.0, 17.5);
        double planTo = GetInput.getDouble("To: ", "To[" + (planFrom + 0.5)
                + " - 17.5]", (planFrom + 0.5), 17.5);
        String assignee = GetInput.getString("Assignee: ",
                "Assignee must be a string ", "^[a-z A-Z]+$");
        String reviewer = GetInput.getString("Reviewer: ",
                "Reviewer must be a string ", "^[a-z A-Z]+$");
        if (checkDuplicateTask(list, date, assignee, planFrom, planTo)) {
            System.out.printf("This task in date ( %s )"
                    + "from time ( %s to %s )"
                    + " overlaps other task of assignee %s",
                    date, planFrom, planTo,
                    assignee);
            System.out.println("\nCan't add this task !!!!");
            System.out.println("\n\n");
            return;

        }

        list.add(new Task(taskType, name, date, planFrom, planTo,
                assignee, reviewer));
        System.out.println("Add successfully !!!");
        System.out.println("-----------------------"
                + "--------------------------------------- "
                + "Task -------------------------------------------"
                + "--------------------");
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        System.out.println(list.get(list.size() - 1).toString());
        System.out.println("\n\n");
        FileProcess.writeListTask(list, fileName);

    }

    private boolean checkDuplicateTask(List<Task> list, String date, String assignee, double planFrom, double planTo) {
        list = FileProcess.readListTask("task.txt");
        //loop to access all elements in list
        for (Task task : list) {
            //if date and assignee of task equal to parameter then compare to plan To
            if (task.getDate().compareTo(date) == 0 && task.getAssign().compareTo(assignee) == 0) {

                /*NOTE
            	 * from2 : parameter (user add on method "add task")
            	 * from1 : planFrom of task already in list 
            	 * to2   : parameter ( user add on method "add task")
            	 * to1   : planTo of task already in list
            	 * */
                //if from2 < from1, to2<= to1 or to2>to1 but to2 always higher than from 1
                if (planFrom < task.getPlanFrom() && planTo > task.getPlanFrom()) {
                    if (planTo <= task.getPlanTo() || planTo > task.getPlanTo()) {
                        return true;
                    }
                }
                //if from2 = from1 and to2 > from1 => return true
                if (planFrom == task.getPlanFrom() && planTo > task.getPlanFrom()) {
                    return true;
                }
                // if from2 > from1 and to2 >= to1  and from2 < to1=> return true
                if (planFrom > task.getPlanFrom() && planTo >= task.getPlanTo()
                        && planFrom < task.getPlanTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteTask(String fileName) {
        List<Task> list = FileProcess.readListTask(fileName);
        //if list empty then tell user and return
        if (list.isEmpty()) {
            System.out.println("No task in list!!!!\n\n");
            return;
        }
        System.out.println("---------Del Task------");
        int id = GetInput.getInt("ID: ", "ID must be a decimal positive number",
                0, Integer.MAX_VALUE);
        //loop from first to last elements in list
        for (int i = 0; i < list.size(); i++) {
            //if list at the index i has the id's value equal to id then
            //remove and return
            if (list.get(i).getId() == id) {
                list.remove(i);
                FileProcess.writeListTask(list, fileName);
                System.out.println("Delete Sucessfully");
                System.out.println("\n\n");
                return;
            }

        }
        System.out.println("ID not exist in database \n\n");

    }

}
