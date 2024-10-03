package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.Pet;
import io.restassured.response.Response;




public class PetTests
{
    Pet pet;
    Faker fake;
    
    public Logger logger;
    
    @BeforeClass
    public Pet setup()
   
    {
    	pet = new Pet();
    	fake = new Faker();
        HashMap<String,String> categoryMap = new HashMap<String, String>();
        categoryMap.put("id","1");
        categoryMap.put("name","Dogs");

        ArrayList<String> photoUrlList = new ArrayList<String>();
        photoUrlList.add("dummyPhotoURL");

        HashMap<String,String> tag = new HashMap<String, String>();
        tag.put("id","0");
        tag.put("name","dummyTagNAme");

        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
        tags.add(tag);

        pet.setId(9);
        pet.setName("name");
        pet.setCategory(categoryMap);
        pet.setPhotoUrls(photoUrlList);
        pet.setTags(tags);
        pet.setStatus("available");

        return pet;
    }
	@Test(priority=1)

	public void testPostPet()
	{
		
		
		Response response= PetEndPoints.createPet(pet);
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test(priority=2)
	
	public void testGetPetById()
	{
	
		Response response= PetEndPoints.readPet(this.pet.getId());
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		
	}
	
}
