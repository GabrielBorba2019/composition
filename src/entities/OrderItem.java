package entities;

public class OrderItem {
	
	private Integer quantity;
	private double price;
	
	//Composição - pois uma Order  é composto de 1 product
	private Product product;

	public OrderItem() {
		
	}
	
	public OrderItem(Integer quantity, double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
		
	}
	
	public Product getProduct() {
		return this.product;

	}
	
	public void setProduct() {
		this.setProduct();
	}
	
	//Método que calcula o subtotal dos produtos
	public double subTotal() {
		return this.price = quantity * product.getPrice();
	}
}
