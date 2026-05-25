package application;

import java.util.List;
import java.util.Scanner;

import entities.Ocurrence;
import entities.OcurrenceManager;
import entities.User;
import entities.enums.OcurrenceStatus;
import entities.enums.OcurrenceTitle;
import util.ConsoleUtils;

public class Menu {

	private String[] options = {"Add new ocurrence", "Check ocurrence(s) status", "Sign new user", "Quit"};
	
	public void showMainMenu(Scanner sc, OcurrenceManager mngr, User user) {
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println("---OPTIONS---");
			for (int i=0; i<options.length; i++) {
				System.out.println((i + 1) + " - " + options[i]);
			}
			int choice = ConsoleUtils.readOptionSafe(sc, ": ", 1, options.length);
			System.out.println();
			keepRunning = processChoice(choice, sc, mngr);
			System.out.println();
		}
	}
	
	private boolean processChoice(int choice, Scanner sc, OcurrenceManager manager) {
		switch (choice) {
			case 1:
				User selectedUser = selectUser(manager, sc);
				if (selectedUser == null) {
					System.out.println("User not found.");
					return true;
				}
				OcurrenceTitle[] titles = OcurrenceTitle.values();
				System.out.println("Redirecting to create new ocurrence...");
				
				char option = 'y';
				while (option == 'y') {
					System.out.println("--- SELECT THE OCURRENCE NUMBER ---");
					for (int i=0; i<titles.length; i++) {
						System.out.println((i + 1) + " - " + titles[i]);
					}
					int ocurrenceNumber = ConsoleUtils.readOptionSafe(sc, "Number: ", 1, titles.length);
					System.out.print("Description (short description):");
					String description = sc.nextLine();
					System.out.print("Street address: ");
					String streetAddress = sc.nextLine();
					manager.addOcurrenceUser(selectedUser, new Ocurrence(titles[ocurrenceNumber - 1], description, streetAddress, OcurrenceStatus.OPEN));
					
					System.out.println();
					System.out.println("Do you want do Add a new ocurrence?(y/n)");
					option = sc.nextLine().charAt(0);
				}
				return true;
			case 2:
				selectedUser = selectUser(manager, sc);
				if (selectedUser == null) {
					System.out.println("User not found.");
					return true;
				}
				System.out.println("Checking status for user: " + selectedUser.getUsername() + ", Id: " + selectedUser.getUserId());
				System.out.println();
				List<Ocurrence> userOcurrences = manager.getUserOcurrence(selectedUser);
				if (userOcurrences.isEmpty()) {
				    System.out.println("No ocurrences found for this user.");
				} else {
				    System.out.println("--- OCURRENCES LIST ---");
				    for (Ocurrence oc : userOcurrences) {
				        System.out.println(oc);
				        System.out.println("-----------------------");
				    }
				}
				return true;
			case 3:
				System.out.println("---REGISTER NEW USER---");
				System.out.print("Name: ");
				String name = sc.nextLine();
				int userId = ConsoleUtils.readIntSafe(sc, "User ID: ");
				
				System.out.print("Email: ");
				String email = sc.nextLine();
				System.out.print("Address (neighborhood,city,state): ");
				String address = sc.nextLine();
				User newUser = new User(name, userId, email, address);
				manager.addOcurrenceUser(newUser, null);
				return true;
			case 4:
				System.out.println("Exiting system. Goodbye!");
				return false;
			default:
				return true;
		}
    }
	
	private User selectUser(OcurrenceManager manager, Scanner sc) {
		List<User> userList = manager.getAllKeys();
		if (userList.isEmpty()) {
			System.out.println("Nenhum usuário cadastrado.");
			return null;
		}
		System.out.println("---Select user---");
		for (int i=0; i < userList.size(); i++) {
			System.out.println((i + 1) + " - " + userList.get(i).getUsername() + ", Id: " + userList.get(i).getUserId());
		}
		int userChoice = ConsoleUtils.readOptionSafe(sc, "User: ", 1, userList.size());
		User selectedUser = userList.get(userChoice - 1);
		return selectedUser;
	}
}
