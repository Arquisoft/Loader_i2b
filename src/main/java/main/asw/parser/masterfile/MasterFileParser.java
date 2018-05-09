package main.asw.parser.masterfile;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface MasterFileParser {	
	public String getKindNameOf(int kind) throws FileNotFoundException, IOException;
}