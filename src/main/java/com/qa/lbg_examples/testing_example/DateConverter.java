package com.qa.lbg_examples.testing_example;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateConverter {

	/**
	 * Returns a long string for a given date, abides by the given format which is accepted in the forms:<br><br>
	 * - dd-mm-yyyy<br>
	 * - mm-dd-yyyy<br><br>
	 * Given the date '01-11-2022' and the format 'dd-mm-yyyy', returns 
	 * 'TUESDAY 1 NOVEMBER 2022'<br><br>
	 * 
	 * Throws an IllegalArgumentException if the date or format is not correct.
	 * @param date
	 * @param format
	 * @return the converted date in the given format
	 */
	public String toLongDate(String date, String format) {
		String[] splitDate = date.split("-");
		if (splitDate.length != 3) throw new IllegalArgumentException("Date not in expected format, must follow '%%-%%-yyyy' format.");
		String dateFormatType = identifyDateFormatType(format);
		
		try {
			if (dateFormatType.toUpperCase().equals("ENGLISH")) {
				LocalDate localDate = LocalDate.of(Integer.valueOf(splitDate[2]), Integer.valueOf(splitDate[1]), Integer.valueOf(splitDate[0]));
				return localDate.getDayOfWeek().toString() + " " + localDate.getDayOfMonth() + " "  + localDate.getMonth().toString() + " " + localDate.getYear();
			} else if (dateFormatType.toUpperCase().equals("AMERICAN")) {
				LocalDate localDate = LocalDate.of(Integer.valueOf(splitDate[2]), Integer.valueOf(splitDate[0]), Integer.valueOf(splitDate[1]));
				return localDate.getMonth().toString() + " " + localDate.getDayOfMonth() + ", " + localDate.getYear();
			} else {
				throw new IllegalArgumentException("Invalid date format type supplied, must be in 'ENGLISH (dd-mm-yyyy)' or 'AMERICAN (mm-dd-yyyy)' format");
			}
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("Supplied date is not correctly made up of numerical values.");
		} catch (DateTimeException dte) {
			throw new IllegalArgumentException(dte.getMessage());
		}
	}
	
	/**
	 * Identifies whether a given date format string is English or American, throws an 
	 * IllegalArgumentException if not in a 3-part form (%%-%%-yyyy). Accepted formats are 
	 * as follows:<br><br>
	 * 
	 * - dd-mm-yyyy<br>
	 * - mm-dd-yyyy<br><br>
	 * 
	 * Formats are case insensitive, so 'DD-MM-YYYY' would also be valid.
	 * 
	 * @param dateFormat
	 * @return the type of date format: "ENGLISH", "AMERICAN" or "UNKNOWN"
	 */
	public String identifyDateFormatType(String dateFormat) {
		String[] format = dateFormat.split("-");
		if (format.length != 3) throw new IllegalArgumentException("Format not given in expected form, must follow '%%-%%-yyyy' format.");
		
		if (format[0].toUpperCase().equals("DD")) {
			if (format[1].toUpperCase().equals("MM") && format[2].toUpperCase().equals("YYYY")) {
				return "ENGLISH";
			}
		} else if (format[0].toUpperCase().equals("MM")) {
			if (format[1].toUpperCase().equals("DD") && format[2].toUpperCase().equals("YYYY")) {
				return "AMERICAN";
			}
		}
		return "UNKNOWN";
	}
}
