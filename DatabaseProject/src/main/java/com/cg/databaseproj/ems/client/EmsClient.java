/**
 * 
 */
package com.cg.databaseproj.ems.client;

import java.math.BigDecimal;
import java.util.List;

import com.cg.databaseproj.ems.dao.EmployeeDao;
import com.cg.databaseproj.ems.dao.IEmployeeDao;
import com.cg.databaseproj.ems.exception.EmployeeException;
import com.cg.databaseproj.ems.model.Employee;

/**
 * @author admin
 *
 */
public class EmsClient {

	/**
	 * @param args
	 */
	
	private static IEmployeeDao employeeDao;
	
	static {
		employeeDao=new EmployeeDao();
	}
	public static void main(String[] args) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Employee employee = new Employee();
		employee.setEmpName("Zara");
		employee.setEmpSalary(BigDecimal.valueOf(9000.0));
		Employee emp=employeeDao.addEmployee(employee);
		List<Employee> empList=employeeDao.listAllEmployees();
		if(empList!=null) {
			empList.forEach(System.out::println);
		}else {
			System.out.println("No record found!!!");
		}

	}

}
