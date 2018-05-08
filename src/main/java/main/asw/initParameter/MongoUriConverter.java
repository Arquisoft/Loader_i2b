package main.asw.initParameter;

import com.beust.jcommander.IStringConverter;
import com.mongodb.MongoClientURI;

public class MongoUriConverter implements IStringConverter<MongoClientURI> {

	@Override
	public MongoClientURI convert(String value) {
		return new MongoClientURI(value);
	}


}
