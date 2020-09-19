import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Very Nice Question
 *  Given a set of words (without duplicates), find all word squares you can build from them.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 *
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 */
public class Word_Squares_lc_sas1905 {
    static int N = 0;
    static String[] words = null;
    static HashMap<String, List<String> > prefixHashTable; // SInce the length of strings are atmost 5
    public static void main(String[] args) {
      String[] sample  = {"area","lead","wall","lady","ball"};
      solve_ques(sample);
    }

    private static void solve_ques(String[] sample) {
        N = sample[0].length();
        words = sample;
        buildPrefixHashTable();
        for(String word: words)
        {
            List<String> wordSquares = new ArrayList<>();
            wordSquares.add(word);
            backtracking(1, wordSquares);
        }
        return;
    }

    private static void backtracking(int step, List<String> wordSquares) {
        if (step == N) {
            for(String s: wordSquares){
                System.out.println(s);
            }
            System.out.println();
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }
        for(String s: getWordsWithPrefix(prefix.toString()))
        {
          wordSquares.add(s);
          backtracking(step+1, wordSquares);
          wordSquares.remove(wordSquares.size()-1);
        }

    }

    private static List<String> getWordsWithPrefix(String prefix)  {
        List<String> wordList = prefixHashTable.get(prefix);
        return (wordList != null ? wordList : new ArrayList<>());
    }

    private static void buildPrefixHashTable() {
        prefixHashTable = new HashMap<String, List<String>>();
        for(String s: words)
        {
            String temp = "";
            for(int i=1;i<N;i++){
               temp = temp + s.charAt(i-1);
               List<String> wordList = prefixHashTable.get(temp);
               if(wordList == null)
               {
                   wordList = new ArrayList<>();
                   wordList.add(s);
                   prefixHashTable.put(temp,wordList);
               }
               else
               {
                   wordList.add(s);
                   prefixHashTable.put(temp,wordList);
               }
            }
        }
    }
}
