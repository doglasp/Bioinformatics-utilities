import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GetFileNames {

	public static void getFileNames() throws IOException {

		File folder = new File("/home/doglas/Documents/Larissa/2023_01_18_Genomas_Leptospira/");
		createRenamedFiles(folder);
	}

	private static void createRenamedFiles(File folder)
			throws IOException {

		// get all .fna files in the folder
		List<File> fileList = Arrays.asList(folder.listFiles());
		Iterator<File> fileIterator = fileList.iterator();

		while (fileIterator.hasNext()) {
			File nextFile = fileIterator.next();
			if (nextFile.toString().endsWith(".fna")) {
				System.out.println(nextFile.getName());
			}
		}
	}
}