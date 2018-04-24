package main.asw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 * Refactored by Sergio Faya Fernandez (changed user by agents)
 *
 * @author Labra
 * @author MIGUEL
 */

public class LoadAgents {

	@SuppressWarnings("unused")
	private final static Logger log = LoggerFactory.getLogger(LoadAgents.class);

	final LoaderParameters params = new LoaderParameters();

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
		agents.run();
	}

	private void manageCommandParameters(String... args) {
		JCommander jCommander = new JCommander(params);
		jCommander.setProgramName("loader");
		try {
			jCommander.parse(args);
		} catch (ParameterException e) {
			System.err.println(e.getMessage());
			printUsage(jCommander);
		}

		if (params.isHelp()) {
			printUsage(jCommander);
		}
	}

	private void run() {
		//params getmongolocal
		if (args.length == 2) {
            try {
                PersistenceFactory.getAgentDao().setMongoHost(args[1]);
                Parser parser = ParserFactory.getParser(args[0]);
                System.out.println("Archivos aceptados (xls), leyendo...");
                parser.readList();
                parser.insert();
                System.out.println("Operaciones finalizadas");
            } catch (IOException e) {
                printUsage();
            }
        } else {
            printUsage();
        }
        //csv with kinds provided
        if (args.length == 3) { 
            try {
            	String csv = args[2];
                PersistenceFactory.getAgentDao().setMongoHost(args[1]);
                Parser parser = ParserFactory.getParser(args[0], csv);
                System.out.println("Archivos aceptados (xls y csv), leyendo...");
                parser.readList();
                parser.insert();
                System.out.println("Operaciones finalizadas");
            } catch (IOException e) {
                printUsage();
            }
        } else {
            printUsage();
            throw new IllegalArgumentException();
        }
	}

	private static void printUsage(JCommander jCommander) {
		jCommander.usage();
		System.exit(0);
	}
}
