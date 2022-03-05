package abc.pizaa_manage_sys;

public class Orders {
	
	int Order_id,quantity,price,Total_Price ;
	String Address,pizza_name,Order_date;
	
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal_Price() {
		return Total_Price;
	}
	public void setTotal_Price(int total_Price) {
		Total_Price = total_Price;
	}
	public String getPizza_name() {
		return pizza_name;
	}
	public void setPizza_name(String pizza_name) {
		this.pizza_name = pizza_name;
	}

}
