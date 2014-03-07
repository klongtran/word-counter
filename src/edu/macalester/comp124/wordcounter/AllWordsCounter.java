package edu.macalester.comp124.wordcounter;

import java.util.Set;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;

	// TODO: initialize instance variable to hold MAX_WORDS objects
    private SingleWordCounter counters[] = new SingleWordCounter[MAX_WORDS];

    public int getNumWords() {
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == null) {
                return i;
            }
        }
        return counters.length;
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        for (SingleWordCounter swc : counters) {
            // If you find the word increment the count and return
            if (swc != null && swc.wordMatches(word)) {
                swc.incrementCount();
                return;
            }
        }

        // You didn't find the word. Add a new word counter to the array.
        // Don't forget to increment the word's count to get it to 1!
        int n = getNumWords();
        counters[n] = new SingleWordCounter(word);
        counters[n].incrementCount();
	}
	
	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            // If you find the word return the count
            if (counters[i].wordMatches(word)) {
                return counters[i].getCount();
            }
        }

        // You didn't find the word.
        return 0;
	}
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String []  getAllWords() {
        // part one: create an array of strings of size equal to the number of words
        int n = getNumWords();
        String words[] = new String[n];  // FIXME
        for (int i = 0; i < n; i++) {
            words[i] = counters[i].getWord();
        }
        return words;
	}
}
















