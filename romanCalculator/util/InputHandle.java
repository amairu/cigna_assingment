package romanCalculator.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputHandle {
	public static List<String> readFileFromCurrentDirectory(String fileName) throws IOException, NullPointerException {
		List<String> lineList = new ArrayList<String>();
		
		File dir = new File(".");
		File file = new File(dir.getCanonicalPath() + File.separator + fileName);
		
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		while ((line = br.readLine()) != null) {
			lineList.add(line);
		}
		br.close();
		
		return lineList;
	}
}
