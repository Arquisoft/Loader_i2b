package main.asw;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.asw.parser.Parser;
import main.asw.parser.ParserFactory;
import main.asw.repository.PersistenceFactory;

/**
 * Refactored by Sergio Faya Fernandez (changed user by agents)
 *
 * @author Labra
 * @author MIGUEL
 */

public class LoadAgents {

	
	private final static Logger log = LoggerFactory.getLogger(LoadAgents.class);
	
	public static void main(String... args) {
        if (args.length == 2) {
            try {
                PersistenceFactory.getAgentDao().setMongoHost(args[1]);
                Parser parser = ParserFactory.getParser(args[0]);
                parser.readList();
                parser.insert();
            } catch (IOException e) {
                printUsage();
            }
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println(
                "Invalid parameters. You must only have:\n" +
                "\t <xls path> \t <mongo host>"
        );
    }
}
