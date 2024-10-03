package api.payload;

import java.util.ArrayList;
import java.util.HashMap;

public class Pet
{
	
	 int id;
     String name;
     HashMap <String,String> category;
     ArrayList<String> photoUrls;
     HashMap <String,String> tag;
     ArrayList<HashMap <String,String>> tags;
     String status;
     
    public int getId() {
		return id;
	}
	public void setId(int Id) {
		id = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getCategory() {
		return category;
	}
	public void setCategory(HashMap<String, String> category) {
		this.category = category;
	}
	public ArrayList<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(ArrayList<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public HashMap<String, String> getTag() {
		return tag;
	}
	public void setTag(HashMap<String, String> tag) {
		this.tag = tag;
	}
	public ArrayList<HashMap<String, String>> getTags() {
		return tags;
	}
	public void setTags(ArrayList<HashMap<String, String>> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
