package reverse_words_string;

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * @author Alex Pumnea
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        for (int i = 0, j = words.length - 1; i < j; i++, j--) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        }
        return String.join(" ", words);
    }
}
