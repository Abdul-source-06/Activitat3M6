package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import DAO.User;

public class FileManager {
	
	    private static final String FILE_PATH = "users.txt";

	    public static void saveUsers(ArrayList<User> users) {
	        try (FileWriter fw = new FileWriter(FILE_PATH);
	             BufferedWriter bw = new BufferedWriter(fw)) {
	            for (User user : users) {
	                bw.write(user.getName() + "," + user.getSurname() + "," + user.getPaswd());
	                bw.newLine();
	            }
	        } catch (IOException e) {
	            System.out.println("Error al guardar usuarios: " + e.getMessage());
	        }
	    }

	    public static ArrayList<User> loadUsers() {
	        ArrayList<User> users = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                users.add(new User(data[0], data[1], data[2]));
	            }
	        } catch (IOException e) {
	            System.out.println("Archivo de usuarios no encontrado. Se creará uno nuevo.");
	        }
	        return users;
	    }
}
