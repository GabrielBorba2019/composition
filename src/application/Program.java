package application;

import entities.*;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY):");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();
		Client client = new Client(name, email, birthDate);

		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		Date moment = new Date();
		
		Order order = new Order(moment, OrderStatus.valueOf(orderStatus), client);
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int productQuantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(productQuantity,
					productPrice, 
					product);
			order.addItem(item);
		}
		
		System.out.println("ORDER SUMARY: ");
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName()+
				"(" + order.getClient().getBirthDate() + ")"
				+" - " + order.getClient().getEmail());
		System.out.println("OrderItems:");
		for(OrderItem c: order.getItens()) {
			System.out.println(c.getProduct().getName() +
					", Quantity: "+ c.getQuantity()+
					", Subtotal: "+ c.subTotal());
		}
		System.out.println("Total price: " + order.total());
		
		sc.close();
		
	}

}
