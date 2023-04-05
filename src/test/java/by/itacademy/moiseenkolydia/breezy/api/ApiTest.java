package by.itacademy.moiseenkolydia.breezy.api;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiTest {
    JSONObject user = new JSONObject();

    @Test
    public void testGetRequest() {

        when().get(TestData.BASE_URL)
                .then().assertThat()
                .statusCode(200);
    }

    @Test
    public void testLoginWithValidCredentials() {

        user.put("email", TestData.VALID_EMAIL);
        user.put("password", TestData.VALID_PASSWORD);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user.toJSONString())
        .when()
                .post(TestData.LOGIN_URL)
        .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testLoginWithInvalidEmail() {

        user.put("email", TestData.RANDOM_EMAIL);
        user.put("password", TestData.RANDOM_PASSWORD);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user.toJSONString())
                .when()
                .post(TestData.LOGIN_URL)
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testLoginWithoutEmail() {

        user.put("password", TestData.RANDOM_PASSWORD);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user.toJSONString())
                .when()
                .post(TestData.LOGIN_URL)
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testLoginWithInvalidPassword() {

        user.put("email", TestData.VALID_EMAIL);
        user.put("password", TestData.RANDOM_PASSWORD);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user.toJSONString())
                .when()
                .post(TestData.LOGIN_URL)
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testLoginWithoutPassword() {

        user.put("email", TestData.VALID_EMAIL);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user.toJSONString())
                .when()
                .post(TestData.LOGIN_URL)
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testLoginWithoutEmailAndPassword() {

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user.toJSONString())
                .when()
                .post(TestData.LOGIN_URL)
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }
}
