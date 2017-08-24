import java.util.*;

public class ExecuteEmployee {
	
	public static void main(String[] args) {
		
		Employee emp = new Employee("abc", "131", "New Delhi",100);
		Employee emp1 = new Employee("xyz", "130", "New Delhi",500);
		
		HashSet<Employee> set= new HashSet<Employee>();
		if(!set.add(emp))
			System.out.println("Error: Element Already Exist Id is "+emp.getEmpId());
		if(!set.add(emp))
			System.out.println("Error: Elemet Already exist Id is "+emp.getEmpId());
		if(!set.add(emp1))
			System.out.println("Error: Elemet Already exist Id is "+emp.getEmpId());
		
		for(Employee e:set)
		{
			if(e.sal> Integer.parseInt(args[0]) && e.sal< Integer.parseInt(args[1]))
				System.out.println(e.name);
		}
		if(emp.equals(emp1))
		{
			System.out.println("Equal");
		}
		else
			System.out.println("Not Equal");
	 	
	}

}
