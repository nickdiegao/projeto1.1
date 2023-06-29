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
import enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat yr = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameclient = sc.nextLine();
		System.out.print("E-mail: ");
		String emailclient = sc.nextLine();
		System.out.print("Birth date (dd/MM/yyyy): ");
		Date aniver = yr.parse(sc.next());
		
		Client client = new Client(nameclient,emailclient,aniver);
		
		System.out.println("Enter order data:");
		System.out.print("STATUS: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(),status,client);	
		
		System.out.print("How many items do this order: ");
		int x = sc.nextInt();
		
		for (int i=1;i<=x;i++) {
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productname = sc.nextLine();
			System.out.print("Product Price: ");
			Double productprice = sc.nextDouble();
			
			Product product = new Product(productname, productprice);
			
			System.out.print("Quantity: ");
			int quant = sc.nextInt();
			
			OrderItem orderitem = new OrderItem(quant,productprice,product);
			
			order.addItem(orderitem);
		}
		
		System.out.println("");
		System.out.println("ORDER DATA: ");
		System.out.println(order);
		
		sc.close();
	}

}
