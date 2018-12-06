package com.ksquareinc.testing.sonartest.component;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserComponentTest {

	
		@Test
		public void testWeShoulwGet200() {
			RestAssured.given().baseUri("http://localhost:8080/api").when().get("/users/").then().assertThat().statusCode(200).and().body("size()", equalTo(2));
		}
		
	}


