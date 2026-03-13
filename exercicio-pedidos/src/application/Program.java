package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf_Default = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirthDate = sdf_Default.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		
		Date dateMoment = new Date();
		Order order = new Order(dateMoment, OrderStatus.valueOf(orderStatus), client);
		
		System.out.print("How many items to this order? ");
		int itemsQuantity = sc.nextInt();
		
		for (int i=1; i<=itemsQuantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
