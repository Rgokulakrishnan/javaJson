package com.jsonapi.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;

import org.codehaus.jackson.map.JsonMappingException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class jacksonApiStrean {
	public static void parseJSON(String jsonFilePath) {
		File source=new File(jsonFilePath);
		ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    List<Student> studentList = new ArrayList<Student>();
		try(JsonParser jsonParser = mapper.getFactory().createJsonParser(source)) {
	
			 
			while (jsonParser.nextToken() != JsonToken.END_ARRAY) {

	            // Read a student instance using ObjectMapper and do something with it
	         Student student = mapper.readValue(jsonParser, Student.class);
	         studentList.add(student);
	        }
			
			


			
		} catch (JsonGenerationException jge) {
			jge.printStackTrace();
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		catch (Exception ioex) {
			ioex.printStackTrace();
		}
	}

}
