package nitinM.com.APITest.features.runnerclasses;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import nitinM.com.APITest.features.utils.StepUtil;
import nitinM.com.APITest.features.ui.steps.RestAPI;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "$DATADIR/API.csv")
@WithTags({ @WithTag("Regression")})

public class ApiValidation {

		@Steps(shared = true)
		StepUtil mStepUtil;

		@Steps(shared = true)
		RestAPI restAPI;
		
		private String executionFlag;
		private String runnerClass;
		private String pbi;
		private String testCase;
		private String testObjective;
		
		private String latitude;
		private String longitude;
		private String postalCode;

		@Qualifier
		public String qualifier() {
			return " " + pbi + " Test Case - " + testCase ;
		}
		
	
		@Test
		public void apiValidation() throws Exception {
						
			Assume.assumeTrue(executionFlag.equalsIgnoreCase("y"));
			Assume.assumeTrue(runnerClass.equalsIgnoreCase("ApiValidation"));
			if (executionFlag.equalsIgnoreCase("y") && runnerClass.equalsIgnoreCase("ApiValidation") ) {
				if (testObjective.equalsIgnoreCase("getCurrentWeatherDataBasedonLatLog"))
					restAPI.getCurrentWeatherData(latitude,longitude);
				else if (testObjective.equalsIgnoreCase("getCurrentWeatherDataBasedOnPostalCode"))
					restAPI.getCurrentWeatherDataPostalCode(postalCode);
			}
		}		
		
}
