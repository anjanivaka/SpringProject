package com.cg.PetShop.groomingvaccinationtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.petshop.bean.GroomingServices;
import com.cg.petshop.bean.Vaccinations;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GroomingTesting {
		@Autowired
		private TestRestTemplate template;
		
	   	
	   private static String specificServiceId = "http://localhost:7777/api/v1/services/1";

	   String output1 = """
		{
        "serviceId": 1,
        "name": "Cat Brushing",
        "description": "Gentle brushing for your furry feline friend",
        "price": 1281.89
        }	
        """;
	   
		
		
		private static String allServices = "http://localhost:7777/api/v1/services";
		@Test
	    public void testGetAllServices() throws JSONException{
	        ResponseEntity<String> response = template.getForEntity(allServices, String.class);
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<GroomingServices> output;
	        try {
	            output = objectMapper.readValue(response.getBody(), new TypeReference<List<GroomingServices>>() {});
	        } catch (JsonProcessingException e) {
	            fail("Failed to parse JSON response: " + e.getMessage());
	            return;
	        }
	        assertEquals(54, output.size());
		}
		
		@Test
		public void testspecificServiceId() throws JSONException {
			ResponseEntity<String> response = template.getForEntity(specificServiceId , String.class);
		    System.out.println(response.getBody());
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
			assertTrue(response.getStatusCode().is2xxSuccessful());
			JSONAssert.assertEquals(output1, response.getBody(), false);
	    }
		   
		@Test
		public void testNameLength() throws JSONException {
		    ResponseEntity<String> response = template.getForEntity(specificServiceId, String.class);
		    String responseBody = response.getBody();
		    int expectedNameLength = 100; 
		    int actualNameLength = responseBody.split("\"name\"")[1].split(":")[1].split("\"")[1].length();
		    assertTrue( actualNameLength <= expectedNameLength);
	   }
		
	   
	   
	   @Test
	   public void testPriceDataType1() throws JSONException {
	       ResponseEntity<String> response = template.getForEntity(specificServiceId, String.class);
	       String responseBody = response.getBody();

	       if (responseBody.contains("\"price\"")) {
	           String actualPriceString = responseBody.split("\"price\"")[1].split(":")[1].trim();
	           String actualPriceValue = actualPriceString.replaceAll("[^\\d.]", ""); 
	           
	           try {
	               double actualPrice = Double.parseDouble(actualPriceValue);
	               assertTrue(true, "Price is of type double");
	           } catch (NumberFormatException e) {
	               fail("Price is not of type double");
	           }
	       } 
	       else {
	           fail("Price field not found in response body");
	       }
	   }
	   
		private static String allServicesAvailable = "http://localhost:7777/api/v1/services/available";
		@Test
	    public void testGetAllServicesAvailable() throws JSONException{
	        ResponseEntity<String> response = template.getForEntity(allServicesAvailable, String.class);
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<GroomingServices> output;
	        try {
	            output = objectMapper.readValue(response.getBody(), new TypeReference<List<GroomingServices>>() {});
	        } catch (JsonProcessingException e) {
	            fail("Failed to parse JSON response: " + e.getMessage());
	            return;
	        }
	        assertEquals(48, output.size());
		}
		
		private static String allServicesUnavailable = "http://localhost:7777/api/v1/services/unavailable";
		@Test
	    public void testGetAllServicesUnavailable() throws JSONException{
	        ResponseEntity<String> response = template.getForEntity(allServicesUnavailable, String.class);
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<GroomingServices> output;
	        try {
	            output = objectMapper.readValue(response.getBody(), new TypeReference<List<GroomingServices>>() {});
	        } catch (JsonProcessingException e) {
	            fail("Failed to parse JSON response: " + e.getMessage());
	            return;
	        }
	        assertEquals(6, output.size());
		}

	 
	}
	

	 
	

