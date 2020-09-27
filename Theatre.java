package project_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import project_1.Movies.Status;


public class Theatre {
	public static void main(String[] args) throws IOException, ParseException {
	
	//Create linked list
	Deque<Movies> list = new LinkedList<Movies>();
	// Create iterator
	Iterator<Movies> it = list.iterator();
	// Data fields of {Movies}
	Date releaseDate;
	String name;
	String desc;
	Date receivedDate;
	Status status;
	// For formating dates
	SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
	sdfrmt.setLenient(false);
		
	//Create scanner
	Scanner scanner = new Scanner(System.in);
	
	//Create file input/output stream
	FileInputStream inputFile = new FileInputStream("Movies.txt");
	Scanner reader = new Scanner(inputFile);
	
	//Create text based menu
	System.out.println("Please choose an option: ");
	System.out.println("Press 'D' to display movies.");
	System.out.println("Press 'A' to add a movie.");
	System.out.println("Press 'S' to show movies with a given release date.");
	System.out.println("Press 'E' to edit movies.");
	System.out.println("Press 'C' to count movies.");
	System.out.println("Press 'X' to terminate program.");
	String option = scanner.next();
	
	
	// Boolean for while loop
	Boolean run = true;
	while (run) {
		if (option.toUpperCase().equals("D")) {
			System.out.println("You have selected to display movies.");
			//Code to display movies
		} else if (option.toUpperCase().equals("A")) {
			System.out.println("You have selected to add a movie.");
			// Getting the info for the movie
			String[] movieInfo = reader.nextLine().split(", ");
			// Storing the info
			name = movieInfo[0];
			// Checking if the dates are correctly formated.
			try {
				releaseDate = sdfrmt.parse(movieInfo[1]);
				receivedDate = sdfrmt.parse(movieInfo[3]);
			}
			catch (Exception e) {
				System.out.println("Invalid date format");
				continue;
			}
			desc = movieInfo[2];
			status = Status.valueOf(movieInfo[4].toUpperCase());
			// Adding to {list}
			list.addLast(new Movies(releaseDate, name, desc, receivedDate, status));
		} else if (option.toUpperCase().equals("S")) {
			System.out.println("You have selected to show movies with a given release date.");
			//Code to show movies with given release date
		} else if (option.toUpperCase().equals("E")) {
			System.out.println("You have selected to edit movies.");
			//Code to edit movies
		} else if (option.toUpperCase().equals("C")) {
			System.out.println("You have selected to count movies.");
			//Code to count movies
		} else if (option.toUpperCase().equals("X")) {
			System.out.println("You have selected to terminate the program.");
			run = false;
			break;
		} else {
			System.out.println("You have selected an invalid option, please try again.");
			continue;
		}
		System.out.println("\nPlease choose an option: ");
		System.out.println("Press 'D' to display movies.");
		System.out.println("Press 'A' to add a movie.");
		System.out.println("Press 'S' to show movies with a given release date.");
		System.out.println("Press 'E' to edit movies.");
		System.out.println("Press 'C' to count movies.");
		System.out.println("Press 'X' to terminate program.");
		option = scanner.next();
	}
	
	//Close Everything
	reader.close();
	scanner.close();
	inputFile.close();
	
	}
}
