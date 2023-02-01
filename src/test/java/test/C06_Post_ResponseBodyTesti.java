package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C06_Post_ResponseBodyTesti {

    /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */

    @Test
    public void post01(){

        // 1- URL ve request body  hazirla
        String url= "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody= new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

       // System.out.println(reqBody);
       // {"title":"API","body":"API ogrenmek ne guzel","userId":10}

        // 2- Expected data hazirla ---

        // 3_Response kaydet
             // post method >> body var>> data tipini belirtmek zorundayiz= pre condition >> given dan hemen sonra,baska pre contion yok >> when e gec
            // body varsa >> when.body ile reqbody yolla ama toStrig ile

        Response response= given().
                                   contentType(ContentType.JSON).
                            when().
                                   body(reqBody.toString()).
                                   post(url);
      //   response.prettyPrint();

        /*{
    "title": "API",
    "body": "API ogrenmek ne guzel",
    "userId": 10,
    "id": 101
}
 yazdirma komutu test tamamlaninca silinmeli */


        // gonderdigimiz body nin aynisi donmedi , id eklenmis olarak geldi

     // 4- Assertion
          // donen response objesi uzeriden then ile assertion baslar

      response.
              then().
              assertThat().
              statusCode(201).
              contentType("application/json").
              body("title", equalTo("API")).
              body("userId", lessThan(100)).
              body("body",Matchers.containsString("API"));





    }



    @Test
    public void post02(){

        // 1- URL ve request body  hazirla
        String url= "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody= new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        // System.out.println(reqBody);
        // {"title":"API","body":"API ogrenmek ne guzel","userId":10}

        // 2- Expected data hazirla ---

        // 3_Response kaydet
        // post method >> body var>> data tipini belirtmek zorundayiz= pre condition >> given dan hemen sonra,baska pre contion yok >> when e gec
        // body varsa >> when.body ile reqbody yolla ama toStrig ile

        Response response= given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(url);
        //   response.prettyPrint();

        /*{
    "title": "API",
    "body": "API ogrenmek ne guzel",
    "userId": 10,
    "id": 101
}
 yazdirma komutu test tamamlaninca silinmeli */


        // gonderdigimiz body nin aynisi donmedi , id eklenmis olarak geldi

        // 4- Assertion
        // donen response objesi uzeriden then ile assertion baslar

        response.
                then().
                assertThat().
                statusCode(201).
                contentType("application/json").
                body("title",equalTo("API"),
                "userId",lessThan(100),
                "body",containsString("API"));





    }

}
