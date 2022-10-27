package com.qa.lbg_examples.testing_example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DateConverterUnitTest {
	
	DateConverter dc;

	// Testing idnetifyDateFormatType
	// Valid inputs: DD-MM-YYYY, dd-mm-yyyy, MM-DD-YYYY, mm-dd-yyyy
	// Invalid inputs: dm-mm-yyyy, mm-dm-yyyy, dd-mm-yyyyy, etc...
	// ee-gg-yyyy
	
	@BeforeAll // JUnit4 equivalent is @BeforeClass
	// we must provide a static method by default
	static void setup() {
		// setup database connections, one time configurations
		// needed for all tests that will run
		System.out.println("Setting up required things");
	}
	
	@AfterAll // JUnit4 equivalent is @AfterClass
	// cleaning up, such as closing any connections to databases
	static void teardown() {
		System.out.println("Tearing down");
	}
	
	@BeforeEach // JUnit 4 equivalent is @Before
	// runs before each test
	void init() {
		System.out.println("Initialising before test");
		dc = new DateConverter();
	}
	
	@AfterEach // JUnit 4 is @After
	// runs after each test
	void cleanup() {
		System.out.println("Cleaning up after test");
		dc = null;
	}
	
	@Test
	void validShortEnglishDateTest() {
		System.out.println("Short english date test");
		// Arrange (the prerequisites for the test)
		String englishShortDateFormat = "dd-mm-yyyy";
		String expectedResult = "ENGLISH";

		// Act (performing the action to be tested)
		String actualResult = dc.identifyDateFormatType(englishShortDateFormat);

		// Assert (assert the result)
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	void validShortAmericanDateTest() {
		System.out.println("Short american date test");
		// Arrange (the prerequisites for the test)
		String americanShortDateFormat = "mm-dd-yyyy";
		String expectedResult = "AMERICAN";

		// Act (performing the action to be tested)
		String actualResult = dc.identifyDateFormatType(americanShortDateFormat);

		// Assert (assert the result)
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	void validStructureUnknownFormatTest() {
		// Arrange (the prerequisites for the test)
		String unknownShortDateFormat = "mm-dd-yyyyy";
		String expectedResult = "UNKNOWN";

		// Act (performing the action to be tested)
		String actualResult = dc.identifyDateFormatType(unknownShortDateFormat);

		// Assert (assert the result)
		Assertions.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void validStructureUnknownFormatTest2() {
		// Arrange (the prerequisites for the test)
		String unknownShortDateFormat = "mm-dg-yyyyy";
		String expectedResult = "UNKNOWN";

		// Act (performing the action to be tested)
		String actualResult = dc.identifyDateFormatType(unknownShortDateFormat);

		// Assert (assert the result)
		Assertions.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	// @Test(expected = Exception.class) is the JUnit 4 equivalent
	// - write the code that throws the exception in the test method
	void incorrectFormatTest() {
		String incorrectFormat = "mm-dd";
		String expectedMessage = "Format not given in expected form, must follow '%%-%%-yyyy' format.";
		
		Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// inside here is where we write the code that throws the exception
			dc.identifyDateFormatType(incorrectFormat);
		});
		
		String actualMessage = e.getMessage();
		Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	// ParameterizedTests allow us to reuse the logic of a test, with multiple different
	// sets of values
	@ParameterizedTest
	@CsvSource(value = {"mm-dd-yyyy,AMERICAN", "dd-mm-yyyy,ENGLISH", "dd-mm-yyyyy,UNKNOWN"})
	void parameterisedTestExample(String format, String expectedResult) {
		// Act (performing the action to be tested)
		String actualResult = dc.identifyDateFormatType(format);

		// Assert (assert the result)
		Assertions.assertEquals(expectedResult, actualResult);
	}

}
