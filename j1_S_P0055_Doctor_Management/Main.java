package j1_S_P0055_Doctor_Management;

public class Main {

    public static void main(String[] args) {
        String fileName = "doctor.dat";
        // loop until user want to exit
        while (true) {
            // display menu
            Manager.displayMenu();
            // choice option
            int choice = GetInput.getInt("Choice: ", "The choice must be a decimal number", 1, 5);
            switch (choice) {
                case 1:
                    // add doctor
                    Manager.addDoctor(fileName);
                    break;
                case 2:
                    // update doctor by id
                    Manager.updateDoctorByCode(fileName);
                    break;
                case 3:
                    // delete doctor id
                    Manager.deleteDoctorByCode(fileName);
                    break;
                case 4:
                    // search doctor by text
                    Manager.searchDoctorByText(fileName);
                    break;
                case 5:
                    // exit
                    System.exit(0);
//			case 6: 
//				Manager.showData(fileName);
//				break;
            }
        }

    }
}
