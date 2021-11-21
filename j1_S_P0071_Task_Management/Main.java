package j1_S_P0071_Task_Management;


public class Main {

    public static void main(String[] args) {
        ManageTask manageTask = new ManageTask();
        
        String fileName = "task.txt";
        while (true) {
            // display menu
            displayMenu();
            int option = GetInput.getInt("> Choose: ", "The option "
                    + "must be a decimal postive number", 1, 4);

            switch (option) {
                case 1:
                    // Add task
                    manageTask.addTask(fileName);

                    break;
                case 2:
                    // delete task
                    manageTask.deleteTask(fileName);
                    break;
                case 3:
                    // Show task
                    manageTask.showTask(fileName);

                    break;
                case 4:
                    // Exit
                    System.exit(0);
                    break;

            }

        }

    }

    private static void displayMenu() {
        System.out.println("========= Task program =========");
        System.out.println("1.	Add Task\r\n"
                + "2.	Delete task\r\n"
                + "3.	Display Task\r\n"
                + "4.	Exit\r\n"
                + "");
    }

}
