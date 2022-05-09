package com.jsonapi.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class JsonApiStream {
	public void parse(String jsonFilePath) {
		// create JsonReader object and pass it the json file,json source or json text.
		

		try (JsonReader jsonReader = new JsonReader(
				new InputStreamReader(new FileInputStream(jsonFilePath), StandardCharsets.UTF_8))) {
			Gson gson = new GsonBuilder().create();

			jsonReader.beginArray(); // start of json array
			int numberOfRecords = 0;
			Student student = null;
			List<Student> studentList = new ArrayList<Student>();

			while (jsonReader.hasNext()) { // next json array element

				student = gson.fromJson(jsonReader, Student.class);
				studentList.add(student);
				

				numberOfRecords++;

			}
			jsonReader.endArray();
			System.out.println("Total Records Found : " + numberOfRecords);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
