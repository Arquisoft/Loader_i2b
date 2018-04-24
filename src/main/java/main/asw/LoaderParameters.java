package main.asw;

import java.net.URL;
import java.nio.file.Path;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.PathConverter;
import com.beust.jcommander.converters.URLConverter;

public class LoaderParameters {

	@Parameter(names = { "-h", "--help" },
	help = true, 
	description = "Display helps information")
	private boolean help;

	@Parameter(names = { "-p","--xlsPath" }, 
	required = true, 
	converter = PathConverter.class, 
	validateWith  = PathValidator.class,
	description = "Absolute path to file containing the data of agents")
	private Path agentsPath;

	@Parameter(names = { "-u","--mongoUrl" }, 
	converter = URLConverter.class, 
	description = "Absolute path to file containing the data of agents")
	private URL mongoURL;

	@Parameter(names = { "-p","--localPort" }, 
	description = "Absolute path to file containing the data of agents")
	private String mongoLocal;
	
	public boolean isHelp() {
		return help;
	}

	public Path getAgentsPath() {
		return agentsPath;
	}

	public URL getMongoURL() {
		return mongoURL;
	}

	public String getMongoLocal() {
		return mongoLocal;
	}

	@Override
	public String toString() {
		return "\nHelp=" +help+
				"\nXls Path=" + agentsPath +
				"\nLocal mongo conection=" + mongoLocal +
				"\nURL Mongo Connection=" + mongoURL;
	}

	
}
