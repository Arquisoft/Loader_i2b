package main.asw.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;

import main.asw.agents.Agent;
import main.asw.location.LatLng;
import main.asw.repository.DBUpdate;
import main.asw.repository.RepositoryFactory;

/**
 * Created by nicolas on 3/02/17 for citizensLoader0.
 */
class ParserImpl implements Parser {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(Parser.class);

    private CellLikeDataContainer dataSource;
    private List<Agent> users;
    private String csvdoc;

    ParserImpl(String filename) throws IOException {
        this.dataSource = new ApachePoiDataContainer(filename);
    }
    
    ParserImpl(String filename, String csv) throws IOException {
        this(filename);
        this.csvdoc = csv;
    }


    @Override
    public void readList() {
        try {
            loadData();
        } catch (IOException e) {
            log.error("Error handling the file");
        }
    }

    @Override
    public void insert() {
        DBUpdate dbupdate = RepositoryFactory.getDBUpdate();
        dbupdate.insert(users);
        dbupdate.writeReport();
    }


    private void loadData() throws IOException {
        List<Agent> users = new ArrayList<>();

        while (dataSource.nextRow()) {
            if (dataSource.getNumberOfColumns() == 7) {
                try {
                    users.add(rowToAgent());
                } catch (ParseException | IllegalArgumentException e) {
                    //Thrown by the Date Parser
                    log.error("ParseError: Error reading line " + dataSource.toString() +
                            " " + e.getMessage(), dataSource.getCurrentRow());
                }
            } else {
                log.error("ParseError: Error reading line " + dataSource.toString() +
                        " the number of columns is different than expected", dataSource.getCurrentRow());
            }

        }
        this.users = users;	
    }
    
    /**
     * public Agent(int agentKind, String name,String email, String id,LatLng location) {
     * @return
     * @throws ParseException
     */
    private Agent rowToAgent() throws ParseException {
        String kindstr = dataSource.getCell(0);
        int kind = Integer.parseInt(kindstr);
        String name = dataSource.getCell(1);
        String email = dataSource.getCell(2);
        String id = dataSource.getCell(3);  
        String locationstr[] = dataSource.getCell(4).split(","); // convert to LatLng
        LatLng location = parseLocation(locationstr);
        
        if(isAgentTypeCorrect(kind)){ // is optional
        	 return new Agent(kind,
                     name,
                     email,
                     id,
                     location);
        }
       
        return null;
    }
    
    /**
	 * This method parses the CSV file in order to make sure that the type of agent is allowed
	 * @param kind
	 * @return true if it exists
	 */
	private boolean isAgentTypeCorrect(int kind) {
		try (BufferedReader br = new BufferedReader(new FileReader(csvdoc))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] agentType = line.split(",");
				if (kind == Integer.valueOf(agentType[0])) {
					return true;
				} else
					continue;
			}
			br.close();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


    /**
     * @author PBalbuena
     * @param locationstr
     * @return
     */
    private LatLng parseLocation(String[] locationstr) {
    	LatLng location = new LatLng(Double.parseDouble(locationstr[0]),
				Double.parseDouble(locationstr[1]));
		return location;
	}



    private Date parseDate(String birthDateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        df.setLenient(false);
        date = df.parse(birthDateString);
        return date;
    }

    public List<Agent> getUsers() {
        return users;
    }

}
