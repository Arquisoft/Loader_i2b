package main.asw.parser.masterfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
	

public class CSVFileParser implements MasterFileParser{
	
private String filePath;
	
	public CSVFileParser() {
		this.filePath = "master.csv";
	}
	
	public CSVFileParser(String filePath) {
		this.filePath = filePath;
	}

	public String getKindNameOf(int kind) throws FileNotFoundException, IOException {
		Reader reader = null;
        try {
	        	reader = new FileReader(filePath);
	        	Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);
	        	for (CSVRecord record : records) {
	        		this.assertValidRecord(record);
	        		
	        	    int kindCode = Integer.valueOf(record.get(0));
	        	    if (kindCode == kind) return record.get(1);
	        	}
        } finally {
            if (reader != null) { try { reader.close(); } catch (IOException e) { e.printStackTrace(); } }
        }
        
		return null;
	}

	private void assertValidRecord(CSVRecord record) {
		assert (record.size() == 2) : "Invalid number of columns";
	}
}
