import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public abstract class BaseTest {

    private static final String BASE_URI = "http://localhost:8080/";

    @BeforeAll
    public void testSetup() {
        baseURI = BASE_URI;
        basePath = "bear";
    }
}
