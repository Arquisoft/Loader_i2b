package main.asw.dbupdate.dao;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import main.asw.agents.Agent;
import main.asw.dbupdate.dao.AgentDao;
/**
 * 
 * @author Sergio Faya Fernandez
 *
 */
public class AgentDaoImpl implements AgentDao {

    private final static Logger log = LoggerFactory.getLogger(AgentDao.class);

    private MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Document> coll;

    /**
     * Saves a given agent in the database if there ins't already one with the same id
     *
     * @param agent, Agent to be saved
     *
     */
    @Override
    public boolean saveAgent(Agent agent) {
        if (coll.find(eq("id", agent.getId())).first() == null) {
            Document doc = new Document()
            		.append("id", agent.getId())
            		.append("name", agent.getName())
            		.append("email", agent.getEmail())
            		.append("username", agent.getId())
            		.append("kind", agent.getAgentKind())
            		.append("location", agent.getLocation())
            		.append("password", agent.getPassword());
            
            coll.insertOne(doc);
            log.info("Agent with id = " + agent.getId() + " added to the database");
            return true;
        }
        else{
            log.warn("An agent with id = " + agent.getId() + " is already in the database");
            return false;
        }
    }

    /**
     * Configure the mongo host as a local connection
     */
    @Override
    public void setMongoHost(int port) {
        mongoClient = new MongoClient("localhost", port);
        db = mongoClient.getDatabase("aswdb");
        coll = db.getCollection("agents");
    }

    /**
     * Configure the Mongo host to establish a connection with a remote URI.
     */
	@Override
	public void setRemoteMongoConnection(MongoClientURI mongoUri) {
		mongoClient = new MongoClient(mongoUri);
        db = mongoClient.getDatabase("test");
        coll = db.getCollection("users");
	}

	

}
