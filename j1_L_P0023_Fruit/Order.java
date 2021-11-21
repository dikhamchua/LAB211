package j1_L_P0023_Fruit;

import java.util.ArrayList;

public class Order {
	private String nameCustomer;
	private ArrayList<Fruit> listOrder = new ArrayList<>();
	
	public Order(String nameCustomer, ArrayList<Fruit> listFruits) {
		super();
		this.nameCustomer = nameCustomer;
		this.listOrder.addAll(listFruits);
	}
	public String getFruitID() {
		return nameCustomer;
	}
	public void setFruitID(String fruitID) {
		this.nameCustomer = fruitID;
	}
	public ArrayList<Fruit> getListOrder() {
		return listOrder;
	}
	public void setListOrder(ArrayList<Fruit> listOrder) {
		this.listOrder = listOrder;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	
	

}
