
package nitinM.com.APITest.features.ui.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import nitinM.com.APITest.features.utils.StepUtil;

public class RestAPI {

	@Steps(shared = true)
	StepUtil mStepUtil;
	
	@Step("Get Current Weather data based on Latitue and Longitude")
	public void getCurrentWeatherData(String latitude, String longitude)
	{
		System.out.println(" START  " );
		// base URL to call
		RestAssured.baseURI = "https://api.weatherbit.io/v2.0/current";
	
		String payload = "?lat=" + latitude + "&lon=" + longitude + "&Key=75c0623d34d34bae8243ef81f3ba5508";
		System.out.println("payload : " + payload);
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		
		//#Response tokenResponse = request.get("?lat=51.5072&lon=-0.1276&Key=75c0623d34d34bae8243ef81f3ba5508");
		Response tokenResponse = request.get(payload);
		
		int statusCode= tokenResponse.getStatusCode();
		mStepUtil.displayInSerenityReport("Status Code", " " + statusCode);
	
		// Print the response in string format
		System.out.println("API Response : " + tokenResponse.getBody().asString());
		tokenResponse.prettyPrint();
		System.out.println("Token : " + tokenResponse.prettyPrint());
		mStepUtil.displayInSerenityReport("Weather API Response for Latitue : " + latitude + ", Longitude :" + longitude , tokenResponse.prettyPrint());
		
	}
	
	@Step("Get Current Weather data based on Postal Code")
	public void getCurrentWeatherDataPostalCode(String postalCode)
	{
		
		System.out.println(" START " );
		// base URL to call
		RestAssured.baseURI = "https://api.weatherbit.io/v2.0/current";
	
		String payload = "?postal_code=" + postalCode + "&Key=75c0623d34d34bae8243ef81f3ba5508";
		System.out.println("payload : " + payload);
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		
		Response tokenResponse = request.get(payload);
		int statusCode= tokenResponse.getStatusCode();
		mStepUtil.displayInSerenityReport("Status Code", " " + statusCode);
		
		// Print the response in string format
		System.out.println("API Response : " + tokenResponse.getBody().asString());
		tokenResponse.prettyPrint();
		System.out.println("Token : " + tokenResponse.prettyPrint());
		mStepUtil.displayInSerenityReport("Weather API Response based on Postal Code : " + postalCode, tokenResponse.prettyPrint());
		
	}
//close class	
}