package main.asw.parser;

import main.asw.agents.Agent;
import main.asw.location.LatLng;
import main.asw.repository.DBUpdate;
import main.asw.repository.RepositoryFactory;
import main.asw.user.User;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nicolas on 3/02/17 for citizensLoader0.
 */
class ParserImpl implements Parser {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(Parser.class);

    private CellLikeDataContainer dataSource;
    private List<User> users;

    ParserImpl(String filename) throws IOException {
        this.dataSource = new ApachePoiDataContainer(filename);
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
        List<User> users = new ArrayList<>();

        while (dataSource.nextRow()) {
            if (dataSource.getNumberOfColumns() == 7) {
                try {
                    users.add(rowToUser());
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
     * 	public Agent(int agentKind, String name,String email, String id,LatLng location) {
     * @return
     * @throws ParseException
     */
    private Agent rowToAgent() throws ParseException {
        String kindstr = dataSource.getCell(0);
        int kind = Integer.parseInt(kindstr);
        String name = dataSource.getCell(1);
        String email = dataSource.getCell(2);
        String id = dataSource.getCell(3);
        if(kind == 2){ // is optional
        	
        }
        String locationstr = dataSource.getCell(4); // convert to LatLng
        LatLng location = parseLocation(locationstr);

        return new Agent(kind,
                name,
                email,
                id,
                location);

    }


    /**
     * @author PBalbuena
     * @param locationstr
     * @return
     */
    private LatLng parseLocation(String locationstr) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
     * CLASE A SUSTITUIR
     * @return
     * @throws ParseException
     */
    private User rowToUser() throws ParseException {
        String name = dataSource.getCell(0);
        String surname = dataSource.getCell(1);
        String email = dataSource.getCell(2);
        String birthDateString = dataSource.getCell(3);
        Date date = parseDate(birthDateString);
        String address = dataSource.getCell(4);
        String nationality = dataSource.getCell(5);
        String dni = dataSource.getCell(6);

        return new User(name,
                surname,
                email,
                date,
                address,
                nationality,
                dni);

    }

    private Date parseDate(String birthDateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        df.setLenient(false);
        date = df.parse(birthDateString);
        return date;
    }

    public List<User> getUsers() {
        return users;
    }

}
