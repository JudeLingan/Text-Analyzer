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
		assertEquals("hello", wordData.word);
		assertEquals(12, wordData.count);
	}

	@Test
	void analysisTestOven() {
		Analysis analysis;
		try {
			String path = getClass().getClassLoader().getResource("oven.txt").getPath();
			analysis = new Analysis(path);
			assertEquals("Garfield:", analysis.longest);
			assertEquals(23, analysis.wordCount);
			assertEquals(3, analysis.topWords.length);
			assertEquals("of", analysis.topWords[0].word);
			assertEquals(3, analysis.topWords[0].count);
			assertTrue(Math.abs(analysis.averageLength - 3.347826087) < 0.000001, "average length is not approximately correct");
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			fail("file oven.txt not found");
		}
	}
}
