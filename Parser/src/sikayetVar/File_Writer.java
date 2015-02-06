package sikayetVar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class File_Writer {
	/**
	 * Writes the complaint object to the file named as parameter.
	 * 
	 * @param compObj
	 * @param fileName
	 * @throws IOException
	 */
	public void createJson(ArrayList<Complaint> compObj, String fileName)
			throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(compObj);
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		out.write(json);
		out.newLine();
		out.close();
		System.out.println(fileName + " created!");
	}
}
