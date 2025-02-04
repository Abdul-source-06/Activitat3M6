package View;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.User;
import Model.FileManager;

public class view {

	static Scanner sc = new Scanner(System.in);
	ArrayList<User> users = new ArrayList<>();

	public view() {
        this.users = FileManager.loadUsers();
    }
	public int showLoginMenu() {
     
        while(true) {
            // Mostrar el menú
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("Choose a option: ");
            while(!sc.hasNextInt()) {
            	System.err.println("Invalid option, enter a number:");
            	sc.next();
            }
            int option = sc.nextInt();
         

            switch(option) {
                case 1:
                    login(); // Llama al método para iniciar sesión
                    break;
                case 2: 
                    register(); // Llama al método para registrar un nuevo usuario
                    break;
                default: 
                    System.err.println("Invalid option");
                    break;
            }       
        }
    }
	
	private void login() {
        System.out.print("Name: ");
        String nombre = sc.next().toLowerCase();
        System.out.print("Surname: ");
        String apellido = sc.next().toLowerCase();
        System.out.print("Password: ");
        String contraseña = sc.next().toLowerCase();


        for (User user : users) {
            if (user.getName().equals(nombre) && user.getSurname().equals(apellido) && user.getPaswd().equals(contraseña)) {
                System.out.println("¡Welcome " + nombre + "!");
                return;
            }
        }

        System.err.println("There is no user with this informacion.");
    }  
	
	 private void register() {
	        System.out.print("Name: ");
	        String nombre = sc.next();
	        System.out.print("Surname: ");
	        String apellido = sc.next();
	        System.out.print("Password: ");
	        String password = sc.next();

	        if (nombre.length() < 2 || apellido.length() < 2 || password.length() < 4) {
	            System.out.println("Invalid data. Minimum 2 characters for first/last name and 4 for password.");
	            return;
	        }

	        users.add(new User(nombre, apellido, password));
	        FileManager.saveUsers(users);
	        System.out.println("User registrated correctly.");
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
