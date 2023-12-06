package com.ticketbooking.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

import com.ticketbooking.bean.MovieShow;
import com.ticketbooking.bean.MovieShowInfo;

public class MovieShowService {
	
	private List<MovieShow> movieShow = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
	
	public void showAvailableDates() {
	    System.out.println("Available Show Dates:");
	    for (MovieShow ms : movieShow) {
	        System.out.println(ms.getShowDate());
	    }
	}
	
	public MovieShowService() {
        MovieShow ms1 = new MovieShow();
        ms1.setShowDate("7-Dec");
        MovieShow ms2 = new MovieShow();
        ms2.setShowDate("8-Dec");
        MovieShow ms3 = new MovieShow();
        ms3.setShowDate("9-Dec");
        MovieShow ms4 = new MovieShow();
        ms4.setShowDate("10-Dec");
        MovieShow ms5 = new MovieShow();
        ms5.setShowDate("11-Dec");
        movieShow.add(ms1);
        movieShow.add(ms2);
        movieShow.add(ms3);
        movieShow.add(ms4);
        movieShow.add(ms5);
    }
	
	public void showMoviewAndSeatInfo() {
		Iterator<MovieShow> li = movieShow.iterator();
		while(li.hasNext()) {
			MovieShow ms = li.next();
			System.out.println("-----------------------------");
			System.out.println("Date "+ms.getShowDate());
			MovieShowInfo msf[] = ms.getMovieShowInfo();
			for(MovieShowInfo mm : msf) {
				mm.setNumberOfSeats(mm.getNumberOfSeats()-1);
				System.out.println("Show Time "+mm.getShowTime()+" Number of Seats "+mm.getNumberOfSeats()+" Price "+mm.getAmount());
			}
			System.out.println("------------------------------");
		}
	}
	
	public void searchMoviInfoByDate(String date) {
		int flag = 0;
		Iterator<MovieShow> li = movieShow.iterator();
		while(li.hasNext()) {
			MovieShow ms = li.next();
			if(ms.getShowDate().equals(date)) {
				flag++;
			System.out.println("-----------------------------");
			System.out.println("Date "+ms.getShowDate());
			MovieShowInfo msf[] = ms.getMovieShowInfo();
			for(MovieShowInfo mm : msf) {
				System.out.println("Show Time "+mm.getShowTime()+" Number of Seats "+mm.getNumberOfSeats()+" Price "+mm.getAmount());
			}
			System.out.println("------------------------------");
			}
		}
		if(flag==0) {
			System.out.println("No Show available on that date "+date);
		}
	}
	
		 public void showAvailableDates1() {
		        System.out.println("Available Show Dates:");
		        for (MovieShow ms : movieShow) {
		            System.out.println(ms.getShowDate());
		        }
		    }

		    public void displayAvailableShowsByDate(String date) {
		    	 System.out.println("Available Shows on " + date + ":");
		    	    for (MovieShow ms : movieShow) {
		    	        if (ms.getShowDate().equals(date)) {
		    	            MovieShowInfo[] showInfo = ms.getMovieShowInfo();
		    	            for (MovieShowInfo info : showInfo) {
		    	                if (info.getNumberOfSeats() > 0) {
		    	                    System.out.println(info.getShowTime() + " - Amount: " + info.getAmount());
		    	                }
		    	            }
		    	            break;
		            }
		        }
		    }

		    public void bookTicket() {
		        System.out.print("Enter the desired show date (e.g., 8-Dec): ");
		        String selectedDate = scanner.nextLine();

		        // Display available shows for the selected date
		        displayAvailableShowsByDate(selectedDate);

		        // Ask for the desired show time
		        System.out.print("Enter the desired show time: ");
		        String selectedShowTime = scanner.nextLine();

		        // Ask for the preferred seat selection
		        System.out.print("Enter the preferred seat selection: ");
		        String selectedSeat = scanner.nextLine();

		        // Book the ticket
		        boolean bookingSuccess = performBooking(selectedDate, selectedShowTime, selectedSeat);

		        if (bookingSuccess) {
		            System.out.println("Booking successful!");
		        } else {
		            System.out.println("Booking failed. Please try again.");
		        }
		    }

		    private boolean performBooking(String date, String showTime, String seatNumber) {
		        for (MovieShow ms : movieShow) {
		            if (ms.getShowDate().equals(date)) {
		                MovieShowInfo[] showInfo = ms.getMovieShowInfo();
		                for (MovieShowInfo info : showInfo) {
		                    if (info.getShowTime().equals(showTime) && info.getNumberOfSeats() > 0) {
		                        // Update the seat availability
		                        info.setNumberOfSeats(info.getNumberOfSeats() - 1);
		                        return true;
		                    }
		                }
		                break;
		            }
		        }
		        return false;
		    }
		    public void bookTicket(String selectedDate, Scanner scanner) {
		        // Display available shows for the selected date
		        displayAvailableShowsByDate(selectedDate);

		        // Ask for the desired show time
		        System.out.print("Enter the desired show time: ");
		        String selectedShowTime = scanner.nextLine();

		        // Ask for the number of seats to reserve
		        System.out.print("Enter the number of seats you want to reserve: ");
		        int numberOfSeats = scanner.nextInt();

		        // Book the ticket
		        boolean bookingSuccess = performBooking(selectedDate, selectedShowTime, numberOfSeats);

		        if (bookingSuccess) {
		            System.out.println("Booking successful! Total Amount: " + calculateTotalAmount(selectedDate, selectedShowTime, numberOfSeats));
		        } else {
		            System.out.println("Booking failed. Please try again.");
		        }
		    }
		    private boolean performBooking(String date, String showTime, int numberOfSeats) {
		        for (MovieShow ms : movieShow) {
		            if (ms.getShowDate().equals(date)) {
		                MovieShowInfo[] showInfo = ms.getMovieShowInfo();
		                for (MovieShowInfo info : showInfo) {
		                    if (info.getShowTime().equals(showTime) && info.getNumberOfSeats() >= numberOfSeats) {
		                        // Update the seat availability
		                        info.setNumberOfSeats(info.getNumberOfSeats() - numberOfSeats);
		                        return true;
		                    }
		                }
		            }
		        }
		        return false;
		    }
		    private int calculateTotalAmount(String date, String showTime, int numberOfSeats) {
		        for (MovieShow ms : movieShow) {
		            if (ms.getShowDate().equals(date)) {
		                MovieShowInfo[] showInfo = ms.getMovieShowInfo();
		                for (MovieShowInfo info : showInfo) {
		                    if (info.getShowTime().equals(showTime)) {
		                        // Calculate total amount based on the fare and number of seats
		                        return info.getAmount() * numberOfSeats;
		                    }
		                }
		            }
		        }
		        return 0;
		    }

		    // Your existing methods for showMoviewAndSeatInfo, searchMoviInfoByDate, etc.

		    public void closeScanner() {
		        scanner.close();
	}

}
