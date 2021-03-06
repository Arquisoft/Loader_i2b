package main.loadAgents;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import main.asw.dbupdate.PersistenceFactory;
import main.asw.initParameter.ParameterParser;
import main.asw.parser.Parser;
import main.asw.parser.ParserFactory;
import main.asw.util.Checker;

/**
 * Refactored by Sergio Faya Fernandez (changed user by agents)
 *
 * @author Labra
 * @author MIGUEL
 */

public class LoadAgents {

	@SuppressWarnings("unused")
	private final static Logger log = LoggerFactory.getLogger(LoadAgents.class);
	private static boolean runnable = true;
	final ParameterParser params = new ParameterParser();

	private static void printWelcomeMessage() {
		System.out.println("\r\n" + "   __                    _                       _  ____   _      \r\n"
				+ "  / /   ___    __ _   __| |  ___  _ __          (_)|___ \\ | |__   \r\n"
				+ " / /   / _ \\  / _` | / _` | / _ \\| '__|         | |  __) || '_ \\  \r\n"
				+ "/ /___| (_) || (_| || (_| ||  __/| |            | | / __/ | |_) | \r\n"
				+ "\\____/ \\___/  \\__,_| \\__,_| \\___||_|     _____  |_||_____||_.__/  \r\n"
				+ "                                        |_____|                   \r\n" + "");
	}

	public static void main(String... args) {
		printWelcomeMessage();
		LoadAgents agents = new LoadAgents();
		agents.manageCommandParameters(args);
		if(runnable) {
			agents.run();
		}
	}

	protected void manageCommandParameters(String... args) {
		JCommander jCommander = new JCommander(params);
		jCommander.setProgramName("loader");
		try {
			jCommander.parse(args);
			if (params.isHelp()) {
				runnable = false;
				printUsage(jCommander);
			}
		} catch (ParameterException e) {
			runnable = false;
			System.err.println("Invalid flags, introduce -h for help");
		}
	}

	protected void run() {
		try {
			if (params.getDbPort() == -1 && params.getMongoURI() == null) {
				PersistenceFactory.getAgentDao().setMongoHost(27017);
				System.out.println(
						"APPLICATION-USAGE: Using default configuration for the database. Open in localhost:27017");
			} else {
				if (params.getMongoURI() != null) {
					PersistenceFactory.getAgentDao().setRemoteMongoConnection(params.getMongoURI());
				} else if (params.getDbPort() != -1) {
					Checker.isLessThanZero(params.getDbPort());
					PersistenceFactory.getAgentDao().setMongoHost(params.getDbPort());
				}
			}
			// these files should never be wrong
			Parser parser = ParserFactory.getParser(params.getAgentsPath(), params.getTypePath());
			parser.readList();
			parser.insert();
		} catch (IOException e) {
			System.err.println("There is an error in the parsing process");
		} catch (Exception e) {
			System.err.println("An error occurred while running the application, use -h or --help to get help");
			e.printStackTrace(System.out);
		} finally {
			System.out.println("UPDATE TO DATABASE COMPLETED");
		}
	}

	private static void printUsage(JCommander jCommander) {
		jCommander.usage();
	}
}
