package j1_L_P0023_Fruit;

public class Fruit {
	private String id;
	private String name;
	private double price;
	private int quantity;
	private String origin;
	private double amount;
	public Fruit(String id, String name, double price, int quantity, String origin) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.origin = origin;
	}
	public double getAmount() {
		return price * quantity;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Fruit() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", price=" +
                        price + ", quantity=" + quantity + ", origin="
				+ origin + "]";
	}
	
	
}
