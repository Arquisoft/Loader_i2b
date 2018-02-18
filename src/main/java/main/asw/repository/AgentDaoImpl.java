package main.asw.repository;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import main.asw.agents.Agent;

/**
 * Created by MIGUEL on 16/02/2017.
 */
class AgentDaoImpl implements AgentDao {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(AgentDao.class);

    private MongoClient mongoClient = new MongoClient("localhost", 27017);
    private MongoDatabase db = mongoClient.getDatabase("aswdb");
    private MongoCollection<Document> coll = db.getCollection("users");


    public AgentDaoImpl(){
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDatabase("aswdb");
        coll = db.getCollection("users");
    }

    /**
     * Saves a given user in the database if there ins't already one with the same userId
     *
     * @param u User to be saved
     *
     */
    @Override
    public boolean saveUser(Agent u) {
        if (coll.find(eq("userId", u.getId())).first() == null) {
            Document doc = new Document("name", u.getName())
                    .append("location", u.getLocation())
                    .append("email", u.getEmail())
                    .append("id", u.getId())
                    .append("kind", u.getAgentKind());
            coll.insertOne(doc);
            log.info("User with userId = " + u.getId() + " added to the database");
            return true;
        }
        else{
            log.warn("A user with userId = " + u.getId() + " is already in the database");
            return false;
        }
    }

    @Override
    public void setMongoHost(String host) {
        mongoClient = new MongoClient(host, 27017);
        db = mongoClient.getDatabase("aswdb");
        coll = db.getCollection("users");
    }

}
