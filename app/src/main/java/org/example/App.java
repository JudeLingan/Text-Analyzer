package org.example;

import java.io.FileNotFoundException;

import org.example.Analysis.Analysis;

public class App {
    public static void main(String[] args) {
		try {
			Analysis analysis = new Analysis(args[0]);
			System.out.println(analysis.wordCount);
			for (int i = 0; i < analysis.topWords.length; ++i) {
				System.out.println(analysis.topWords[i]);
			}
			System.out.println(analysis.longest);
			System.out.println(analysis.averageLength);
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
    }
}
