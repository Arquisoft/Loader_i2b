package main.asw.repository.agentDao;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import main.asw.agents.Agent;
/**
 * 
 * @author Sergio Faya Fernandez
 *
 */
class AgentDaoImpl implements AgentDao {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(AgentDao.class);

    private MongoClient mongoClient = new MongoClient("localhost", 27017);
    private MongoDatabase db = mongoClient.getDatabase("aswdb");
    private MongoCollection<Document> coll = db.getCollection("agents");


    public AgentDaoImpl(){
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDatabase("aswdb");
        coll = db.getCollection("agents");
    }

    /**
     * Saves a given agent in the database if there ins't already one with the same id
     *
     * @param agent, Agent to be saved
     *
     */
    @Override
    public boolean saveAgent(Agent agent) {
        if (coll.find(eq("agentId", agent.getId())).first() == null) {
            Document doc = agent.getDocument();
            coll.insertOne(doc);
            log.info("Agent with id = " + agent.getId() + " added to the database");
            return true;
        }
        else{
            log.warn("An agent with id = " + agent.getId() + " is already in the database");
            return false;
        }
    }

    @Override
    public void setMongoHost(String host) {
        mongoClient = new MongoClient(host, 27017);
        db = mongoClient.getDatabase("aswdb");
        coll = db.getCollection("agents");
    }

}
