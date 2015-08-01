package substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

public class Solution extends TestCase {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        int wlen = words[0].length();
        int totalWords = words.length;
        for (String w : words) {
            addToDict(dict, w);
        }
        for (int i = 0; i <= s.length() - wlen * totalWords; i++) {
            HashMap<String, Integer> visited = new HashMap<String, Integer>();
            int j = 0;
            for (; j < totalWords; j++) {
                String word = s.substring(i + j * wlen, i + (j + 1) * wlen);
                if (dict.containsKey(word)
                        && (!visited.containsKey(word) || dict.get(word) > visited
                                .get(word))) {
                    addToDict(visited, word);
                } else {
                    break;
                }
            }
            if (j==totalWords) {
                result.add(i);
            }
        }
        return result;
    }

    void addToDict(HashMap<String, Integer> dict, String w) {
        if (!dict.containsKey(w)) {
            dict.put(w, 1);
        } else {
            dict.put(w, dict.get(w) + 1);
        }
    }

    public void testSample() {
        String[] words = new String[] { "a", "b" };
        assertEquals(new Integer(0), this.findSubstring("ab", words).get(0));
        words = new String[] { "word", "good", "best", "good" };
        assertEquals(new Integer(8),
                this.findSubstring("wordgoodgoodgoodbestword", words).get(0));
    }
}
