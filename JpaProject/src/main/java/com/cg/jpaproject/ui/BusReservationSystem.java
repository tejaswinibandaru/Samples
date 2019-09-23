package com.cg.jpaproject.ui;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.BusDay;
import com.cg.jpaproject.dto.BusTransaction;
import com.cg.jpaproject.dto.Passenger;
import com.cg.jpaproject.exception.BusException;
import com.cg.jpaproject.service.UserService;
import com.cg.jpaproject.service.UserServiceImpl;
import com.cg.jpaproject.service.Validation;

public class BusReservationSystem {
	static UserService userService;
	static int counter = 0;
	static Validation validation;
    static final String EXCEPTIONMSG="Exception occured: ";
	public static void main(String[] args) throws BusException {
		userService = new UserServiceImpl();
		showUserMenu();
	}
	
	static void showUserMenu() throws BusException {
		System.out.println("\n\n\t\t****** Welcome to Bus Reservation System ******");
		validation = new Validation();
		Scanner scanner = new Scanner(System.in);
		int runLoop = 1;
		String input;
		while (runLoop != 0) {
			int choice;
			while (true) {
				System.out.println("---------------------------------------------------------------");
				System.out.println("Select 1 for Admin");
				System.out.println("Select 2 for Customer");
				System.out.println("Select 3 to Exit");
				System.out.println("---------------------------------------------------------------");
				System.out.println("Enter your choice:");
				input = scanner.next();
				try {
					choice = validation.validateChoice(input);
					if (choice == 1) {
						adminMenu();
					} else if (choice == 2) {
						customerMenu();
					} else if(choice == 3)
					{
						System.out.println("Exiting the application");
						runLoop=0;
					}
					break;
				} catch (RuntimeException e) { 
				System.out.println(EXCEPTIONMSG + e.getMessage());
					continue;
				}
			}

			System.out.println("Press 1 to go back to main menu, 0 to confirm exit");
			runLoop = scanner.nextInt();

		}
	}

	static void adminMenu() {
		validation = new Validation();
		Scanner scanner = new Scanner(System.in);
		
		int runLoop = 1;
		String input;
		outer:
		while (runLoop != 0) {
			int choice = 0;
			while (true) {
				System.out.println("-------------------------------------------------");
				System.out.println("Press 1 for Adding Bus Details");
				System.out.println("Press 2 for Removing Bus Details");
				System.out.println("Press 3 for Modifying Bus Details");
				System.out.println("Press 4 for Viewing All Buses");
				System.out.println("Press 5 for Viewing BusTransaction Details");
				System.out.println("Press 6 for Editing Personal Details");
				System.out.println("Press 7 for Exiting To Main Menu");
				System.out.println("---------------------------------------------------");
				System.out.println("Enter your choice:");
				
				input = scanner.next(); 
				try {
					choice = validation.validateAdminChoice(input);
					break;
				} catch (RuntimeException e) {
					
					System.out.println(EXCEPTIONMSG + e.getMessage());
					continue;
				}
			}

			switch (choice) {
			case 1:
				// fetch details here
				System.out.println("Enter the bus name");
				String busName = scanner.next();
				String busType;
				while (true) {

					System.out.println("Enter the bus type(sleeper/semi_sleeper)");
					busType = scanner.next();

					try {
						validation.validateBusType(busType);
						break;
					} catch (RuntimeException e) {
						
						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}

				String busClass;
				while (true) {

					System.out.println("Enter the bus class(ac/non_ac)");
					busClass = scanner.next();
					try {
						validation.validateBusClass(busClass);
						break;
					} catch (Exception e) {
						
						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}

				int busSeats;
				while (true) {
					System.out.println("Enter the no of bus seats");
					try {
						busSeats = UserServiceImpl.checkNumberInput();
						break;
					} catch (Exception e) {
						
						System.out.println("Exception :" + e.getMessage());
						continue;
					}
				}
				int noOfDays = 0;
				while (true) {
					System.out.println("Enter the no of days of the week on which day the bus will run");
					input = scanner.next();
					try {
						noOfDays = validation.validateDayChoice(input);
						break;
					} catch (RuntimeException e) {
						
						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}
				List<BusDay> days = new ArrayList<BusDay>();
				for (int i = 0; i < noOfDays; i++) {
					System.out.println("Enter the days starting from Monday to Sunday: ");
					input = scanner.next();
					/*
					 * while (true) {
					 * 
					 * 
					 * try { day = validation.validateDayChoice(input); break; } catch
					 * (RuntimeException e) {
					 * 
					 * System.out.println(EXCEPTIONMSG + e.getMessage()); continue; } }
					 */
					BusDay day=new BusDay();
					day.setDay(input.toUpperCase());
					days.add(day);
				}

				String source;
				String destination;
				while (true) {
					System.out.println("Enter the bus source: ");
					source = scanner.next();

					System.out.println("Enter the bus destination");

					destination = scanner.next();

					try {
						validation.validateTravel(source, destination);
						break;
					} catch (Exception e) {
						
						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}

				double costPerSeat;
				while (true) {

					System.out.println("Enter the bus cost per seat");

					try {
						costPerSeat = Validation.validateCost();
						break;
					} catch (Exception e) {
						
						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}
				Bus bus = new Bus();
				bus.setBusName(busName);
				bus.setBusType(busType);
				bus.setBusClass(busClass);
				bus.setNoOfSeats(busSeats);
				bus.setDays(days);
				bus.setSource(source);
				bus.setDestination(destination);
				bus.setCostPerSeat(costPerSeat);

				bus = userService.addBusDetails(bus);
				System.out.println("Bus added: ");
				System.out.println("Bus Id: " + bus.getBusId());
				System.out.println("Bus name: " + bus.getBusName());
				System.out.println("Bus Type: " + bus.getBusType());
				System.out.println("Bus Class: " + bus.getBusClass());
				System.out.println("Number of Seats: " + bus.getNoOfSeats());
				System.out.println("Days Of Journey: " + bus.getDays());
				System.out.println("Source: " + bus.getSource());
				System.out.println("Destination: " + bus.getDestination());
				System.out.println("Cost per seat: " + bus.getCostPerSeat());

				break;

			case 2:
				Integer busId;
				while (true) {
					System.out.println("Enter the bus id to remove");
					input = scanner.next(); // INputMismatchExcp
					try {
						busId = validation.validateBigIntegerChoice(input);
						int removeStatus = userService.removeBus(busId);
						if (removeStatus == 1) {
							System.out.println("Bus removed");
						} else {
							System.out.println("Id not found");
						}
						break;
					} catch (RuntimeException e) {

						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}

				break;
			case 3:
				// BigInteger busId ;
				while (true) {
					System.out.println("Enter the bus id to update details: ");
					input = scanner.next();
					try {
						busId = validation.validateBigIntegerChoice(input);

						for (Bus busObj : userService.viewAllBuses()) {
							if (busId.equals(busObj.getBusId())) {
								double cost;
								while (true) {
									System.out.println("Update the cost per seat of the bus: ");
									try {
										cost = Validation.validateCost();

										busObj.setCostPerSeat(cost);
										System.out.println("cost per seat of the bus updated");
										break;
									} catch (Exception e) {
										
										System.out.println(EXCEPTIONMSG + e.getMessage());
										continue;
									}
								}

							} else {
								System.out.println("Id not found");
							}
						}
						break;
					} catch (RuntimeException e) {

						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}
				break;
			case 4:
				for(Bus busOb:userService.viewAllBuses()) {
					System.out.println(busOb.getBusId()+" "+busOb.getBusName()+" "+busOb.getNoOfSeats()+" "+busOb.getBusType()+" "+busOb.getBusClass()+" "+busOb.getSource()+" "+busOb.getDestination()+" "+busOb.getCostPerSeat());
				}
				break;
			case 5:
				LocalDate date;
				while (true) {
					System.out.println("Enter the date(DD-MM-YYYY): ");
					String dateStr = scanner.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					date = LocalDate.parse(dateStr, formatter);
					try {
						validation.validateDate(date);
						break;
					} catch (Exception e) {
						System.out.println("Exception occurred: " + e.getMessage());
						continue;

					}
				}
				System.out.println("List of transactions");
				for (BusTransaction busTransaction : userService.getTransactionsByDate(date)) {
					System.out.println(
							busTransaction.getDate() + " " + busTransaction.getBus() + busTransaction.getBookings());
				}
				break;
			case 6:
				System.out.println("You cannot edit your personal details. System is under maintenance");
				break;
			case 7:runLoop=0;
				System.out.println("Exiting to main menu");
				continue outer;
			default:
				System.out.println("Wrong choice : Enter a valid Integer input");
				break;
			}
			System.out.println("----------------------------------------------------");
			System.out.println("Press 1 to continue with the same menu, 0 to exit to the main menu");
			runLoop = scanner.nextInt();
			System.out.println("----------------------------------------------------");
		}

	}

	static void customerMenu() {
		validation = new Validation();
		Scanner scanner = new Scanner(System.in);
		int runLoop = 1;
		String input;
		outer:
		while (runLoop != 0) {
			int choice = 0;
			while (true) {
				System.out.println("Press 1 to Booking a Ticket");
				System.out.println("Press 2 for Viewing a Booking");
				System.out.println("Press 3 for Viewing Bookings List");
				System.out.println("Press 4 for Cancelling a Ticket");
				System.out.println("Press 5 for Editing Personal Details");
				System.out.println("Press 6 for Exiting To Main Menu");
				System.out.println("Enter your choice: ");
				input = scanner.next(); // INputMismatchExcp
				try {
					choice = validation.validateIntegerChoice(input);
					break;
				} catch (RuntimeException e) {
					
					System.out.println(EXCEPTIONMSG + e.getMessage());
					continue;
				}
			}

			switch (choice) {
			case 1:
				LocalDate date;
				while (true) {
					System.out.println("Enter your date of journey(DD-MM-YYYY):");
					String dateStr = scanner.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					date = LocalDate.parse(dateStr, formatter);
					try {
						validation.validateDate(date);
						break;
					} catch (Exception e) {
						System.out.println("Exception occurred: " + e.getMessage());
						continue;

					}
				}

				String source;
				String destination;
				while (true) {
					System.out.println("Enter the bus source: ");
					source = scanner.next();

					System.out.println("Enter the bus destination");

					destination = scanner.next();

					try {
						validation.validateTravel(source, destination);
						break;
					} catch (Exception e) {
						
						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}

				List<Bus> busList = userService.viewBusByDay(date);
				List<Bus> runningBuses=new ArrayList<Bus>();
				for(Bus busObj: busList) {
					if(busObj.getSource().equalsIgnoreCase(source) && busObj.getDestination().equals(destination)) {
						runningBuses.add(busObj);
					}
				}
				System.out.println("Running buses on your day of journey: ");
				int i = 0;
				for (Bus b : runningBuses) {
					System.out.println((i + 1) + " " + b.getBusId() + " " + b.getBusName() + " " + b.getBusType() + " "
							+ b.getBusClass() + " " + b.getCostPerSeat());
				}
				Integer busId;
				while (true) {
					System.out.println("Enter the bus Id of the bus you will be travelling: ");
					input = scanner.next();
					try {
						busId = validation.validateBigIntegerChoice(input);
						// BigInteger busId=scanner.nextBigInteger();
						break;
					} catch (Exception e) {
						
						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}

				for (Bus busObj : runningBuses) {
					if (busId.equals(busObj.getBusId())) {
						int passengersCount;
						while (true) {
							System.out.println("Enter the number of passengers: ");
							passengersCount = scanner.nextInt();
							try {
								validation.validatePassengersCount(passengersCount);
								break;
							} catch (Exception e) {
								
								System.out.println(EXCEPTIONMSG + e.getMessage());
								continue;
							}
						}
						
						boolean bookingStatus = userService.checkBusTransaction(date, busObj, passengersCount);
						if (bookingStatus) {
							List<Passenger> passengersList = new ArrayList<Passenger>();
							for (int j = 0; j < passengersCount; j++) {
								System.out.println("Enter Passenger " + j + 1 + " details: ");
								Passenger passenger = new Passenger();
								System.out.println("Name: ");
								String passengerName = scanner.next();
								passenger.setPassengerName(passengerName);
								int passengerAge = scanner.nextInt();
								passenger.setPassengerAge(passengerAge);
								System.out.println("Gender(M/F)");
								char passengerGender = scanner.next().charAt(0);
								passenger.setPassengerGender(passengerGender);
								passengersList.add(passenger);
							}
							String paymentMode;
							while (true) {
								System.out.println("Enter the mode of payment(UPI/DC/CC/NB): ");
								paymentMode = scanner.next();
								try {
									validation.validatePaymentMode(paymentMode);
									break;
								} catch (Exception e) {
									
									System.out.println(EXCEPTIONMSG + e.getMessage());
									continue;
								}
							}

							Booking booking = userService.createBooking(passengersList, date, busObj, paymentMode);
							System.out.println("Booking details: ");
							System.out.println(booking.getBookingId() + " " + booking.getDateOfJourney() + " "
									+ booking.getModeOfPayment());
							System.out.println("List of passengers");
							for (Passenger p : booking.getPassengers()) {
								System.out.println(p.getPassengerName() + " " + p.getPassengerAge() + " "
										+ p.getPassengerGender());
							}
						} else {
							System.out.println("Bus is full. Can't proceed with booking");
							continue;
						}
					}
				}
				break;
			case 2:
				break;
			case 3:
				System.out.println("List of your bookings: ");
				for (Booking booking : userService.viewTicketList()) {
					System.out.println(booking.getBookingId() + " " + booking.getDateOfJourney() + " "
							+ booking.getModeOfPayment() + " " + booking.getPassengers());
				}
				break;
			case 4:
				BigInteger bookingId;
				while (true) {
					System.out.println("Enter the booking id you want to cancel the booking for: ");
					input = scanner.next(); // INputMismatchExcp
					try {
						bookingId = validation.validateBigIntegerChoice(input);

						for (Booking booking : userService.viewTicketList()) {
							if (booking.getBookingId().equals(bookingId)) {
								int cancelStatus = userService.cancelTicket(booking);
								if (cancelStatus == 1) {
									System.out.println("Booking cancelled");
								} else {
									System.out.println("Error in cancelling the booking");
								}
							}
						}
						break;
					} catch (RuntimeException e) {

						System.out.println(EXCEPTIONMSG + e.getMessage());
						continue;
					}
				}
				break;

			case 5:
				System.out.println("You cannot edit your personal details. System is under maintenance");
				break;
			case 6:runLoop=0;
				System.out.println("Exiting to main menu");
				continue outer;
			default:
				System.out.println("Wrong choice : Enter a valid Integer input");
				break;
			}
			System.out.println("Press 1 to continue, 0 to exit to the main menu");
			runLoop = scanner.nextInt();

		}
		scanner.close();
	}
}
