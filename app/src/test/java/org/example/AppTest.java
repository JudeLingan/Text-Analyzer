package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.example.Analysis.WordData;
import org.example.Analysis.Analysis;

class AppTest {
	@Test
	void wordDataTest() {
		WordData wordData = new WordData("hello", 12);
		assertEquals(wordData.word, "hello");
		assertEquals(wordData.count, 12);
	}

	@Test
	void analysisTestOven() {
		Analysis analysis;
		try {
			String path = getClass().getClassLoader().getResource("oven.txt").getPath();
			analysis = new Analysis(path);
			assertEquals("Garfield:", analysis.longest);
			assertEquals(23, analysis.wordCount);

			for (int i = 0; i < analysis.topWords.length; ++ i) {
				System.out.println(analysis.topWords[i]);
			}
			assertEquals(analysis.topWords.length, 3);
			assertEquals(analysis.topWords[0].word, "of");
			assertEquals(analysis.topWords[0].count, 3);
			assertTrue(Math.abs(analysis.averageLength - 3.347826087) < 0.000001, "average length is not approximately correct");
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			assertTrue(false, "file oven.txt not found");
		}
	}
}
