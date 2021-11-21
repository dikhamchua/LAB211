package j1_L_P0023_Fruit;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Fruit> listFruits = new ArrayList<>();
        List<Order> listOrders = new ArrayList<>();
        while (true) {
            // display menu
            displayMenu();
            int option = GetInput.getInt("Choice: ", "It must be a decimal positive number", 1, 5);
            switch (option) {
            case 1:
                // option 1
                Manage.createFruit(listFruits);
                break;
            case 2:
                Manage.updateFruit(listFruits);
                break;
            case 3:
                // option 2
                Manage.viewOrder(listOrders);
                break;
            case 4:
                // option 3
                Manage.shopping(listFruits, listOrders);
                break;
            case 5:
                // option 4
                System.exit(0);
                break;

            }
        }

    }

    private static void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1.	Create Fruit");
        System.out.println("2.	Update fruit");
        System.out.println("3.	View orders");
        System.out.println("4.	Shopping (for buyer)");
        System.out.println("5.	Exit");
    }

}
