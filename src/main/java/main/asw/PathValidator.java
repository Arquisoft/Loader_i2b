package main.asw;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class PathValidator implements IParameterValidator{

	@Override
	public void validate(String name, String value) throws ParameterException {
		Path path = Paths.get(value);
		if(!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			String message = value + "does not exist";
			throw new ParameterException(message);
		}
		if (!Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS)) {
			String message = value + "is not a file";
			throw new ParameterException(message);
		}
	}

}
