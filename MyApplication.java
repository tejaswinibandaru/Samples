class MyApplication{
public static void main(String[] args){
Employee emp=new Employee();
emp.empId=Integer.parseInt(args[0]);
emp.empName=args[1];
emp.empSalary=Double.parseDouble(args[2]);
emp.empDept=args[3];

emp.getLogin();
emp.getLogout();
Employee e=emp.printAllDetails();

System.out.println("ID:"+e.empId);
System.out.println("Name:"+e.empName);
System.out.println("Salary:"+e.empSalary);
System.out.println("Dept:"+e.empDept);
}
}