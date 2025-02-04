package DAO;

public class User {
	private String name;
	private String Surname;
	private String paswd;

	public User(String nombre, String apellido, String password) {
		this.name = nombre;
		this.Surname = apellido;
		this.setPaswd(password);
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getSurname() {
		return Surname;
	}

	// Setters
	public void setName(String nombre) {
		this.name = nombre;
	}

	public void setSurname(String apellido) {
		this.Surname = apellido;
	}

	public String getPaswd() {
		return paswd;
	}

	public void setPaswd(String paswd) {
		this.paswd = paswd;
	}
}
