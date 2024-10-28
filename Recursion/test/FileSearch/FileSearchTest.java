package FileSearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;
import java.util.Map;

public class FileSearchTest {
    private FileSearch caseSensitiveSearcher;
    private FileSearch caseInsensitiveSearcher;

    @BeforeEach
    public void setUp() {
        // Initialize both case-sensitive and case-insensitive searchers
        caseSensitiveSearcher = new FileSearch(true);
        caseInsensitiveSearcher = new FileSearch(false);
    }

    @Test
    public void testFileFoundCaseSensitive() {
        // Test case-sensitive search for a specific file
        String[] filenames = {"testFile.txt"};
        Map<String, List<String>> results = caseSensitiveSearcher.searchFiles(new File("test/FileSearch/resources"), filenames);

        // Assert that the file is found and the path is correct
        assertFalse(results.get("testFile.txt").isEmpty(), "File should be found in case-sensitive mode.");
        assertTrue(results.get("testFile.txt").get(0).contains("resources\\testFile.txt"));
    }

    @Test
    public void testFileNotFound() {
        // Test with a non-existent file
        String[] filenames = {"nonExistentFile.txt"};
        Map<String, List<String>> results = caseSensitiveSearcher.searchFiles(new File("test/FileSearch/resources"), filenames);

        // Assert that no results are found
        assertTrue(results.get("nonExistentFile.txt").isEmpty(), "No paths should be returned for a non-existent file.");
    }

    @Test
    public void testFileFoundCaseInsensitive() {
        // Test case-insensitive search
        String[] filenames = {"testfile.txt"}; // different case than actual file
        Map<String, List<String>> results = caseInsensitiveSearcher.searchFiles(new File("test/FileSearch/resources"), filenames);

        // Assert that the file is found
        assertFalse(results.get("testfile.txt").isEmpty(), "File should be found in case-insensitive mode.");
    }

    @Test
    public void testMultipleFilesSearch() {
        // Test searching for multiple files in a single run
        String[] filenames = {"testFile.txt", "anotherFile.txt"};
        Map<String, List<String>> results = caseInsensitiveSearcher.searchFiles(new File("test/FileSearch/resources"), filenames);

        // Assert that both files are found
        assertFalse(results.get("testFile.txt").isEmpty(), "testFile.txt should be found.");
        assertFalse(results.get("anotherFile.txt").isEmpty(), "anotherFile.txt should be found.");
    }

    @Test
    public void testCountOccurrencesOfFile() {
        // Test that the file is found multiple times if it exists in different directories
        String[] filenames = {"duplicateFile.txt"};
        Map<String, List<String>> results = caseInsensitiveSearcher.searchFiles(new File("test/FileSearch/resources"), filenames);

        // Assert that the file appears twice
        assertEquals(2, results.get("duplicateFile.txt").size(), "File should be found in two different locations.");
    }

    @Test
    public void testInvalidDirectory() {
        // Test searching in a non-existent directory
        String[] filenames = {"testFile.txt"};
        Map<String, List<String>> results = caseInsensitiveSearcher.searchFiles(new File("test/Files"), filenames);

        // Assert that the search result is empty
        assertTrue(results.get("testFile.txt").isEmpty(), "No paths should be returned for an invalid directory.");
    }
}
