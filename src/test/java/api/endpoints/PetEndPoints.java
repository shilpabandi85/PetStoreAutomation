package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform CRUD operations to User API servers

public class PetEndPoints {

	public static Response createPet(Pet pet)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(pet)
			.when()
			     .post(Routes.post_url_pet);
		
		return response ;	 
	}
	
	public static Response readPet(int petId)
	{
		Response response = given()
				.pathParam("petId",petId)
			.when()
			     .get(Routes.get_url_pet);
		
		return response ;	 
	}


	
	
}
