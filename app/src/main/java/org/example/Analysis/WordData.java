package org.example.Analysis;

//simple class to hold words and the number of occurences
public class WordData {
	public final String word;
	public final int count;

	public WordData (String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public String toString() {
		return String.format("'%s': %d", word, count); 
	}
}

