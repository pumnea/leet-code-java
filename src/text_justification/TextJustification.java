package text_justification;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly
 * maxWidth characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * @author Alex Pumnea
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int lineLength = 0;

        for (String word : words) {
            if (lineLength + word.length() + currentLine.size() > maxWidth) {
                result.add(formatLine(currentLine, maxWidth - lineLength, false));
                currentLine.clear();
                lineLength = 0;
            }
            lineLength += word.length();
            currentLine.add(word);
        }

        if (!currentLine.isEmpty()) {
            result.add(formatLine(currentLine, maxWidth - lineLength, true));
        }
        return result;
    }

    private String formatLine(List<String> words, int spaces, boolean isLastLine) {
        if (isLastLine || words.size() == 1) {
            return String.join(" ", words) + " ".repeat(spaces - (words.size() - 1));
        }

        int spacesNeeded = words.size() - 1;
        int spacePerWord = spaces / spacesNeeded;
        int extraSpacePerWord = spaces % spacesNeeded;

        StringBuilder justifiedLine = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            justifiedLine.append(words.get(i));
            if (i < spacesNeeded) {
                justifiedLine.append(" ".repeat(spacePerWord + (i < extraSpacePerWord ? 1 : 0)));
            }
        }
        return justifiedLine.toString();
    }
}
