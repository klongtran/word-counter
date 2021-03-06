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
    SingleWordCounter counters[] = new SingleWordCounter[MAX_WORDS];

    public int getNumWords() {
        // TODO: count the number of distinct words,
        // ie. the number of non-null counter objects.
        int counter = 0;
        for (int i = 0; i < counters.length; i++){
            if (counters[i] != null){
                counter++;
            }
        }
        return counter;
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        int n = getNumWords();
        // If you find the word increment the count and return
        for (int i = 0; i < n; i++) {
            if (counters[i] != null && counters[i].wordMatches(word)) {
                counters[i].incrementCount();
                return;
            }
        }

        // You didn't find the word. Add a new word counter to the array.
        counters[n] = new SingleWordCounter(word);
        // Don't forget to increment the word's count to get it to 1!
        counters[n].incrementCount();
    }

	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        // TODO: pattern this after the count() function.
        // Make sure to return 0 for words you haven't seen before.
        int n = getNumWords();
        for (int i = 0; i < n; i++){
            if (counters[i] != null && counters[i].wordMatches(word)){
                return counters[i].getCount();
            }
        }
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

        // part two: fill the array of strings using a loop
        for (int i = 0; i < words.length; i++){
            words[i] = counters[i].getWord();
        }
        return words;
	}
}
