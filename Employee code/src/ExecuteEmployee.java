import java.util.*;

public class ExecuteEmployee {

	public static void main(String[] args) {
		System.out.println(
				"Options:\n1-->Add Employee\n2-->Remove Employee By ID\n3-->Get Employee with a name\n4-->Get Employee within salary range\n5-->Quit");
		System.out.println("Input the digit");
		Scanner sc = new Scanner(System.in);
		int digit = Integer.parseInt(sc.nextLine());

		HashSet<Employee> set = new HashSet<Employee>();
		while (digit != 5) {
			if (digit == 1) {
				System.out.println("Enter the name of employee:");
				String name = sc.nextLine();
				System.out.println("Enter the id:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the salary:");
				int sal = Integer.parseInt(sc.nextLine());

				Employee emp = new Employee();
				emp.setName(name);
				emp.setId(id);
				emp.setSalary(sal);

				if (set.contains(emp))
					System.out.println("Error: Employee Alreadya Exists");
				else {
					set.add(emp);
					System.out.println("Successfully added");
				}

			} else if (digit == 2) {
				System.out.println("Enter the ID to remove the employee");
				int idToRemove = Integer.parseInt(sc.nextLine());
				Employee r_emp = new Employee();
				r_emp.setId(idToRemove);

				boolean result = set.remove(r_emp);
				if (result)
					System.out.println("Employee removed successfully");
				else
					System.out.println("Employee doesn't exist");

			} else if (digit == 3) {
				boolean empFound = false;
				System.out.println("Enter the Employee name:");
				String findEmplName = sc.nextLine();

				for (Employee e : set) {
					if (e.name.equals(findEmplName)) {
						System.out.println("Employee ID: " + e.id + " Name: " + e.name + " Salary: " + e.salary);
						empFound = true;
					}
				}
				if (!empFound)
					System.out.println("Employee not found with this name");
			} else if (digit == 4) {
				System.out.println("Enter the salary range\n Min Salary:");
				Double minSal = Double.parseDouble(sc.nextLine());
				System.out.println("Max Salary:");
				Double maxSal = Double.parseDouble(sc.nextLine());
				for (Employee e : set) {
					if (e.salary >= minSal && e.salary <= maxSal) {
						System.out.println("Employee ID: " + e.id + " Name: " + e.name + " Salary: " + e.salary);
					}
				}
			}
			System.out.println("Input the digit");
			digit = Integer.parseInt(sc.nextLine());
		}
		sc.close();
		System.out.println("Exit");
	}
}