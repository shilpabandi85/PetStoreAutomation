package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.github.javafaker.Faker;

import api.endpoints.Routes;
import api.endpoints.UserEndPoints;
import api.payload.UserValidations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class CreateUserValidationID {
	Faker faker;
	UserValidations userPayload;
	
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		faker = new Faker();
		userPayload = new UserValidations();
		
		userPayload.setId("test");
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPassword(faker.phoneNumber().cellPhone());
		
		//logs
		logger= LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)

	public void testPostUser()
	{
		
		logger.info("************ User Validation********************");
		//Response response= UserEndPoints.createUser(userPayload);
		//response.then().log().all();
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userPayload)
			.when()
			     .post(Routes.post_url);
		
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
		//ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = response.getBody().asString();
		AssertJUnit.assertEquals(bodyAsString.contains("something bad happened" /*Expected value*/) ,true);
		logger.info("Message:"+bodyAsString);
		
		//AssertJUnit.assertEquals(null, null, null);
		//logger.info("************ User is Created ********************");
	}
}
