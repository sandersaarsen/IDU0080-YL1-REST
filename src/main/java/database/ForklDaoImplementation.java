/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Fork;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

public class ForklDaoImplementation implements ForklDao {

    protected MongoClient client;
    protected MongoDatabase db;
    protected MongoCollection collection;

    protected ArrayList<Fork> forks = new ArrayList<>();
    protected Fork fork;

    public ForklDaoImplementation() {
        client = new MongoClient();
        db = client.getDatabase("kahvlid");
        collection = db.getCollection("mudelid");
    }

    @Override
    public ArrayList<Fork> findAll() {
        forks.clear();
        FindIterable<Document> documents = collection.find();
        documents.forEach(new Block<Document>() {
            @Override
            public void apply(final Document d) {
                Fork k = new Fork(d.get("_id").toString(), d.getInteger("pikkus"), d.getInteger("harusid"), d.getString("materjal"), d.getString("kirjeldus"));
                forks.add(k);
            }
        });

        return forks;
    }

    @Override
    public Fork findById(String id){
        fork = null;
        if(!ObjectId.isValid(id)) return null;
        FindIterable<Document> documents = collection.find(new Document("_id", new ObjectId(id)));
        documents.forEach(new Block<Document>() {
            @Override
            public void apply(final Document d) {
                fork = new Fork(d.get("_id").toString(), d.getInteger("pikkus"), d.getInteger("harusid"), d.getString("materjal"), d.getString("kirjeldus"));
            }
        });
        return fork;
    }

    @Override
    public void update(Fork k) {
        Document doc = new Document()
                .append("pikkus", k.getLength())
                .append("harusid", k.getTines())
                .append("materjal", k.getMaterial())
                .append("kirjeldus", k.getDescription());
        collection.replaceOne(new Document("_id", new ObjectId(k.getId())), doc);
    }
    
    @Override
    public void save(Fork k) {
        Document doc = new Document()
                .append("_id", new ObjectId())
                .append("pikkus", k.getLength())
                .append("harusid", k.getTines())
                .append("materjal", k.getMaterial())
                .append("kirjeldus", k.getDescription());
        collection.insertOne(doc);
    }

    @Override
    public ArrayList<Fork> findByParam(String field, String string) {
        forks.clear();
        FindIterable<Document> documents = collection.find(new Document(field, string));
        documents.forEach(new Block<Document>() {
            @Override
            public void apply(final Document d) {
                fork = new Fork(d.get("_id").toString(), d.getInteger("pikkus"), d.getInteger("harusid"), d.getString("materjal"), d.getString("kirjeldus"));
                forks.add(fork);
            }
        });
        return forks;
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }
}
