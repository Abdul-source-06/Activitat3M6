package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Logger;
import java.util.logging.Level;

import Connection.ConnectionManager;
import DAO.Llibres;
import DAO.User;
import Model.LlibresCRUD;
import Model.UserCRUD;
import View.view;

public class Conntroler {
	public static void main(String[] args) {

		/*
		 * Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		 * mongoLogger.setLevel(Level.OFF);
		 */

		Scanner sc = new Scanner(System.in);
		MongoClient db = ConnectionManager.getConnection();
		view View = new view(sc);

		UserCRUD user = new UserCRUD(db);
		LlibresCRUD bookCRUD = new LlibresCRUD(db);

		boolean exit = false;
		while (!exit) {
			// Mostrar el menú de login o registro y gestionar el flujo
			System.out.println("\n=== Welcome to LlibCat ===");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.print("Choose an option: ");

			while (!sc.hasNextInt()) {
				System.err.println("Invalid option, enter a number:");
				sc.next();
			}
			int option = sc.nextInt();

			switch (option) {
			case 1: // Opción de login
				if (!exit) {
					// Si login es exitoso, mostramos el segundo menú
					while (!exit) {

						View.secondMenu();
						int option2 = sc.nextInt();
						switch (option2) {
						case 1:
							Llibres llib = View.addNewBook();
							bookCRUD.addBook(llib);
							break;
							
						case 2:
							ArrayList<Llibres> llibres = bookCRUD.getAll();
							View.getAll(llibres);
						}
						
					}

				} else {
					System.err.println("Login failed. Please try again.");
				}
				break;

			case 2:
				User newUser = View.register();

				if (newUser != null) {
					// Guardar el nuevo usuario en la base de datos
					user.addUser(newUser);
				}
				break;
			default:
				System.err.println("Invalid option. Please try again.");
				break;
			}
		}

		sc.close(); // Cerrar el scanner cuando termine la ejecución
	}
}
