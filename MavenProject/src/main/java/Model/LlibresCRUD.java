package Model;


import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class LlibresCRUD {


	private MongoDatabase database;

	public LlibresCRUD(MongoClient mongoClient) {
		this.database = mongoClient.getDatabase("LlibCat");
	}
	
public void addBook(String titol, String autor, int any_publi, String descripcio, String categories ) {
		
		MongoCollection<Document> collection = database.getCollection("Llibres");
		
		// Crear documento con los datos del usuario
		Document newBook = new Document();
		
		newBook.append("Title", titol );
		newBook.append("Autor", autor);
		newBook.append("Year of publication", any_publi);
		newBook.append("Description", descripcio);
		newBook.append("Category", categories);

		
		// Añadir el usuario en la colección
		
		collection.insertOne(newBook);
		
		System.out.println("!Book added correctly!");
		
	}


	
}
