package adapters;

import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

@Log4j2
public class BaseAdapter {
//    final String BASE_URL_API = System.getenv().getOrDefault("TESTRAIL_URL_API", PropertyReader.getProperty("testrail.url.api"));
//    final String TOKEN = System.getenv().getOrDefault("TESTRAIL_API_TOKEN", PropertyReader.getProperty("testrail.api.token"));
    final String BASE_URL_API = "https://gapontsevevg.testrail.io/index.php?/api/v2/";
    final String TOKEN = "Basic Z2Fwb250c2V2X3Rlc3RyYWlsQG1haWxpbmF0b3IuY29tOndkTk1PM1NnVTZHU0o2WEtrQi8y";
    public String post(String body, String uri) {
        given().
                header("Content-Type", "application/json").
                header("Authorization", TOKEN).
                body(body).
        when().
                post(BASE_URL_API + uri).
        then().
                log().all().
                statusCode(200)
                .extract().body().asString();
        return body;
    }

    public void deleete(String uri) {
        given().
                header("Content-Type", "application/json").
                header("Authorization", TOKEN).
        when().
                post(BASE_URL_API + uri).
        then().
                log().all().
                statusCode(200);
    }

    public String got(String uri) {
       String body =
       given().
                header("Content-Type", "application/json").
                header("Authorization", TOKEN).
       when().
                get(BASE_URL_API + uri).
       then().
                log().all().
                statusCode(200)
                .extract().body().asString();
       return body;
    }
}

