package main.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import main.asw.agents.AgentsTest;
import main.asw.encryption.EncryptionTest;
import main.asw.parser.ParserTest;
import main.asw.report.ReportWriterTest;
import main.asw.repository.MongoDBTest;
import main.asw.repository.PersistenceTest;
import main.asw.repository.daoTest.DaoTest;
import main.asw.util.CheckerTests;
import main.asw.util.LatLngTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	DaoTest.class,
	AgentsTest.class,
	EncryptionTest.class,
	ParserTest.class,
	ReportWriterTest.class,
	MongoDBTest.class,
	PersistenceTest.class,
	CheckerTests.class,
	LatLngTest.class
	})
public class AllTests {
	
}
