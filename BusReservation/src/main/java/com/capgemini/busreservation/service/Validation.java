package com.capgemini.busreservation.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.busreservationsystem.service.BusException;
import com.cg.busreservationsystem.service.DateException;
import com.cg.busreservationsystem.service.PassengerException;

public class Validation {

	public Validation() {
		// TODO Auto-generated constructor stub
	}
	public void validateDate(LocalDate date) throws DateException {
		if(!date.isAfter(LocalDate.now())){
			throw new DateException("Date should be after today's date");
		}
	}
	
	public void validatePassengersCount(int count) {
		if(count>5) {
			throw new PassengerException("Passenger count should not be more than 5 per ticket");
		}
	}
	
	public void validateGender(Character gender) {
		if(!gender.equals('F')||!gender.equals('M')) {
			throw new PassengerException("Gender should be M or F");
		}
	}
	
	public void validatePaymentMode(String paymentMode) {
		if(! paymentMode.equals("UPI")||! paymentMode.equals("DC")||! paymentMode.equals("CC")||! paymentMode.equals("NB")) {
			throw new PassengerException("Mode of payment should be UPI,DC,CC or NB");
		}
	}
	
	public void validateTravel(String busSource, String busDestination) {
		if(busSource.equals(busDestination)) {
			throw new BusException("Source and Destination cant be same");
		}
	}

	
	public void validateBusType(String busType) {
		System.out.println(busType);
		if(!busType.equalsIgnoreCase("sleeper")&&(!busType.equalsIgnoreCase("semi_sleeper"))) {
			System.out.println(busType);
			throw new BusException("Invalid Bus Type");
		}
	}
	public void validateBusClass(String busClass) {
		if((!busClass.equalsIgnoreCase("ac"))&&(!busClass.equalsIgnoreCase("non_ac"))) {
			throw new BusException("Invalid bus class");
		}
	}

	public static double validateCost() throws InputMismatchException{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		try {
			return sc.nextDouble();
		}catch (Exception e) {
			throw new InputMismatchException("Wrong cost type entered");
		}
	}
	public boolean isValidNumeric(String str) 
    { 
        str = str.trim(); // trims the white spaces. 
  
        if (str.length() == 0) 
            return false; 
  
        // if string is of length 1 and the only 
        // character is not a digit 
        if (str.length() == 1 && !Character.isDigit(str.charAt(0))) 
            return false; 
  
        // If the 1st char is not '+', '-', '.' or digit 
        if (str.charAt(0) != '+' && str.charAt(0) != '-'
            && !Character.isDigit(str.charAt(0)) 
            && str.charAt(0) != '.') 
            return false; 
  
        // To check if a '.' or 'e' is found in given 
        // string. We use this flag to make sure that 
        // either of them appear only once. 
        boolean flagDotOrE = false; 
  
        for (int i = 1; i < str.length(); i++) { 
            // If any of the char does not belong to 
            // {digit, +, -, ., e} 
            if (!Character.isDigit(str.charAt(i)) 
                && str.charAt(i) != 'e' && str.charAt(i) != '.'
                && str.charAt(i) != '+' && str.charAt(i) != '-') 
                return false; 
  
            if (str.charAt(i) == '.') { 
                // checks if the char 'e' has already 
                // occurred before '.' If yes, return 0. 
                if (flagDotOrE == true) 
                    return false; 
  
                // If '.' is the last character. 
                if (i + 1 >= str.length()) 
                    return false; 
  
                // if '.' is not followed by a digit. 
                if (!Character.isDigit(str.charAt(i + 1))) 
                    return false; 
            } 
  
            else if (str.charAt(i) == 'e') { 
                // set flagDotOrE = 1 when e is encountered. 
                flagDotOrE = true; 
  
                // if there is no digit before 'e'. 
                if (!Character.isDigit(str.charAt(i - 1))) 
                    return false; 
  
                // If 'e' is the last Character 
                if (i + 1 >= str.length()) 
                    return false; 
  
                // if e is not followed either by 
                // '+', '-' or a digit 
                if (!Character.isDigit(str.charAt(i + 1)) 
                    && str.charAt(i + 1) != '+'
                    && str.charAt(i + 1) != '-') 
                    return false; 
            } 
        } 
  
        /* If the string skips all above cases, then 
           it is numeric*/
        return true; 
    }
	public int validateChoice(String input) {
		// TODO Auto-generated method stub
		int choice;
		if(isValidNumeric(input)) {
			choice = Integer.parseInt(input);
			if(choice < 1 ||choice> 2) {
				throw new BusException("Wrong choice entered");
			}
		}
		else
			throw new BusException("Integer choice to be entered");
		return choice;
	}
	public int validateRunloopChoice(String input) {
		// TODO Auto-generated method stub
		int choice;
		if(isValidNumeric(input)) {
			choice = Integer.parseInt(input);
			if(choice < 0 ||choice> 1) {
				throw new BusException("Wrong choice entered");
			}
		}
		else
			throw new BusException("Integer choice to be entered");
		return choice;
	}
	
	public int validateIntegerChoice(String input) {
		  if(!isValidNumeric(input)) 
			throw new BusException("Integer choice to be entered");
		  return Integer.parseInt(input);
		}
	public int validateDayChoice(String input) {
		// TODO Auto-generated method stub
		int choice;
		if(isValidNumeric(input)) {
			choice = Integer.parseInt(input);
			if(choice < 1 ||choice > 7) {
				throw new BusException("Week has only seven days");
			}
		}
		else
			throw new BusException("Integer choice to be entered");
		return choice;
	}
	
	public BigInteger validateBigIntegerChoice(String input) {
		  if(!isValidNumeric(input)) 
			throw new BusException("Integer choice to be entered");
		  return BigInteger.valueOf(Integer.parseInt(input));
		}
	}


}
