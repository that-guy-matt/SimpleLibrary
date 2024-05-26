# Simple Library
This application is a simple front end for a library management system.
It handles adding new books to the library, loaning books to users, returning books into the library, and displaying the list of books.
When the program starts, you will be prompted with a text based menu to interact with the system.

## Adding a new book
After selecting to add a new book, you will be prompted to enter the title followed by the author's name, coma separated. Then you will be asked to input the quantity of the book being added to the library.

## Borrowing a book
Selecting to borrow a book, you will be prompted to input the book title and author, coma separated. It is important that this all matches or it will not work. This is not the best way this could be handled, but at the time of writing this app, I didn't know a better way to handle it and I probably wont bother to come back and update this app.
You will want to selecct to display all books first so you can have the exact name and author of the book as it was inputted previously.

## Returning books
Selecting to a return a book will also prompt for the exact title and author, coma separated, as it is stored in the program. Otherwise, it will produce an error. Again, this isn't really a good way to solve this, but at the time I didn't know a better way.

## Display books
Selecting to display the books will produce a textual list of the books stored in the library and the quantities. It will also display which books are loaned out and the quantity.