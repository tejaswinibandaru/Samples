package com.cg.javalabwork.labassigment5;

import java.util.Scanner;

public class Exercise3 {
	
	public static boolean isPrime(int number) {
		if(number<=1) {
			return false;
		}
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number=scanner.nextInt();
		System.out.println("List Of Primes: ");
		for(int i=2;i<number;i++) {
			if(isPrime(i)) {
				System.out.print(i+" ");
			}
		}
	}

}
