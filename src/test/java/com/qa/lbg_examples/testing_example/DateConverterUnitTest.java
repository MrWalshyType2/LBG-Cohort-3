package com.qa.lbg_examples.testing_example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateConverterUnitTest {

	// Testing idnetifyDateFormatType
	// Valid inputs: DD-MM-YYYY, dd-mm-yyyy, MM-DD-YYYY, mm-dd-yyyy
	// Invalid inputs: dm-mm-yyyy, mm-dm-yyyy, dd-mm-yyyyy, etc...
	// ee-gg-yyyy
	
	@Test
	void validShortEnglishDateTest() {
		// Arrange (the prerequisites for the test)
		DateConverter dc = new DateConverter();
		String englishShortDateFormat = "dd-mm-yyyy";
		String expectedResult = "ENGLISH";
		
		// Act (performing the action to be tested)
		String actualResult = dc.identifyDateFormatType(englishShortDateFormat);
		
		// Assert (assert the result)
		Assertions.assertEquals(expectedResult, actualResult);
	}
}
