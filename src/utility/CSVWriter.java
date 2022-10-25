package utility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVWriter {
	public void Write(List<String[]> dataLines) throws IOException{
		File csvOutputFile = new File("output/genealogical_similiarity_score.csv");
	    try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
	        dataLines.stream()
	          .map(this::convertToCSV)
	          .forEach(pw::println);
	    }
	}
	public String convertToCSV(String[] data) {
	    return Stream.of(data)
	      .collect(Collectors.joining(","));
	}


}
