package RestAssured;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReqresAPITests {

    private final String BASE_URL = "https://reqres.in/api";
    private static String userId;

    @Test
    @Order(1)
    public void createUser() {
        String jsonPayload = "{ \"name\": \"John\", \"job\": \"Developer\" }";
        userId = given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(jsonPayload)
                .post(BASE_URL + "/users")
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .extract().jsonPath().getString("id");
    }

    @Test
    @Order(2)
    public void updateUser() {
        if (userId == null) {
            throw new IllegalStateException("User ID not available. Run createUser test first.");
        }

        String updatedPayload = "{ \"name\": \"John Updated\", \"job\": \"Senior Developer\" }";
        given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(updatedPayload)
                .put(BASE_URL + "/users/" + userId)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("John Updated"))
                .body("job", equalTo("Senior Developer"));
    }

    @Test
    @Order(3)
    public void retrieveUser() {
        if (userId == null) {
            throw new IllegalStateException("User ID not available. Run createUser test first.");
        }

        System.out.println("Retrieving user with ID: " + userId);
        System.out.println("Requesting URL: " + BASE_URL);

        Response response = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(BASE_URL + "/users/" + userId);

        response.then().log().all();

        response.then()
                .assertThat()
                .statusCode(200)
                .body("data.id", equalTo(Integer.parseInt(userId)))
                .body("data.name", equalTo("John Updated"))
                .body("data.job", equalTo("Senior Developer"));
    }
}