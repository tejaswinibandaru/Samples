class Employee{

int empId;
String empName;
double empSalary;
String empDept;

public Employee(){	//No-arg constructor, not the default constructor

}

public Employee(int id){	//Parameterized constructor
}
public void getLogin(){
System.out.println("Logged in");
}

public void getLogout(){
System.out.println("Logged out");
}

public Employee printAllDetails(){
this.empId++;
this.empName="Hello "+this.empName;
this.empDept="My department is  "+this.empDept;

if(this.empSalary <=5000){
this.empSalary=this.empSalary+(this.empSalary*0.10);

}
else if(this.empSalary<7000){
this.empSalary=this.empSalary+(this.empSalary*0.05);

}
else{
this.empSalary=this.empSalary;
}
return this;
}
}