package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform CRUD operations to User API servers

public class UserEndPoints {

	public static Response createUser(User Payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)
			.when()
			     .post(Routes.post_url);
		
		return response ;	 
	}
	
	public static Response readUser(String userName)
	{
		Response response = given()
				.pathParam("username",userName)
			.when()
			     .get(Routes.get_url);
		
		return response ;	 
	}
	
	public static Response updateUser(String userName,User Payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(Payload)
			.when()
			     .put(Routes.put_url);
		
		return response ;	 
	}
	
	public static Response deleteUser(String userName)
	{
		Response response = given()
				.pathParam("username",userName)
			.when()
			     .delete(Routes.delete_url);
		
		return response ;	 
	}
}
