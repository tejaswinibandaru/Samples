package com.cg.javalabwork.labassigment13;

public class Exercise2 {
	public static void main(String[] args) {
		StringFormatter formatter=(string)->{
			String formattedString=string.replace("", " ").trim();
			return formattedString;
			
		};
		System.out.println(formatter.formatString("capgemini"));
	}
}
