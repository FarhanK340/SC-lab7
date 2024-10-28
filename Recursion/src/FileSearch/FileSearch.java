/**
 * 
 */
package FileSearch;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 */
public class FileSearch {
	private final boolean caseSensitive;

	public FileSearch(boolean caseSensitive) {
	        this.caseSensitive = caseSensitive;
	    }

	/**
	 * Searches for specified files within a given directory and its subdirectories.
	 * 
	 * @param directory the directory to search within.
	 * @param filenames an array of filenames to search for.
	 * @return a map where each filename maps to a list of paths where it was found.
	 */
	public Map<String, List<String>> searchFiles(File directory, String[] filenames) {
		Map<String, List<String>> results = new HashMap<>();
		for (String filename : filenames) {
			results.put(filename, new ArrayList<>());
		}
		recursiveSearch(directory, filenames, results);
		return results;
	}

	/**
	 * Recursively searches through directories to find matching filenames.
	 * 
	 * @param currentDirectory the current directory to search in.
	 * @param filenames        an array of filenames to look for.
	 * @param results          a map that collects the paths for each found file.
	 */
	private void recursiveSearch(File currentDirectory, String[] filenames, Map<String, List<String>> results) {
		if (currentDirectory == null || !currentDirectory.isDirectory()) {
			System.out.println("Directory " + currentDirectory + " is invalid or inaccessible.");
			return;
		}

		File[] files = currentDirectory.listFiles();
		if (files == null)
			return;

		for (File file : files) {
			if (file.isFile()) {
				for (String filename : filenames) {
					boolean match = caseSensitive ? file.getName().equals(filename): file.getName().equalsIgnoreCase(filename);
					if (match) {
						results.get(filename).add(file.getAbsolutePath());
					}
				}
			} else if (file.isDirectory()) {
				recursiveSearch(file, filenames, results);
			}
		}
	}

}
