package StringPermutation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

public class StringPermutationTest {

    @Test
    public void testPermutationsWithoutDuplicates_SimpleString() {
        // Given a simple string with no duplicate characters
        String input = "abc";
        
        // Generate permutations without allowing duplicates
        List<String> result = StringPermutation.generatePermutations(input, false);
        
        // Expected permutations (order does not matter)
        List<String> expected = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        
        // Assert that the result contains exactly the expected elements
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testPermutationsWithDuplicates_SimpleString() {
        // Given a simple string with no duplicate characters
        String input = "abc";
        
        // Generate permutations allowing duplicates (should be the same result)
        List<String> result = StringPermutation.generatePermutations(input, true);
        
        // Expected permutations (order does not matter)
        List<String> expected = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        
        // Assert that the result contains exactly the expected elements
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testPermutationsWithDuplicates_CharactersRepeated() {
        // Given a string with duplicate characters
        String input = "aab";
        
        // Generate permutations allowing duplicates
        List<String> result = StringPermutation.generatePermutations(input, true);
        
        // Expected permutations with duplicates allowed
        List<String> expected = Arrays.asList("aab", "aab", "aba", "aba", "baa", "baa");
        
        // Assert that the result contains exactly the expected elements
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testPermutationsWithoutDuplicates_CharactersRepeated() {
        // Given a string with duplicate characters
        String input = "aab";
        
        // Generate permutations without allowing duplicates
        List<String> result = StringPermutation.generatePermutations(input, false);
        
        // Expected permutations without duplicates
        List<String> expected = Arrays.asList("aab", "aba", "baa");
        
        // Assert that the result contains exactly the expected elements
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testEmptyString() {
        // Given an empty string
        String input = "";
        
        // Generate permutations (with or without duplicates)
        List<String> result = StringPermutation.generatePermutations(input, false);
        
        // Expected: empty list or a list with an empty string
        List<String> expected = Arrays.asList("");
        
        // Assert the result matches the expected output
        assertEquals(expected, result);
    }

    @Test
    public void testSingleCharacterString() {
        // Given a single-character string
        String input = "a";
        
        // Generate permutations (with or without duplicates)
        List<String> result = StringPermutation.generatePermutations(input, false);
        
        // Expected result is just the character itself
        List<String> expected = Arrays.asList("a");
        
        // Assert the result matches the expected output
        assertEquals(expected, result);
    }

    @Test
    public void testIdenticalCharacters() {
        // Given a string with all identical characters
        String input = "aaa";
        
        // Generate permutations without allowing duplicates
        List<String> result = StringPermutation.generatePermutations(input, false);
        
        // Expected result is just one permutation since all characters are the same
        List<String> expected = Arrays.asList("aaa");
        
        // Assert the result matches the expected output
        assertEquals(expected, result);
    }

    @Test
    public void testIdenticalCharactersWithDuplicatesAllowed() {
        // Given a string with all identical characters
        String input = "aaa";
        
        // Generate permutations allowing duplicates
        List<String> result = StringPermutation.generatePermutations(input, true);
        
        // Expected result (only one unique permutation, repeated)
        List<String> expected = Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa", "aaa");
        
        // Assert the result matches the expected output
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }
}