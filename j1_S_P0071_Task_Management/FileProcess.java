package j1_S_P0071_Task_Management;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choutputStreame License Headers in Project Properties.
 * To change this template file, choutputStreame Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class FileProcess {

    public static List<Task> readListTask(String fileName) {

        File file = new File(fileName);
        // Check File is exist or not
        if (!file.exists()) {
            System.out.println("File not existed in system!\n");
            FileProcess.writeListTask(new ArrayList<>(), fileName);
        }
        // Read data from file
        FileInputStream fileInput = null;
        ObjectInputStream inputStream = null;
        try {
            fileInput = new FileInputStream(fileName);
            inputStream = new ObjectInputStream(fileInput);
            // Read information in List from File
            List<Task> listAccount = (List<Task>) inputStream.readObject();

            return listAccount;
        } catch (FileNotFoundException e) {
            System.err.println("File not found Exception");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("Class not found Exception");
        } finally {
            try {
                fileInput.close();
                inputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return new ArrayList<>();
    }

    public static void writeListTask(List<Task> list, String fileName) {

        FileOutputStream fileOutput = null;
        ObjectOutputStream outputStream = null;
        try {
            fileOutput = new FileOutputStream(fileName);
            outputStream = new ObjectOutputStream(fileOutput);
            outputStream.writeObject(list);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                fileOutput.close();
                outputStream.close();
            } catch (IOException ex) {
                System.err.println("IO Exception");
            }
        }

    }
}
