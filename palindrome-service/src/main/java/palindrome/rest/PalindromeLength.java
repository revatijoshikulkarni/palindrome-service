package palindrome.rest;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class PalindromeLength {

    public static void main(String args[]){

        String message = "abracadabra";
        List<String> palindromeList = longestPalindromesIn(message);
        log.info(palindromeList.toString());

    }

    private static List<String> longestPalindromesIn(String input) {
        // longest palindromes found until now
        List<String> result = new ArrayList<>();
        // length of longest palindrome found until now (all strings in result have this length)
        // initialize to a negative value to make sure that the first palindrome found will appear to be longer
        int longest = -1;
        // iterate over all possible substrings
        for (int start = 0; start <= input.length(); start++) {
            for (int end = start; end <= input.length(); end++) {
                String currentSubstring = input.substring(start, end);
                // only consider if at least as long as the longest palindrome already found
                if (currentSubstring.length() >= longest) {
                    if (isPalindrome(currentSubstring)) {
                        if (currentSubstring.length() > longest) {
                            // discard palindromes shorter than the one we have just found
                            result.clear();
                            longest = currentSubstring.length();
                        }
                        result.add(currentSubstring);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String candidate) {
        // the following is the easy way of reversing a string;
        // you may use your own code instead if you prefer
        StringBuilder reverse = new StringBuilder(candidate);
        reverse.reverse();
        return candidate.equals(reverse.toString());
    }
}
