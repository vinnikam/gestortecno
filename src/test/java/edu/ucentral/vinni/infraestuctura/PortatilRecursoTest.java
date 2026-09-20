package edu.ucentral.vinni.infraestuctura;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PortatilRecursoTest {
    @Test
    public void testCrearEstudiante() {
        String json = """
        { 
          "serial" : "001",
          "marca" : "LG",
          "memoria": 16
        }
        """;
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/portatiles")
                .then()
                .statusCode(201);
    }
    @Test
    public void testCrearEstudianteVacios() {
        String json = """
        { 
          "serial" : "",
          "marca" : "",
          "memoria": 0
        }
        """;
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/portatiles")
                .then()
                .statusCode(400);
    }
}
