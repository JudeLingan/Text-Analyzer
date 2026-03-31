package org.example;

import java.io.FileNotFoundException;

import org.example.Analysis.Analysis;

public class App {
    public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Must enter a file to read");
			System.exit(1);
		}

		long startTime = System.currentTimeMillis();
		try {
			Analysis analysis = new Analysis(args[0]);
			System.out.println(String.format("Word Count: %d\n", analysis.wordCount));

			System.out.println("Most commmon words: ");
			for (int i = 0; i < analysis.topWords.length; ++i) {
				System.out.println(analysis.topWords[i]);
			}
			System.out.println();

			System.out.println(String.format("Longest word: %s\n", analysis.longest));
			System.out.println(String.format("Average word length: %.2f\n", analysis.averageLength));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found " + e.getMessage());
		}
		long endTime = System.currentTimeMillis();
		double timeSeconds = (double) (endTime - startTime) / 1000;
		System.out.println(String.format("Execution time: %.3fs", timeSeconds));
    }
}
