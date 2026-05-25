package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {

    public static int readIntSafe(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = sc.nextInt();
                sc.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); 
            }
        }
    }

    public static int readOptionSafe(Scanner sc, String prompt, int min, int max) {
        while (true) {
            int option = readIntSafe(sc, prompt);
            if (option >= min && option <= max) {
                return option;
            }
            System.out.println("Invalid option! Please choose between " + min + " and " + max + ".");
        }
    }
	
}
