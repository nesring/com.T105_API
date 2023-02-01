package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {

    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){

        // 1- url hazirla

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- expected data hazirla
        // expected body json obje olarak tanimlanacak

        JSONObject expBody= new JSONObject();

        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum" +
                    " mollitia molestiae aut atque rem suscipit\nnam impedit esse");

      //  System.out.println(expBody);
// {"id":22,"title":"dolor sint quo a velit explicabo quia nam","body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\\nexpedita ear um mollitia molestiae aut atque rem suscipit\\nnam impedit esse","userId":3}
        // 3- Response kaydet

        Response response= given().when().get(url);

       // response.prettyPrint();
        // {
        //    "userId": 3,
        //    "id": 22,
        //    "title": "dolor sint quo a velit explicabo quia nam",
        //    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        //}

        // 4- Assertion

        // Oncelikle response body i jsonpath objesine  cevirmemiz gerek
        // json objesi iken, icerdigi verilere tek tek ulasip kontrol edemedigimiz icin

        JsonPath resJsonPath = response.jsonPath();

        Assert.assertEquals(expBody.get("userId"), resJsonPath.getInt("userId"));

        // response.asserThat() ile de assertion yapiyorduk ama orada manuel olarak beklenen degeri yazip gerceklesen ile karsilastiriyordik
        // ancak burada her ikisinin de gercek degerini bilmiyoruz, exp ve actual formullerle ifade ediyoruz


        Assert.assertEquals(expBody.get("userId"), resJsonPath.getInt("userId"));
        Assert.assertEquals(expBody.get("id"), resJsonPath.getInt("id"));
        Assert.assertEquals(expBody.get("title"), resJsonPath.getString("title"));
        Assert.assertEquals(expBody.get("body"), resJsonPath.getString("body"));

        // JUnit assertion lari kullanabilmek icin jsonpath objesine donusturmeliyiz
        // jsonpath old. then().assertThat() calismiyor, istedigimiz verilerin karsilastirmasi icin jsonpath gerekli













    }
}
