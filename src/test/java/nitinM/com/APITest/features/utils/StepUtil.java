package nitinM.com.APITest.features.utils;

import net.serenitybdd.core.Serenity;

public class StepUtil {

 	public void displayInSerenityReport(String title, String content) {

		Serenity.recordReportData().withTitle(title).andContents(content);
	}   
}


