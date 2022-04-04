package apiPackage;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTestUsingRestAssured {
    @Test
    public void GetCommentForJsonPlaceHolder(){
        given().contentType(ContentType.JSON).
                when().get("https://jsonplaceholder.typicode.com/comments/5").
                then().log().all().statusCode(200).body("name", equalTo("vero eaque aliquid doloribus et culpa"));
    }
}
