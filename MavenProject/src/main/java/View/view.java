package View;

import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import DAO.Llibres;
import DAO.User;
import Model.UserCRUD;


public class view {

	static Scanner sc;
	ArrayList<User> users = new ArrayList<>();

	// Constructor con parámetro Scanner 
    public view(Scanner sc) {	
        this.sc = sc;
    }
  	
	public boolean login() {
        System.out.print("Gmail: ");
        String gmail = sc.next().toLowerCase();
        System.out.print("Password: ");
        String contraseña = sc.next().toLowerCase();


        // Verificar si las credenciales son correctas
        if (UserCRUD.checkLogin(gmail, contraseña)) {
        	System.out.println("Welcome!");
        	return true;
        } else {
            return false; 
        }
    }  
	
	 public User register() {
	        System.out.print("Name: ");
	        String name = sc.next();
	        System.out.print("Gmail: ");
	        String gmail = sc.next();
	        System.out.print("Password: ");
	        String password = sc.next();

	        if (name.length() < 2 || gmail.length() < 2 || password.length() < 4) {
	            System.out.println("Invalid data. Minimum 2 characters for first/last name and 4 for password.");
	            return null;
	        }

	        
	        System.out.println("User registered correctly in the database.");
	        return new User(name, gmail, password);
	    }
	
	 public static Llibres addNewBook() {
		 
		    String newBook = "";
		    while (newBook.isEmpty()) {
		        System.out.println("Enter the title of the book: ");
		        newBook = sc.next();
		        if (newBook.isEmpty()) {
		            System.err.println("Title cannot be empty.");
		        }
		    }
		    
		    String newAutor = "";
		    while (newAutor.isEmpty()) {
		        System.out.println("Enter the author of the book:");
		        newAutor = sc.next();
		        if (newAutor.isEmpty()) {
		            System.err.println("Author cannot be empty.");
		        }
		    }
		    
		    int newYearOfPubli = 0;
		    while (newYearOfPubli <= 0) {
		        System.out.println("Enter the year of publication of the book: ");
		        if (sc.hasNextInt()) {
		            newYearOfPubli = sc.nextInt();
		            if (newYearOfPubli <= 0) {
		                System.err.println("Year must be a positive number.");
		            }
		        } else {
		            System.err.println("Invalid format, please enter a valid year:");
		            sc.next();
		        }
		    }
		    
		    String newDescription = "";
		    while (newDescription.isEmpty()) {
		        System.out.println("Enter the description of the book: ");
		        newDescription = sc.next();
		        if (newDescription.isEmpty()) {
		            System.err.println("Description cannot be empty.");
		        }
		    }
		    
		    String newCategory = "";
		    while (newCategory.isEmpty()) {
		        System.out.println("Enter the category of book (ex. Drama, Science fiction...):");
		        newCategory = sc.next();
		        if (newCategory.isEmpty()) {
		            System.err.println("Category cannot be empty.");
		        }
		    }
			return new Llibres(newBook, newAutor, newYearOfPubli, newDescription, newCategory);
		}
	 
	public int secondMenu() {
		System.out.println("\n=== LLIBCAT - Library ===");
		System.out.println("1. Add book");
		System.out.println("2. See all books");
		System.out.println("3. Search book by date");
		System.out.println("0. Exit");
		System.out.print("\nSelect an oprtion: ");

		return sc.nextInt();
	}
}
