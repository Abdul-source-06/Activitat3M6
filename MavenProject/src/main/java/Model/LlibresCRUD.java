package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import DAO.Llibres;

public class LlibresCRUD {

	private MongoDatabase database;

	public LlibresCRUD(MongoClient mongoClient) {
		this.database = mongoClient.getDatabase("LlibCat");
	}

	public void addBook(Llibres llibre) {

		MongoCollection<Document> collection = database.getCollection("Llibres");

		// Crear documento con los datos del usuario
		Document newBook = new Document();

		newBook.append("Title", llibre.getTitol());
		newBook.append("Autor", llibre.getAutor());
		newBook.append("Year of publication", llibre.getAny_Publicacio());
		newBook.append("Description", llibre.getDescripcio());
		newBook.append("Category", llibre.getCategories());

		// Añadir el usuario en la colección

		collection.insertOne(newBook);

	}

	public ArrayList<Llibres> getAll() {

		ArrayList<Llibres> allBooks = new ArrayList<Llibres>();
		MongoCollection<Document> collection = database.getCollection("Llibres");
		for(Document dc : collection.find()) {
			Llibres l = new Llibres();
			l.setTitol(dc.getString("titol"));
			l.setAutor(dc.getString("autor"));
			l.setAny_Publicacio(dc.getInteger("anyPublicacio"));
			l.setDescripcio(dc.getString("descripcio"));
			l.setCategories(dc.getList("categories", String.class));
			
			allBooks.add(l);
		}
		return allBooks;
	}
	
	public ArrayList<Llibres> getBooksByYear(int year) {
	    ArrayList<Llibres> booksByYear = new ArrayList<>();
	    MongoCollection<Document> collection = database.getCollection("Llibres");

	    for (Document dc : collection.find(new Document("anyPublicacio", year))) {
	        Llibres l = new Llibres();
	        l.setTitol(dc.getString("titol"));
	        l.setAutor(dc.getString("autor"));
	        l.setAny_Publicacio(dc.getInteger("anyPublicacio"));
	        l.setDescripcio(dc.getString("descripcio"));
	        l.setCategories(dc.getList("categories", String.class));

	        booksByYear.add(l);
	    }

	    return booksByYear;
	}


}
