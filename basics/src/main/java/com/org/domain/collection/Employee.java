package com.org.domain.collection;

public class Employee {

	private int id = 0;
	private String name = null;
	private String department = null;
	private String city = null;
	private Address address = null;
	private Manager manager = null;
	private boolean isExecutive = false;
	private boolean senior = false;
	
	public Employee(int id) {
		this.id = id;
		this.name = "Mars Man";
		address = new Address();
		
		address.setAddressLine1("11");
		address.setAddressLine2("Spacelane");
		address.setCountry("Mars");
		address.setCode("12AB102D1");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		
		if(this.id == other.id && this.name.equals(other.name)) {
			return true;
		}
		return false;
	}
	
	public Employee(int id, String name, String department) {
		setId(id);
		setName(name);
		setDepartment(department);
	}
	
	public Employee(int id, String name, String department, boolean isExec) {
		setId(id);
		setName(name);
		setDepartment(department);
		setExecutive(isExec);
	}

	public Employee(int id, String name, String department, String city) {
		setId(id);
		setName(name);
		setDepartment(department);
		setSenior(true);
		setCity(city);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isExecutive() {
		return isExecutive;
	}

	public void setExecutive(boolean isExecutive) {
		this.isExecutive = isExecutive;
	}

	public boolean isManager(Employee manager){
		return getManager().equals(manager);
	}
	

	public boolean isSenior() {
		return senior;
	}

	public void setSenior(boolean senior) {
		this.senior = senior;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
