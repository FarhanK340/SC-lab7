/**
 * 
 */
package StringPermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {
    
    /**
     * Generates all permutations of the given string.
     *
     * @param str the input string
     * @param allowDuplicates whether to allow duplicate permutations
     * @return a list of permutations
     */
    public static List<String> generatePermutations(String str, boolean allowDuplicates) {
            
        List<String> result = new ArrayList<>();
    
        if (str.isEmpty()) {
            result.add("");
            return result;
        }
        
        if (allowDuplicates) {
            // Use a regular ArrayList to store permutations with duplicates
            generatePermutationsHelper(str.toCharArray(), 0, result, null);
        } else {
            // Use a HashSet to store unique permutations and avoid duplicates
            Set<String> uniquePerms = new HashSet<>();
            generatePermutationsHelper(str.toCharArray(), 0, result, uniquePerms);
        }
        return result;
    }

    /**
     * Helper function to recursively generate permutations.
     *
     * @param chars       the characters of the string
     * @param index       the current index for swapping
     * @param result      the list to store generated permutations
     * @param uniquePerms set to track unique permutations (null if duplicates allowed)
     */
    private static void generatePermutationsHelper(char[] chars, int index, List<String> result, Set<String> uniquePerms) {
        if (index == chars.length - 1) {
            String permutation = new String(chars);
            if (uniquePerms == null || uniquePerms.add(permutation)) {
                result.add(permutation);
            }
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generatePermutationsHelper(chars, index + 1, result, uniquePerms);
            swap(chars, index, i); // Backtrack
        }
    }

    /**
     * Swaps two characters in a char array.
     *
     * @param chars the array of characters
     * @param i     the first index
     * @param j     the second index
     */
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
