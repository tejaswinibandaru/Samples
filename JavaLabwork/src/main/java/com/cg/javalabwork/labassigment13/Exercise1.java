package com.cg.javalabwork.labassigment13;

public class Exercise1{

	public Exercise1() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Calculator calculator=(x,y)->{
			int result = 1;
			for(int i=1;i<=y;i++) {
				result*=x;
			}
			return result;};
			
			System.out.println(calculator.power(2, 4));
	}
	

}
