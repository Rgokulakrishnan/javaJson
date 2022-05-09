package com.jsonapi.example;

public class JsonApiTest {
	public static void main(String[] args) {
	
		JsonApiStream jsonApiStream = new JsonApiStream();
		jacksonApiStrean jackson=new jacksonApiStrean();
		String jsonFilePath = "C:\\Users\\gokul\\Documents\\json\\StudentJson01.json";
		System.out.println(
				"KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
		
		long start = System.currentTimeMillis();
		//jsonApiStream.parse(jsonFilePath);
jackson.parseJSON(jsonFilePath);
		
		System.out.println(
				"KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
		System.out.println("Total Time Taken : " + (System.currentTimeMillis() - start) + " milli secs");
	}

}
