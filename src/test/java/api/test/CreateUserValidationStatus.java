package api.test;

import org.testng.annotations.Test;
//import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

//import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
import org.json.JSONObject;
//import org.json.JSONString;
//import org.json.*;
//import org.jsoup.helper.HttpConnection.Request;

//import com.aventstack.extentreports.util.Assert;
import com.github.javafaker.Faker;
//import com.mongodb.util.JSON;

//import api.endpoints.Routes;
//import api.endpoints.UserEndPoints;
import api.payload.UserValidations;
import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateUserValidationStatus {
	Faker faker;
	UserValidations userPayload;
	
	
	public Logger logger;
	
	@Test
	public void setup()
	{
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2"; 
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject(); 
		requestParams.put("id", "1"); 
		requestParams.put("username", "User1"); 
		requestParams.put("firstName", "Firstname"); 
		requestParams.put("lastName", "Lastname"); 
		requestParams.put("email", "test@abc.com"); 
		requestParams.put("password", "test123"); 
		requestParams.put("phone", "9082341902"); 
		requestParams.put("userStatus", "userStatus"); 
		
		//Request request = new Request();
		

		// Add a header stating the Request body is a JSON 
		request.header("Content-Type", "application/json"); // Add the Json to the body of the request 
		request.body(requestParams.toString(1)); // Post the request and check the response
		

		
		//logs
		logger= LogManager.getLogger(this.getClass());
		
	
		
		logger.info("************ User Validation********************");
		//Response response= UserEndPoints.createUser(userPayload);
		//response.then().log().all();
		
		Response response = request.post("/user"); 
	    //ResponseBody body = response.getBody();
		
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(),500);
		logger.info("Status:"+response.getStatusCode());
		
		
		String contentType = response.header("Content-Type"); 
		AssertJUnit.assertEquals(contentType /* actual value */, "application/json" /* expected value */); 
		logger.info("Content-Type:"+contentType);
		
		// Access header with a given name. Header = Server 
		String serverType = response.header("Server"); 
		AssertJUnit.assertEquals(serverType /* actual value */, "Jetty(9.2.9.v20150224)" /* expected value */);
		logger.info("Server:"+serverType);
		// Retrieve the body of the Response
		

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = response.getBody().asString();
		AssertJUnit.assertEquals(bodyAsString.contains("something bad happened" /*Expected value*/) ,true);
		logger.info("Message:"+bodyAsString);
		
		//AssertJUnit.assertEquals(null, null, null);
		//logger.info("************ User is Created ********************");
	}
}
