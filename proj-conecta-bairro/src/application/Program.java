package application;

import java.util.Locale;
import java.util.Scanner;

import entities.OcurrenceManager;
import entities.User;
import util.ConsoleUtils;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		OcurrenceManager manager = new OcurrenceManager();
		Menu menu = new Menu();
		
		System.out.println("--- USER REGISTRATION ---");
		System.out.print("Name: ");
		String name = sc.nextLine();
		int userId = ConsoleUtils.readIntSafe(sc, "User ID: ");
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Address (neighborhood,city,state): ");
		String address = sc.nextLine();
		System.out.println();
		
		User user = new User(name, userId, email, address);
		manager.addOcurrenceUser(user, null);
		menu.showMainMenu(sc, manager, user);
		
		
		sc.close();
	}

}
