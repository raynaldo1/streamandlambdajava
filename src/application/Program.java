package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		String path = "c:/temp/in.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Employee> list = new ArrayList<>();
			
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			System.out.print("Enter Salary: ");
			double salary = sc.nextDouble();
						
			List<String> emails = list.stream()
					.filter(e -> e.getSalary() > salary)
					.map(e -> e.getEmail())
					.sorted()
					.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than $" + String.format("%.2f", salary) + ": ");
			emails.forEach(System.out::println);
			
			Double sum = list.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (e1, e2) -> e1 + e2);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
			
		}
		
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		sc.close();
	}

}
