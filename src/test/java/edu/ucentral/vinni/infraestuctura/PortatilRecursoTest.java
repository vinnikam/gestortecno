package edu.ucentral.vinni.infraestuctura;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;

@QuarkusTest
public class PortatilRecursoTest {
    @Test
    public void testCrearPortatil() {
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
    public void testCrearPortatilVacios() {
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
    @Test
    public void testConsutarTodosPortatiles() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/portatiles")
                .then()
                .statusCode(200);
    }
    @Test
    public void testValidarListaPortatiles() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/portatiles")
                .then()
                .statusCode(200)
                //Validar que exitan 2 registros
                .body("$", hasSize(2))
                // valida marca Dell
                .body("marca", hasItem("Dell"))
                // Valida que la primera posicion tenga estos valores.
                .body("[0].serial", is("XYZ123"))
                .body("[0].memoria", equalTo(16));
    }
}
