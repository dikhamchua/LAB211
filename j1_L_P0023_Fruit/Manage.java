package j1_L_P0023_Fruit;

import java.util.ArrayList;
import java.util.List;

public class Manage {

    public static final String REGEX_ID = "[a-zA-Z0-9 ]+";
    public static final String REGEX_NAME = "[a-zA-Z0-9 ]+";
    public static final String REGEX_ORIGIN = "[a-zA-Z0-9 ]+";

    /*
	 *This function use to create a new fruit
	 *
	 * parameter: List<Fruit> listFruits - fruit after create will store in here
	 * **/
    public static void createFruit(List<Fruit> listFruits) {
        while (true) {
            String id = GetInput.getString("Enter ID: ", "It must be a string", REGEX_ID);
            // ID exist => return
            if (Validation.isIdExist(listFruits, id)) {
                System.out.println("ID existed !!!");
                return;
            }

            String name = GetInput.getString("Enter name: ", "It must be a string",
                    REGEX_NAME);
            double price = GetInput.getDouble("Enter price: ", "It must a real number",
                    0, Double.MAX_VALUE);
            int quantity = GetInput.getInt("Enter quantity: ", "It must be a "
                    + "decimal positive number", 1, Integer.MAX_VALUE);
            String origin = GetInput.getString("Enter origin: ", "It must be a "
                    + "string", REGEX_ORIGIN);
            listFruits.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Add successfull!! \n");
            if (Validation.checkYesNo("continue") == false) {
                return;
            }

        }

    }

    /*
	 * This function is use to view order
	 * 
	 * parameter: List<Order> listOrders - list contain customer and order which is user buy
	 * **/
    public static void viewOrder(List<Order> listOrders) {
        // TODO Auto-generated method stub
        System.out.println("VIEW ORDERS");
        if (listOrders.isEmpty()) {
            System.out.println("System is empty!\n");
        }
        // traverse all element of listCustomerInvoice to display invoice
        for (Order customerOrder : listOrders) {
            String nameCustomer = customerOrder.getNameCustomer();
            ArrayList<Fruit> listOrder = new ArrayList<>();
            listOrder.addAll(customerOrder.getListOrder());
            double totalAmount = 0;
            System.out.println("Customer: " + nameCustomer);
            System.out.println(" Product | Quantity | Price | Amount");
            //traverse all element of listOrder to display fruit ordered
            for (int i = 0; i < listOrder.size(); i++) {
                int id = i + 1;
                String product = (id + ". " + listOrder.get(i).getName());
                int quantity = listOrder.get(i).getQuantity();
                double price = listOrder.get(i).getPrice();
                double amount = listOrder.get(i).getAmount();
                totalAmount = totalAmount + amount;
                System.out.printf(" %-13s%-7d%-9.1f%.1f$\n", product, quantity, price, amount);
            }
            System.out.printf("Total: %.1f$\n\n", totalAmount);
        }

    }

    /*
	 * This function is use to shopping fruit in list for buyer
	 * 
	 * parameter: List<Fruit> listForBuyer - list for user buy
	 * parameter: List<Order> listOrders - list contain name customer and orders 
	 * **/
    public static void shopping(List<Fruit> listForBuyer, List<Order> listOrders) {
        ArrayList<Fruit> listOrdering = new ArrayList<>();

        //check list for buyer empty
        if (listForBuyer.isEmpty()) {
            System.out.println("Sorry! We are sold out all fruit today\n");
            return;
        }
        while (true) {
            if (listForBuyer.isEmpty()) {
                System.out.println("Sorry! We are sold out all fruit today\n");
                break;
            }

            displayListFruit(listForBuyer);
            Fruit fruitOrder;
            while (true) {
                String item = GetInput.getString("Enter item: ", "It must be a string", REGEX_ID);
                fruitOrder = findFruit(listForBuyer, item);
                if (fruitOrder == null) {
                    System.out.println("It must be from " + listForBuyer.get(0).getId()
                            + " to " + listForBuyer.get(listForBuyer.size() - 1).getId());
                } else {
                    break;

                }
            }
            //if fruit not exist
            if (fruitOrder == null) {
                System.out.println("Fruit not exist !!\n");
                return;
            }
            System.out.println("You selected: " + fruitOrder.getName());
            int quantityOrder = GetInput.getQuantityFruitOrder(fruitOrder);

            //if not buy => return
            if (quantityOrder == 0) {
                System.out.println("You are not buy " + fruitOrder.getName());
                return;
            }

            //set quantity again of fruit
            fruitOrder.setQuantity(fruitOrder.getQuantity() - quantityOrder);
            String nameFruitOrder = fruitOrder.getName();
            double priceFruitOrder = fruitOrder.getPrice();
            String originFruitOrder = fruitOrder.getOrigin();

            //if quantity of fruit ordering = 0 => remove it from list for buyer
            if (fruitOrder.getQuantity() == 0) {
                listForBuyer.remove(fruitOrder);

            }

            boolean fruitExist = Validation.checkFruitExistedByNamePriceOrigin(listOrdering,
                    nameFruitOrder, priceFruitOrder, originFruitOrder);
            //check fruit order already exist in list ordering

            if (fruitExist == true) {
                Fruit fruitCurrent = GetInput.getFruitByNamePriceOrigin(listOrdering,
                        nameFruitOrder, priceFruitOrder, originFruitOrder);
                listOrdering.get(listOrdering.indexOf(fruitCurrent)).setQuantity(quantityOrder
                        + fruitCurrent.getQuantity());
            } else {
                listOrdering.add(new Fruit(originFruitOrder, nameFruitOrder, priceFruitOrder,
                        quantityOrder, originFruitOrder));
            }

            boolean makeOrder = Validation.checkYesNo("order now ");
            if (makeOrder == true) {
                getDisplayAllFruitOdered(listOrdering);
                break;
            }
        }
        // input name customer
        String nameCustomer = GetInput.getString("Your name: ", "It must be"
                + " a string", REGEX_NAME);
        // add new invoice in to listInvoice
        listOrders.add(new Order(nameCustomer, listOrdering));
        System.out.println("Successfully!\n");

    }

    /*
	 * this function is use to find a fruit from list fruits
	 * 
	 * parameter: List<Fruit> listFruits 
	 * parameter :  String item - id of fruit
	 * **/
    private static Fruit findFruit(List<Fruit> listFruits, String item) {
        for (Fruit fruit : listFruits) {
            if (fruit.getId().equalsIgnoreCase(item)) {
                return fruit;
            }
        }
        return null;
    }

    /*
	 * This function is use to display list fruit
	 * 
	 * parameter: List<Fruit> listFruits
	 * **/
    private static void displayListFruit(List<Fruit> listFruits) {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit fruit : listFruits) {
            System.out.printf("%-14s%-20s%-19s%.1s$", fruit.getId(),
                    fruit.getName(), fruit.getOrigin(),
                    fruit.getPrice());
            System.out.println();
        }

    }

    /*
	 * This function is to display list fruit order
	 * 
	 *  parameter: ArrayList<Fruit> listFruitOrder
	 * **/
    public static void getDisplayAllFruitOdered(ArrayList<Fruit> listFruitOrder) {
        System.out.println(" Product | Quantity | Price | Amount");
        double totalAmount = 0;
        for (int i = 0; i < listFruitOrder.size(); i++) {
            String name = listFruitOrder.get(i).getName();
            int quantity = listFruitOrder.get(i).getQuantity();
            double price = listFruitOrder.get(i).getPrice();
            double amount = listFruitOrder.get(i).getAmount();
            System.out.printf(" %-13s%-7d%-9.1f$%.1f$\n", name, quantity, price, amount);
            totalAmount = totalAmount + amount;
        }
        System.out.printf("Total: %.1f$\n", totalAmount);
    }

    public static void updateFruit(List<Fruit> listFruits) {
        String id = GetInput.getString("Enter id: ", "It must be a string", REGEX_ID);
        
        //check fruit exist => true => update quantity fruit
        if(Validation.isIdExist(listFruits, id)) {
            Fruit fruitFoundByID = findFruit(listFruits, id);
            int quantityUpdate = GetInput.getInt("Input quantity update: "
                , "It must be a decimal number", 1 , fruitFoundByID.getQuantity());

            listFruits.get(listFruits.indexOf(fruitFoundByID)).setQuantity(quantityUpdate);
            System.out.println("UPDATE SUCCESSFULL !!!\n");
        }
        //ask for create new fruit
        else {
            if(Validation.checkYesNo("create new fruit")) {
                createFruit(listFruits);
            }else {
                return;
            }
        }
    }


}
