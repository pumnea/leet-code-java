package substring_with_words_concatenation;

import java.util.*;

/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab"
 * are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation
 * of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 *
 * @author Alex Pumnea
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int strLen = s.length();
        int wordLen = words[0].length();
        int substrLen = words.length * wordLen;

        if (strLen < substrLen) return result;


        if (!sameCharsOrSameWords(s, words, strLen, substrLen, result).isEmpty()) {
            return result;
        }

        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        int lastStartIdx = substrLen - wordLen;
        int lowerBound = strLen - substrLen;

        for (int i = 0; i <= lowerBound; i++) {
            Map<String, Integer> currentFreq = new HashMap<>(wordFreq);
            int matchedWordsCount = 0;


            for (int pointer = i; pointer <= i + lastStartIdx; pointer += wordLen) {
                String rightWord = s.substring(pointer, pointer + wordLen);

                currentFreq.computeIfPresent(rightWord, (k, v) -> v - 1);

                if (currentFreq.containsKey(rightWord) && currentFreq.get(rightWord) == 0) {
                    matchedWordsCount++;
                }

                if (matchedWordsCount == wordFreq.size()) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    private static List<Integer> sameCharsOrSameWords(String s, String[] words, int strLen, int substrLen, List<Integer> result) {

        if (s.chars().allMatch(c -> c == s.charAt(0))
            && Arrays.stream(words).allMatch(word -> word.equals(words[0]))
            && s.charAt(0) == words[0].charAt(0)) {
            int end = strLen - substrLen;
            for (int i = 0; i <= end; i++) {
                result.add(i);
            }
            return result;
        }
        return Collections.emptyList();
    }
}
