
package Libress;

import java.sql.Date;
import java.util.List;

public class Llibres {
	
	private String id;
	private String titol;
	private String autor;
	private Date any_Publicacio;
	private String descripcio;
	private List<String> categories;
	
	public Llibres(String id, String titol, String autor, Date any_publicacio, String descripcio, List<String> categories) {
		this.id=(id);
		this.titol=(titol);
		this.autor=(autor);
		this.any_Publicacio=(any_publicacio);
		this.descripcio=(descripcio);
		this.categories=(categories);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public Date getAny_Publicacio() {
		return any_Publicacio;
	}

	public void setAny_Publicacio(Date any_Publicacio) {
		this.any_Publicacio = any_Publicacio;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
	@Override
    public String toString() {
        return "Llibre: " +
                "Id='" + id + '\'' +
                ", Titol='" + titol + '\'' +
                ", Autor='" + autor + '\'' +
                ", Any de Publicacio=" + any_Publicacio +
                ", Descripcio='" + descripcio + '\'' +
                ", Categories=" + categories;
    }
}
