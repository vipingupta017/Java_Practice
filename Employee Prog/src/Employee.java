import org.omg.CORBA.PUBLIC_MEMBER;

public class Employee {
	
	String name,empId,address;
	int sal;
	
	public Employee(String name , String empId , String address,int sal)
	{
		this.name = name;
		this.empId = empId;
		this.address = address;
		this.sal= sal;
	}

	public String getName() {
		return name;
	}

	public String getEmpId() {
		return empId;
	}

	public String getAddress() {
		return address;
	}
	
	public int getSal() {
		return sal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}
	

}
