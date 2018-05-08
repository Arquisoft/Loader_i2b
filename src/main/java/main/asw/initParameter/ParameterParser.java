package main.asw.initParameter;

import com.beust.jcommander.Parameter;
import com.mongodb.MongoClientURI;

public class ParameterParser {

	@Parameter(names = { "-h", "--help" },
	help = true, 
	description = "Display helps information")
	private boolean help;

	@Parameter(names = { "-a","--agentsFile" }, 
	required = true, 
	validateWith  = PathValidator.class,
	description = "Name of the file containing the data of agents")
	private String agentsPath;

	@Parameter(names = { "-t","--agentsType" }, 
	required = true, 
	validateWith  = PathValidator.class,
	description = "Name of the file containing the types of agents")
	private String typePath;
	
	@Parameter(names = { "-u","--mongoUri" }, 
	converter = MongoUriConverter.class, 
	description = "URI of the mongo database uri")
	private MongoClientURI mongoURI;
	
	@Parameter(names = { "-p","--port" }, 
	description = "Port of an localhost connection")
	private int dbPort = -1;
	
	public boolean isHelp() {
		return help;
	}

	public String getAgentsPath() {
		return agentsPath;
	}
	
	public String getTypePath() {
		return typePath;
	}

	public MongoClientURI getMongoURI() {
		return mongoURI;
	}

	public int getDbPort() {
		return dbPort;
	}

}
