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
import org.springframework.http.ResponseEntity;

import com.cg.petshop.bean.Vaccinations;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VaccinationTesting {
	@Autowired
	private TestRestTemplate template;
	
	private static String specificVaccinationId="http://localhost:7777/api/v1/vaccinations/8";
	
	String output1 = """
    {
    "vaccinationId": 8,
    "name": "Rat Infectious Disease Vaccine",
    "description": "Vaccine for common infectious diseases in rats",
    "price": 7283.82
    }
	""";
	
    @Test
	public void testspecificVaccinationId() throws JSONException, org.json.JSONException {
    	ResponseEntity<String> response=template.getForEntity(specificVaccinationId, String.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(output1,response.getBody(),true);

		}
	 private static String allVaccinations = "http://localhost:7777/api/v1/vaccinations";
	 @Test
	 public void testGetAllVaccinations() {
	    ResponseEntity<String> response = template.getForEntity(allVaccinations, String.class);
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
	    ObjectMapper objectMapper = new ObjectMapper();
	    List<Vaccinations> output;
	    try {
	    	output = objectMapper.readValue(response.getBody(), new TypeReference<List<Vaccinations>>() {});
	    } catch (JsonProcessingException e) {
	    	fail("Failed to parse JSON response: " + e.getMessage());
	        return;
	    }
	    assertEquals(52, output.size());
		}
}
