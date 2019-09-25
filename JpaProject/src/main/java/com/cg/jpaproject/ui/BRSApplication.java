package com.cg.jpaproject.ui;

import java.security.Provider.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.jpaproject.dto.Booking;
import com.cg.jpaproject.dto.Bus;
import com.cg.jpaproject.dto.Passenger;
import com.cg.jpaproject.dto.User;
import com.cg.jpaproject.exception.BusException;
import com.cg.jpaproject.service.UserService;
import com.cg.jpaproject.service.UserServiceImpl;
import com.cg.jpaproject.service.Validation;

public class BRSApplication {
	static UserService userService;

	static void printMainMenu() {
		System.out.println("----------------------------Welcome To Bus Reservation System----------------------------");
		Scanner scanner = new Scanner(System.in);
		int runLoop = 1;
		while (runLoop != 0) {
			int choice;
			while (true) {
				System.out.println("---------------------------------------------------------------");
				System.out.println("Select 1 for Admin Menu");
				System.out.println("Select 2 for Customer Menu");
				System.out.println("Select 3 to Exit");
				System.out.println("---------------------------------------------------------------");
				System.out.println("Enter your choice:");
				System.out.println("---------------------------------------------------------------");
				choice = scanner.nextInt();
				if (choice == 1) {
					printAdminMenu();
				} else if (choice == 2) {
					printCustomerMenu();

				} else if (choice == 3) {
					System.out.println("Exiting the application...");

					break;
				}
			}
			System.out.println("Press 1 to go back to main menu, 0 to confirm exit");
			runLoop = scanner.nextInt();
			if (runLoop == 0)
				System.out.println("Thanks for using the application!");
		}
	}

	static void printAdminMenu() {
		Scanner scanner = new Scanner(System.in);
		Validation validation = new Validation();

		int runLoop = 1;
		outer: while (runLoop != 0) {
			int choice = 0;

			while (true) {
				System.out.println("-------------------------------------------------");
				System.out.println("Press 1 for Adding Bus Details");
				System.out.println("Press 2 for Removing Bus Details");
				;
				System.out.println("Press 3 for Viewing All Buses");
				System.out.println("Press 4 for Exiting To Main Menu");

				System.out.println("---------------------------------------------------");
				System.out.println("Enter your choice:");
				System.out.println("---------------------------------------------------");

				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the bus name");
					String busName = scanner.next();
					String busType;
					while (true) {

						System.out.println("Enter the bus type(sleeper/semi_sleeper)");
						busType = scanner.next();

						try {
							try {
								validation.validateBusType(busType);
							} catch (BusException e) {
								System.out.println("Error occurred: " + e.getMessage());
							}
							break;
						} catch (RuntimeException e) {

							System.out.println("Error occurred: " + e.getMessage());
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

							System.out.println("Error occurred: " + e.getMessage());
							continue;
						}
					}
					System.out.println("Enter the number of bus seats: ");
					int noOfSeats = scanner.nextInt();
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

							System.out.println("Error occurred: " + e.getMessage());
							continue;
						}
					}
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
					System.out.println("Enter the departure time: ");
					String startTimeString = scanner.next();
					System.out.println("Enter the arrival time: ");
					String endTimeString = scanner.next();
					LocalTime startTime = LocalTime.parse(startTimeString, formatter);
					LocalTime endTime = LocalTime.parse(endTimeString, formatter);

					System.out.println("Enter the cost per seat: ");
					double costPerSeat = scanner.nextDouble();

					Bus bus = new Bus();
					bus.setBusId(bus.getBusId());
					bus.setBusName(busName);
					bus.setBusType(busType);
					bus.setBusClass(busClass);
					bus.setSource(source);
					bus.setDestination(destination);
					bus.setNoOfSeats(noOfSeats);
					bus.setStartTime(startTime);
					bus.setEndTime(endTime);
					bus.setCostPerSeat(costPerSeat);
					bus.setDelete_flag(0);

					bus = userService.addBusDetails(bus);
					System.out.println("---------------------------------------------");
					System.out.println("Bus added: ");
					System.out.println("Bus Id: " + bus.getBusId());
					System.out.println("Bus name: " + bus.getBusName());
					System.out.println("Bus Type: " + bus.getBusType());
					System.out.println("Bus Class: " + bus.getBusClass());
					System.out.println("Number of Seats: " + bus.getNoOfSeats());
					System.out.println("Departure Time: " + bus.getStartTime());
					System.out.println("Arrival Time: " + bus.getEndTime());
					System.out.println("Source: " + bus.getSource());
					System.out.println("Destination: " + bus.getDestination());
					System.out.println("Cost per seat: " + bus.getCostPerSeat());
					System.out.println("----------------------------------------------");
					break;
				case 2:
					System.out.println("Enter the bus id to remove:");
					Integer busId = scanner.nextInt();
					Integer removeStatus = userService.removeBus(busId);
					if (removeStatus == 0) {
						System.out.println("Bus not found");
					} else {
						System.out.println("Bus removed successfully");
					}
					break;
				case 3:
					System.out.println("List of Buses: ");
					List<Bus> buses = userService.viewAllBuses();
					for (Bus busObj : buses) {
						System.out.println(busObj.getBusId() + " " + busObj.getBusName() + " " + busObj.getBusType()
								+ " " + busObj.getBusClass() + " " + busObj.getSource() + " " + busObj.getDestination()
								+ " " + busObj.getStartTime() + " " + busObj.getEndTime());
					}
					break;
				case 4:
					runLoop = 0;
					System.out.println("Exiting admin menu...");
					continue outer;
				default:
					try {
						validation.validateChoice("9");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occurred : " + e.getMessage());
					}
					break;
				}
			}
		}

	}

	static void printCustomerMenu() {
		Validation validation = new Validation();
		Scanner scanner = new Scanner(System.in);
		int runLoop = 1;
		outer2: while (runLoop != 0) {
			int choice;
			while (true) {
				System.out.println("----------------------------------------------------");
				System.out.println("Press 1 to Booking a Ticket");
				System.out.println("Press 2 for Viewing Bookings List");
				System.out.println("Press 3 for Cancelling a Ticket");
				System.out.println("Press 4 for Editing Personal Details");
				System.out.println("Press 5 for Exiting To Main Menu");
				System.out.println("----------------------------------------------------");
				System.out.println("Enter your choice: ");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter your user id: ");
					Integer userId = scanner.nextInt();
					for (User user : userService.viewAllUsers()) {
						if (userId.equals(user.getUserId())) {
							System.out.println("Enter your date of journey(DD-MM-YYYY):");
							String dateString = scanner.next();
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
							LocalDate date = LocalDate.parse(dateString, formatter);
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

									System.out.println("Error occurred:" + e.getMessage());
									continue;
								}

							}
							List<Object[]> runningBuses = userService.viewBusByRoutes(source, destination);
							System.out.println("--------------------------------------------------------");
							System.out.println("List of running buses");
							for (Object[] bus : runningBuses) {
								System.out.println(bus[0] + " " + bus[1] + " " + bus[2] + " " + bus[3] + " " + bus[4]);
							}
							System.out.println("---------------------------------------------------------");
							System.out.println("Enter the busId you wish to travel: ");
							Integer busId = scanner.nextInt();
							for (Object[] bus : runningBuses) {
								if (busId.equals((Integer) bus[0])) {
									List<Passenger> passengersList = new ArrayList<Passenger>();
									System.out.println("Enter the number of passengers: ");
									int passengersCount = scanner.nextInt();
									for (int count = 0; count < passengersCount; count++) {
										System.out.println("Enter passenger name: ");
										String passengerName = scanner.next();
										System.out.println("Enter passenger age: ");
										Integer passengerAge = scanner.nextInt();
										System.out.println("Enter passenger gender: ");
										Character passengerGender = scanner.next().charAt(0);

										Passenger passenger = new Passenger();
										passenger.setPassengerId(passenger.getPassengerId());
										passenger.setPassengerName(passengerName);
										passenger.setPassengerAge(passengerAge);
										passenger.setPassengerGender(passengerGender);
										passengersList.add(passenger);
									}
									Booking booking = new Booking();
									booking.setBookingId(booking.getBookingId());
									booking.setDateOfJourney(date);
									booking.setPassengers(passengersList);
									Bus busObj = userService.viewBusById(busId);
									booking.setBus(busObj);
									booking.setTotalCost(passengersList.size() * busObj.getCostPerSeat());
									booking.setBookingStatus("BOOKED");
									booking.setDeleteFlag(0);
									String paymentMode;
									while (true) {
										System.out.println("Enter the mode of payment(UPI/DC/CC/NB): ");
										paymentMode = scanner.next();
										try {
											validation.validatePaymentMode(paymentMode);
											break;
										} catch (Exception e) {

											System.out.println("Error occurred: " + e.getMessage());
											continue;
										}
									}
									booking.setModeOfPayment(paymentMode);
									user.getBookingsList().add(booking);
									if (user.getBookingsList() == null) {
										List<Booking> bookingsList = new ArrayList<Booking>();
										user.setBookingsList(bookingsList);
										user.getBookingsList().add(booking);
									} else {

									}

									userService.createBooking(booking);
									System.out.println("Ticket booked succesfully");
									System.out.println("-----------------------------------------------------------");
									System.out.println("Booking id: " + booking.getBookingId());
									System.out.println("Date Of Journey: " + booking.getDateOfJourney());
									System.out.println("Payment mode: " + booking.getModeOfPayment());
									System.out.println("Status: " + booking.getBookingStatus());
									System.out.println("Bus name: " + booking.getBus().getBusName());
									System.out.println("Total cost: " + booking.getTotalCost());
									System.out.println("------------------------------------------------------------");

								}
							}
						} else {
							System.out.println("Please create your account to proceed for booking.");
						}
					}
					break;
				case 2:// view
					for (Booking booking : userService.viewAllBookings()) {
						System.out.println(booking.toString());
					}
					break;

				case 3:// cancel
					System.out.println("Enter the bookingId to remove: ");
					int bookingId = scanner.nextInt();
					userService.removeBooking(bookingId);
					break;

				case 4:// editing
					System.out.println("Enter the userId to modify");
					System.out.println("Enter your user id: ");
					userId = scanner.nextInt();
					for (User user : userService.viewAllUsers()) {
						if (userId.equals(user.getUserId())) {
							System.out.println("Enter the username: ");
							String username = scanner.next();
							System.out.println("Enter the password: ");
							String password = scanner.next();
							System.out.println("Enter the email: ");
							String email = scanner.next();
							System.out.println("Enter the phone number: ");
							int phoneNum = scanner.nextInt();
							user.setEmail(email);
							user.setPass(password);
							user.setPhoneNumber(phoneNum);
							user.setUsername(username);
							userService.addUser(user);
						}
					}
					break;
				case 5:// exit
					runLoop = 0;
					System.out.println("Exiting customer menu...");
					continue outer2;
				default:
					try {
						validation.validateChoice("9");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error occurred : " + e.getMessage());
					}
					break;

				}
			}
		}

	}

	public static void main(String[] args) {

		/*
		 * User user=new User(); user.setUserId(1); user.setUsername("abcde");
		 * user.setEmail("abcde@gmail.com"); user.setPass("abcde");
		 * user.setPhoneNumber(78969079); user.setUserType('C'); user.setDeleteFlag(0);
		 */

		userService = new UserServiceImpl();
//		userService.addUser(user);
		printMainMenu();
	}
}
