package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */


    @Test
    public void post01(){


    // 1- URL ve request body hazirla

        String url= "https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody = new JSONObject();

        innerBody.put("checkin", "2021-06-01");
        innerBody.put("checkout", "2021-06-10");

        JSONObject reqBody= new JSONObject();

        reqBody.put("firstname" , "Ali");
        reqBody.put("lastname" , "Bak");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" ,innerBody);
        reqBody.put("additionalneeds" , "wi-fi");

       // System.out.println("request body: "+ reqBody);

    // 2- Expected body hazirla
        JSONObject expBody = new JSONObject();

        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        // System.out.println("expected body : "+expBody);

        // noral sartlarda. booking id olrak ne donecegini bilmiyoruz, 24 yazamayiz, ancak bu soruda bunu test etmeyecegiz, yanlis da donse sorun yok,
        // diger yandan expected body iceriginde booking id oldugu icin bunu put ile tanimalamak ve bir deger ataamak zorundayiz

    // 3- Response kaydet

        Response response = given().
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).post(url);

        // when().body() icine request body koyuyoruz, expected body sadece assertion icin kullanilacak
        // bu satirda, aslinda post komutu veriyoruz , post yaptigimiz da request body

      //  System.out.println("response :");
       // response.prettyPrint();

        // yazdirma sonuclarini duzenleyip inceliyoruz

        /*
        request body:
         {
        "firstname":"Ali",
        "additionalneeds":"wi-fi",
        "bookingdates":{
                    "checkin":"2021-06-01",
                     "checkout":"2021-06-10" },
        "totalprice":500,
        "depositpaid":false,
        "lastname":"Bak"}
         */

        /*
        expected body :
         {
         "booking":{
         "firstname":"Ali",
         "additionalneeds":"wi-fi",
         "bookingdates":{
                    "checkin":"2021-06-01",
                    "checkout":"2021-06-10"},
         "totalprice":500,
         "depositpaid":false,
         "lastname":"Bak"},
         "bookingid":24}
         */

        /*
        response :
{
    "bookingid": 2465,
    "booking": {
        "firstname": "Ali",
        "lastname": "Bak",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
}
         */

        // bbu sekilde yazdrima sonuclarina bakarak manuel olarak test yapmis olduk ama assertion ile test etmemiz gerek

    // 4- Assertion

        // en basta Json response i jsonpath e donusturmemiz gerek

        JsonPath resJsonPath = response.jsonPath();
        // sistemde geri donen id sorgulanmaz, bilmemiz mumkun degil

      //   Assert.assertEquals(expBody.get("booking.firstname"), resJsonPath.get("booking.firstname"));
        // yukardaki satir hata verdi cunku, java, json objelerini bir butun olarak goruyor, icine direkt erisemiyor;
        // path verilmis olsa bile (booking.firstname) yeterli degil.
        // get() icine JSONObject olarak almamiz gerek
        // basit yapilarda ic ice obje yoksa buna gerek kalmiyor

        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJsonPath.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resJsonPath.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJsonPath.get("booking.additionalneeds"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJsonPath.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJsonPath.get("booking.depositpaid"));

        // bastaki Assert silip, junit ten import edersek her seferinde yazmamiza gerek kalmadi

        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJsonPath.get("booking.bookingdates.checkin"));














    }


}
