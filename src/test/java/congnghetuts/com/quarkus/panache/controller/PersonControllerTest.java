package congnghetuts.com.quarkus.panache.controller;

import congnghetuts.com.quarkus.model.PersonVO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;

import java.io.StringReader;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class PersonControllerTest {

    @Test
    public void testCreate() {
        PersonVO personVO = new PersonVO();
        personVO.setName("name");
        personVO.setEmail("name@gmail.com");
        given()
                .header("Content-Type","application/json")
                .body(personVO)
                .when().post("/person")
                .then().statusCode(200)
                .body("code", Matchers.is(200))
                .body("message", Matchers.is("The person has been created successfully."))
                .body("data.name", Matchers.is("name"))
                .body("data.email", Matchers.is("name@gmail.com"));
    }


    @Test
    public void testCreate2() {
        PersonVO personVO = new PersonVO();
        personVO.setName("name1");
        personVO.setEmail("name1@gmail.com");
           Response response =  given()
                    .header("Content-Type","application/json")
                    .body(personVO)
                    .when().post("/person");

           response.then().statusCode(200);

           JsonObject jsonObject =  Json.createReader(new StringReader(response.asString())).readObject();
           Assertions.assertEquals(200, jsonObject.getInt("code"));
           Assertions.assertEquals("The person has been created successfully.", jsonObject.getString("message"));

           JsonObject jsonObject1 = jsonObject.getJsonObject("data");
           Assertions.assertEquals("name1", jsonObject1.getString("name"));
           Assertions.assertEquals("name1@gmail.com", jsonObject1.getString("email"));

    }

    @Test
    public void testGetAll() {
        given()
                .when().get("/person")
                .then().statusCode(200);
    }
}
