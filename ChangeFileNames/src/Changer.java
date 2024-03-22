import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Changer {

	public static void change() throws IOException {

		String newFileNames = "/home/doglas/Documents/Larissa/2023_01_18_Genomas_Leptospira/names.txt";
		File folder = new File("/home/doglas/Documents/Larissa/2023_01_18_Genomas_Leptospira/");
		String newdir = "newFNANames";
		HashMap<String, String> fileNames = mapFileNames(newFileNames);
		createRenamedFiles(folder, newdir, fileNames);
	}

	private static HashMap<String, String> mapFileNames(String newFileNames) {

		BufferedReader reader;

		HashMap<String, String> fileNames = new HashMap<String, String>();
		try {
			reader = new BufferedReader(new FileReader(newFileNames));
			String line = reader.readLine();

			while (line != null) {
				String[] keyValue = line.split("\t"); // This would split it into sections divided by the tab
				fileNames.put(keyValue[0], keyValue[1]); // Store those values however you'd like
				System.out.println(fileNames.get(keyValue[0]));

				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileNames;
	}
	
	private static void createRenamedFiles(File folder, String newdir, HashMap<String, String> fileNames) throws IOException {
		
		// get all .fna files in the folder		
		List<File> fileList = Arrays.asList(folder.listFiles());
		Iterator<File> fileIterator = fileList.iterator();

		while (fileIterator.hasNext()) {
			File nextFile = fileIterator.next();
			if (nextFile.toString().endsWith(".fna")) {
				//System.out.println(nextFile);
				//System.out.println(fileNames.get(nextFile.getName()));
				// Rename files
				System.out.println(folder + "/" + nextFile.getName());
				File srcFile = new File(folder + "/" + nextFile.getName());
				File destFile = new File(folder + "/" + newdir + "/" + fileNames.get(nextFile.getName()));
				FileUtils.copyFile(srcFile, destFile);

			}
		}
	}
}
