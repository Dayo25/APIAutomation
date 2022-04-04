package apiPackage;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTestUsingRestAssured {
    //@Test
    public void GetCommentForJsonPlaceHolder(){
        given().contentType(ContentType.JSON).
                when().get("https://jsonplaceholder.typicode.com/comments/5").
                then().log().all().statusCode(200).
                body("name", equalTo("vero eaque aliquid doloribus et culpa"));
    }
    @Test
    public void PostACommentForJsonPlaceHolder(){
        HashMap<String, String> postBody = new HashMap<>();
        postBody.put("placeID", "1");
        postBody.put("name", "Dayo");
        postBody.put("email", "dayo@gmail.com");
        postBody.put("body", "My first comment");

        given().contentType(ContentType.JSON).accept(ContentType.JSON).with().body(postBody).when().
                post("https://jsonplaceholder.typicode.com/comments").
                then().log().all().
                statusCode(201).
                body("name", equalTo("Dayo")).
                body("email", equalTo("dayo@gmail.com")).
                body("body", equalTo("My first comment"));



    }
}
