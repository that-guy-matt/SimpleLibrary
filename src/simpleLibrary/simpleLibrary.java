package simpleLibrary;

import java.util.HashMap;
import textio.TextIO;

public class simpleLibrary {
	
	public static void main(String[] args) {

		/* initialize books hashmaps */
		HashMap<String, Integer> booksInLibrary = new HashMap<String, Integer>();
		HashMap<String, Integer> booksBorrowed = new HashMap<String, Integer>();
		
		while (true) {
			
			// display menu
			System.out.printf("""
Welcome to the simple library system.
Please make a selection from the following menu:

1. Add book
2. Borrow books
3. Return books
4. Display books
5. Exit
											""");
			
			// get user's menu selection
			System.out.print("Please type your selection: ");
			int menuSelection = TextIO.getlnInt();
			
			switch (menuSelection) {
			
			case 1: // case to add book
				// Prompt the user to enter the book title, author, and quantity.
				System.out.print("\nPlease enter a book name and author, coma separated: ");
				String newBook = TextIO.getln();
				System.out.print("\nPlease enter the quantity to add: ");
				int bookQuantity = TextIO.getlnInt();
				
				// if book is present in hashmap, increase quantity
				booksInLibrary.computeIfPresent(newBook, (key, val) -> val + bookQuantity);
				// if book is absent, add new book
				booksInLibrary.putIfAbsent(newBook, bookQuantity);
				System.out.println("");
				continue;
				
			case 2: // case to borrow books
				System.out.print("Which book would you like to borrow? Please input book title and author, separated by a coma: ");
				String borrowedBook = TextIO.getln();
				System.out.println("How many copies are you borrowing? ");
				int borrowQuantity = TextIO.getlnInt();
				
				// check if book exists
				if (booksInLibrary.containsKey(borrowedBook)) {
					// check if book has sufficient quantity available
					if (booksInLibrary.get(borrowedBook) >= borrowQuantity) {
						// remove borrowed book quantity from library
						booksInLibrary.compute(borrowedBook, (key, val) -> val - borrowQuantity);
						// if book is already borrowed, updated borrowed quantity
						booksBorrowed.computeIfPresent(borrowedBook, (key, val) -> val + borrowQuantity);
						// if book is not borrowed yet, add it to borrowed book hashmap
						booksBorrowed.putIfAbsent(borrowedBook, borrowQuantity);
						System.out.println("You have borrowed a book.");
					} else {
						System.out.println("Insufficient quantity of requested book.");
					}
				} else {
					System.out.println("Book is not available in the library.");
				}
				System.out.println("");
				continue;
				
			case 3: // case to return books
				System.out.print("\nWhich book would you like to return? Please input book title and author name separated by a coma: ");
				String returnedBook = TextIO.getln();
				System.out.print("How many copies are you returning? ");
				int returnQuantity = TextIO.getlnInt();
				
				// check if book has been borrowed
				if (booksBorrowed.containsKey(returnedBook)) {
					// check if returned quantity is less or equal to borrowed quantity
					if (booksBorrowed.get(returnedBook) >= returnQuantity) {
						// remove returned books from borrowed book hashtable
						booksBorrowed.compute(returnedBook, (key, val) -> val - returnQuantity);
						// check if all borrowed copies are returned
						if (booksBorrowed.get(returnedBook) == 0) {
							// remove book from borrowed books if all copies are returned
							booksBorrowed.remove(returnedBook);
						}
						// add returned book back to library
						booksInLibrary.compute(returnedBook, (key, val) -> val + returnQuantity);
					} else {
						System.out.println("You cannot return more copies than you borrowed.");
					}
				} else {
					System.out.println("This book has not been borrowed.");
				}
				
				System.out.println("");
				continue;
				
			case 4: // case to display books. this was just used for diagnostics
				System.out.println("\nIn library: " + booksInLibrary.toString());
				System.out.println("\nBorrowed: " + booksBorrowed.toString());
				System.out.println("");
				continue;
				
			case 5:
				System.out.println("\nThank you for using the Simple Library. Goodbye.");
				System.exit(1);
				
			default:
				System.out.println("\nPlease input a single digit 1, 2, 3, or 4.");
				continue;
			} // end menu
		} // end program loop
	} // end main
} // end simpleLibrary class