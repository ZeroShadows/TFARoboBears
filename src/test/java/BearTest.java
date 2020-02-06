import io.restassured.http.ContentType;
import model.Bear;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static io.restassured.RestAssured.given;

public class BearTest extends BaseTest{

    @Test
    @DisplayName("Create a bear test")
    @ParameterizedTest
    public void createBearTest() {
        Bear bear = new Bear();
        bear.setBearName("asasa");
        bear.setBearType("POLAR");
        bear.setBearAge(17);
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bear)
                .when()
                .post()
                .then()
                .statusCode(200);
    }
}
