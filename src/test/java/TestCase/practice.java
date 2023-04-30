package TestCase;

import java.text.SimpleDateFormat;
import java.util.Date;

import GenericUtils.Excel_utils;

public class practice {

	public static void main(String[] args) {
	
		Excel_utils excel = new Excel_utils("./src/test/resources/TestData/SriMandir.xlsx");
		
		System.out.println(excel.rashifalElement("textview"));
	}

}
