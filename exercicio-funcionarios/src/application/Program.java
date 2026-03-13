package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf_DMY = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf_MY = new SimpleDateFormat("MM/yyyy");

		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));
		
		System.out.print("How many contracts to this worker? ");
		int contractsAmount = sc.nextInt();
		
		for (int i=0; i<contractsAmount; i++) {
			System.out.println();
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf_DMY.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, duration);
			
			worker.addContract(contract);
		}
		
		System.out.println();
		Calendar cal = Calendar.getInstance();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		Date incomeDate = sdf_MY.parse(sc.next());
		cal.setTime(incomeDate);
		int c_year = cal.get(Calendar.YEAR);
		int c_month = 1 + cal.get(Calendar.MONTH);
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.printf("Income for %02d/%d: %.2f%n", c_month, c_year, worker.income(c_year, c_month));
		
		
		
		
		sc.close();
	}

}
