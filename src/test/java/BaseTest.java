import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    private static final String BASE_URI = "http://localhost:8888/";
    Gson mapper = new Gson();

    @BeforeAll
    public static void testSetup() {
        baseURI = BASE_URI;
        basePath = "bear";
    }

    @AfterAll
    public static void testTearDown() {
        given().delete();
    }
}
