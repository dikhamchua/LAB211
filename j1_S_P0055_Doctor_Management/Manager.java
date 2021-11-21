package j1_S_P0055_Doctor_Management;

import java.io.File;
import java.util.ArrayList;

public class Manager {

	public static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("========= Doctor Management ==========");
		System.out.println("    1.Add Doctor");
		System.out.println("    2.Update Doctor");
		System.out.println("    3.Delete Doctor");
		System.out.println("    4.Search Doctor");
		System.out.println("    5.Exit");

	}

	public static void addDoctor(String fileName) {
		// check file existed
		if (checkExistedFile(fileName) == false) {
			System.out.println("File not existed !!");
		}
		ArrayList<Doctor> list = new ArrayList<>();
		list.addAll(FileProcess.readData(fileName));
		System.out.println("--------- Add Doctor ----------");
		String code;
		while (true) {
			// regex:
			// a-z: matches a character from a -z
			// A-Z: matches a character from A - Z
			// 0-9: matches a character from 0-9
			// + : Match 1 or more preceding token
			code = GetInput.getString("Enter Code: ", "Code must be a string", "[a-zA-Z0-9 ]+");
			if (checkCodeExist(list, code) == true) {
				System.out.println("Invalid of Code! Code was exited in system!");
			} else {
				break;
			}
		}
		String name = GetInput.getString("Enter Name: ", "It must be a string ", "[a-zA-Z ]+");
		String specialization = GetInput.getString("Specialization: ", "It must be a string", "[a-zA-Z ]+");
		int availability = GetInput.getInt("Availability: ", "It must be a decimal postive integer ", 1,
				Integer.MAX_VALUE);
		list.add(new Doctor(code, name, specialization, availability));
		FileProcess.writeData(list, fileName);
		System.out.println("Add successfully\n");
	}

	private static boolean checkCodeExist(ArrayList<Doctor> list, String code) {
		for (Doctor doctor : list) {
			if (doctor.getCode().equalsIgnoreCase(code)) {
				return true;
			}
		}

		return false;
	}
	
	/*
	 * This function is use to update a doctor by an code 
	 * 
	 * parameter: String fileName - name of file
	 * **/
	
	public static void updateDoctorByCode(String fileName) {
		// TODO Auto-generated method stub
		ArrayList<Doctor> list = new ArrayList<>();
		list.addAll(FileProcess.readData(fileName));
		String codeBeUpdate = GetInput.getString("Enter Code: ", "Code must be a string", "[a-zA-Z0-9 ]+");
		//codeBeUpdate not exist => return
		if (checkCodeExist(list, codeBeUpdate) == false) {
			System.out.println("Code not exist !!!");
			return;
		}
		String codeWillUpdate = GetInput.getString("Code " + codeBeUpdate + " will be update to: ", 
				"Code must be a string", "[a-zA-Z0-9 ]+");
		//if doctoc's code equal to codeWillUpdate => code exist => return
		for (Doctor doctor : list) {
			if (doctor.getCode().equalsIgnoreCase(codeWillUpdate)) {
				System.out.println("Invalid code, code was existed");
				return;
			}
		}
		
		String name = GetInput.getString("Enter Name: ", "It must be a string ", "[a-zA-Z ]+");
		String specialization = GetInput.getString("Specialization: ", "It must be a string", "[a-zA-Z ]+");
		int availability = GetInput.getInt("Availability: ", "It must be a decimal postive integer ", 1,
				Integer.MAX_VALUE);
		for (Doctor doctor : list) {
			if (doctor.getCode().equalsIgnoreCase(codeBeUpdate)) {
				doctor.setCode(codeWillUpdate);
				doctor.setAvailability(availability);
				doctor.setName(name);
				doctor.setSpecialization(specialization);
			}
		}
		
		FileProcess.writeData(list, fileName);
		System.out.println("Update successfully !!\n");
	}

	/*
	 * This function is use to delete a doctor by enter a code
	 * 
	 * parameter: String fileName - name of file
	 **/
	public static void deleteDoctorByCode(String fileName) {
		ArrayList<Doctor> list = new ArrayList<>();
		ArrayList<Doctor> toRemove = new ArrayList<>();
		list.addAll(FileProcess.readData(fileName));
		String code = GetInput.getString("Enter Code: ", "Code must be a string", "[a-zA-Z0-9 ]+");
		// loop until true to find code to remove

		for (Doctor doctor : list) {
			if (doctor.getCode().equals(code)) {
				toRemove.add(doctor);
			}
		}
		//toRemove empty = not found code
		if (toRemove.isEmpty()) {
			System.out.println("Doctor with this code not exist");
		}else {
			list.removeAll(toRemove);
			System.out.println("Delete successfully !!");
		}
		
		FileProcess.writeData(list, fileName);
	}

	/*
	 * This function use to search a doctor by a string
	 * 
	 * parameter: String fileName - name of file
	 **/
	public static void searchDoctorByText(String fileName) {
		// TODO Auto-generated method stub
		ArrayList<Doctor> list = new ArrayList<>();
		list.addAll(FileProcess.readData(fileName));

		String text = GetInput.getString("Enter text: ", "It must be a string", "[0-9A-Za-z ]+");
		ArrayList<Doctor> listSearch = new ArrayList<>();
		// loop to find doctor have name which is just entered
		for (Doctor doctor : list) {
			if (doctor.getCode().contains(text) || (doctor.getAvailability() + "").contains(text)
					|| doctor.getName().contains(text) || doctor.getSpecialization().contains(text)) {
				listSearch.add(doctor);
			}
		}

		if (listSearch.isEmpty()) {
			System.out.println("Not Found Doctor !!!");
		} else {
			System.out.println("--------- Result ------------");
			String format = String.format("%-7s%-12s%-18s%s", "Code", "Name", "Specialization", "Availability");
			System.out.println(format);
			for (Doctor doctor : listSearch) {
				System.out.println(doctor);
			}
		}
		System.out.println();

	}

	/*
	 * This function use to check file exist
	 * 
	 * parameter : String fileName - name of file
	 **/
	public static boolean checkExistedFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			return true;
		}
		return false;
	}

//	public static void showData(String fileName) {
//		ArrayList<Doctor> list = new ArrayList<>();
//		list.addAll(FileProcess.readData(fileName));
//		for (Doctor doctor : list) {
//			System.out.println(doctor);
//		}
//		System.out.println();
//
//	}

}
