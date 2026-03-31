package org.example.Analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

//class that generates the needed data based on a file
public class Analysis {

	public final int wordCount;
	public final float averageLength;
	public final String longest;
	public final WordData[] topWords;

	public Analysis(String path) throws FileNotFoundException {
		//initialize local variables
		File file = new File(path);
		var data = fileToHashMap(file);

		//mutable variables to write to immutable class members at end
		int wordCount = 0;
		int totalLength = 0;
		String longest = "";

		//set wordCount, topWords, averageLength
		for (String word : data.keySet()) {
			//set word to longest if it is longest
			if (word.length() > longest.length()) {
				longest = word;
			}

			WordData wordData = new WordData(word, data.get(word));

			wordCount += wordData.count;
			totalLength += word.length();
		}

		//write mutable variables to immutable class members
		this.wordCount = wordCount;
		this.averageLength = (float) totalLength/wordCount;
		this.longest = longest;
		this.topWords = getTopWords(data);
	}

	private WordData[] getTopWords(HashMap<String, Integer> wordMap) {
		var tempList = new ArrayList<WordData>();
		int maxElements = 3;
		for (String word : wordMap.keySet()) {
			WordData wordData = new WordData(word, wordMap.get(word));

			int i;
			for (i = 0; i < tempList.size(); ++i) {
				if (wordData.count > tempList.get(i).count) {
					//add element if it has a higher count
					tempList.add(i, wordData);

					//delete out-of-bounds element
					if (tempList.size() > maxElements) {
						tempList.remove(maxElements);
					}

					break;
				}
			}

			//if possible, add to end
			if (tempList.size() < maxElements) {
				tempList.add(wordData);
			}
		}

		WordData[] output = new WordData[tempList.size()];
		output = tempList.toArray(output);
		return output;
	}


	private HashMap<String, Integer> fileToHashMap(File file) throws FileNotFoundException {
		//initialize local variables
		Scanner scnr = new Scanner(file);
		var wordMap = new HashMap<String, Integer>();

		//generate hashmap of occurence numbers
		while (scnr.hasNext()) {
			String word = scnr.next();
			//insert current word into wordMap
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			}
			else {
				wordMap.put(word, 1);
			}
		}

		//clean up and return output
		scnr.close();
		return wordMap;
	}
}
