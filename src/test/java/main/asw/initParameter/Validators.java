package main.asw.initParameter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.beust.jcommander.ParameterException;
import com.mongodb.MongoClientURI;

public class Validators {

	@Test
	public void mongoUriConverterTest() {
		String uri ="mongodb://localhost:27017";
		MongoUriConverter converter =  new MongoUriConverter();
		MongoClientURI mongoUri = converter.convert(uri);
		assertEquals(new MongoClientURI(uri), mongoUri);
	}
	
	@Test(expected = ParameterException.class)
	public void pathValidatorTest() {
		PathValidator validator = new PathValidator();
		validator.validate("-p", "pruebaAgentes.xls");
		//Fail does not exists so it will throw an exception
		validator.validate("-p", "a");
		fail();
	}
}
