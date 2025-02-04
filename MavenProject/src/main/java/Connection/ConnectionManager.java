package Connection;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConnectionManager {
    private static final String URI = "mongodb+srv://Abdul:abdul1234@cluster1.8tcez.mongodb.net/?retryWrites=true&w=majority&appName=Cluster1";
    
    public static MongoClient createMongoClient() {
        return MongoClients.create(URI);
    }
    
    public static void main(String[] args) {
        try (MongoClient mongoClient = createMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase("LlibCat");
            MongoCollection<Document> collection = database.getCollection("Llibres");
            
            System.out.println("Conexión establecida exitosamente");
        } catch (MongoException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}