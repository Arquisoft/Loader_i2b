package main.asw;

import com.beust.jcommander.IStringConverter;
import com.mongodb.MongoClientURI;

public class MyMongoUriConverter implements IStringConverter<MongoClientURI> {

	@Override
	public MongoClientURI convert(String value) {
		return new MongoClientURI(value);
	}


}
