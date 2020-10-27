package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	// Método que formata as datas a serem impressas
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;

	// Composition ( Cliente ) (OrderItem)
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	// Métodos
	public void addItem(OrderItem item) {
		itens.add(item);
	}

	public void removeItem(OrderItem item) {
		itens.remove(item);
	}

	public double total() {
		double sum = 0;
		for (OrderItem x : itens) {
			sum += x.getPrice();
		}
		return sum;
	}

	@Override

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Moment: " + sdf.format(this.moment));
		sb.append("\nOrder status: " + this.status);
		sb.append("\nClient: " + client.getName());
		sb.append(" (" + sdf2.format(client.getBirthDate()) + ")");
		sb.append(" - " + client.getEmail());
		sb.append("\nOrder items:");
		for (OrderItem c : itens) {
			sb.append("\n" + c.getProduct().getName() 
					+ ", " + String.format("$%.2f", c.getProduct().getPrice())
					+ ", Quantity: " + c.getQuantity() 
					+ ", Subtototal: " + String.format("$%.2f", c.subTotal()));
			
		}
		return sb.toString();

	}

}
