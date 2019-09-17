package com.cg.databaseproj.ems.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.databaseproj.ems.exception.EmployeeException;
import com.cg.databaseproj.ems.exception.MyException;
import com.cg.databaseproj.ems.model.Employee;
import com.cg.databaseproj.ems.util.DBUtil;

public class EmployeeDao implements IEmployeeDao {
	
	//Prep -work 1-Connection
	private static Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private static Logger myLogger;
	static{
	  	
	  	  Properties props = System.getProperties();
	  	  String userDir= props.getProperty("user.dir")+"/src/main/resources/";
	  	  System.out.println("Current working directory is " +userDir);
	  	  PropertyConfigurator.configure(userDir+"log4j.properties");
			myLogger=Logger.getLogger("DBUtil.class");
			}
	static {
		try {
			connection=DBUtil.getConnection();
			myLogger.info("connection obtained.....");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			myLogger.error("connection not established at EmployeeDao: "+e);
		}
	}
	
	@Override
	public Employee addEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		String sql="insert into employee(emp_name,emp_sal) values(?,?)";
		try {
			ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//2-set the ps placeholder values
			ps.setString(1, employee.getEmpName());
			ps.setBigDecimal(2, employee.getEmpSalary());
			
			//3-execute query(for DML we have executeUpdate method)
			int noOfRecords=ps.executeUpdate();
			
			BigInteger generatedId=BigInteger.valueOf(0L);
			rs=ps.getGeneratedKeys();
			
			if(rs.next()) {
				generatedId=BigInteger.valueOf(rs.getLong(1));
				myLogger.info("Auto generated id: "+generatedId);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			myLogger.error("Error at addEmployee Dao method: "+e.getMessage());
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					myLogger.error("Error at addEmployee Dao method:"+e.getMessage());
				}
			}
		}
		return employee;
	}

	@Override
	public List<Employee> listAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		String sql="select * from employee";
		List<Employee> empList=new ArrayList<Employee>();
		try {
			ps=connection.prepareStatement(sql);
			//for select queries, returns ResultSet
			rs=ps.executeQuery();
			while(rs.next()) {
				//create employee object
				Employee emp=new Employee();
				//get the value from rs and set to emp obj
				emp.setEmpId(BigInteger.valueOf(rs.getLong("emp_id")));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpSalary(rs.getBigDecimal("emp_sal"));
				empList.add(emp);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error at addEmployee Dao method: "+e.getMessage());
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error at addEmployee Dao method:"+e.getMessage());
				}
			}
		}
		return empList;
	}



}

	