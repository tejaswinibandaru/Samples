package com.capgemini.lesson2.interfacedemo;

/* Interface can EXTEND another interface
 * But, class can only IMPLEMENT one or more Interfaces
 */
public abstract class Sweet implements Food {

	public Sweet()
	{
		System.out.println("IS SWEET");
	}
	
	@Override
	public String taste() {
		// TODO Auto-generated method stub
		return "Sweet";
	}

}
