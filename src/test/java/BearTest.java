import com.google.gson.reflect.TypeToken;
import enums.Bears;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Bear;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class BearTest extends BaseTest{

    @ParameterizedTest
    @EnumSource(Bears.class)
    @DisplayName("Create a bear test")
    public void createBearTest(Bears bear) {
        Response response =  given()
                .contentType(ContentType.JSON)
                .body(new Bear(bear.getBearType(), bear.getBearName(), bear.getBearAge()))
                .when()
                .post();

        assertThat("Response status code is not 200", response.getStatusCode(), equalTo(200));
    }

    @Test
    @DisplayName("Get list of all bears")
    public void getListOfAllBearsTest() {
        List<Bear> observedBears = getListOfBears();
        assertThat("Bears count higher than 4", observedBears.size(), equalTo(4));
    }

    @Test
    @DisplayName("Change bear name")
    public void changeBearNameTest() {
        String bearNameNew = "GRISHA";
        Bear bear = new Bear();
        bear.setBearName(bearNameNew);
        List<Bear> listOfBears = getListOfBears();
        String testBearId = String.valueOf(listOfBears.get(0).getBearId());

        given()
                .body(bear)
                .put(testBearId)
                .then()
                .statusCode(200);

        String observed =
                given()
                .get(testBearId)
                .getBody().asString();

        String observedBearName = getBearFromJson(observed).getBearName();

        assertThat("Bear name doesn't changed", observedBearName.toUpperCase(), equalTo(bearNameNew.toUpperCase()));
    }

    private List<Bear> getListOfBears() {
        return mapper.fromJson(
                given()
                .get()
                .getBody()
                .asString(), new TypeToken<List<Bear>>(){}.getType());
    }

    private Bear getBearFromJson(String bearJsonString) {
        return mapper.fromJson(bearJsonString, Bear.class);
    }
}
