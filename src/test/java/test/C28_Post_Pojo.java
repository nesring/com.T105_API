package test;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.POJOJsonPlaceHolder;
import pojos.PojoHerokuappBooking;
import pojos.PojoHerokuappBookingDates;
import pojos.PojoHerokuappExpectedBody;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Post_Pojo extends HerokuappBaseUrl {
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
                        Response Body = Expected Data
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

    // her bir json objesi icin bir class gerekiyor, bu soruda 3 pojo class gerek
    // bunun yerine https://www.jsonschema2pojo.org/  adresinden yapiyoruz
    // sourse type:json, use double numbers iptal, icluce const ok, tostring ok, iclude getter setter ok

    // bunun da yerine pom'a lombox dependency ekledik
    // en cok katmanli olan ve ayni zamanda req body de iceren exp data ya bakiyoruz
    // en icten baslayarak pojo olusturacagizn en ic dong+u icin pojo class ac private variabla tanimla, 3 notosayonu yapistir
    // her bir inner json icin yeni pojo class

    @Test
    public void post01(){

        // 1-URL ve body hazirla

        specHerokuapp.pathParam("pp1","booking");

        PojoHerokuappBookingDates bookingDates= new PojoHerokuappBookingDates("2021-06-01","2021-06-10");

        PojoHerokuappBooking reqBody= new PojoHerokuappBooking("Ahmet","Bulut",500,false,"wi-fi",bookingDates);

        System.out.println("reqBody = " + reqBody);

        // 2-Expected data

        PojoHerokuappExpectedBody expBody= new PojoHerokuappExpectedBody(24,reqBody);

        System.out.println("expBody = " + expBody);

        // 3-Response kaydet

        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");
        
        response.prettyPrint();
        
        // 4-Assertion

        PojoHerokuappExpectedBody respPojo = response.as(PojoHerokuappExpectedBody.class);

        assertEquals(expBody.getBooking().getFirstname(),respPojo.getBooking().getFirstname());
        assertEquals(expBody.getBooking().getLastname(),respPojo.getBooking().getLastname());
        assertEquals(expBody.getBooking().getTotalprice(),respPojo.getBooking().getTotalprice());
        assertEquals(expBody.getBooking().isDepositpaid(),respPojo.getBooking().isDepositpaid());
        assertEquals(expBody.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());
        assertEquals(expBody.getBooking().getBookingdates().getCheckin(),respPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expBody.getBooking().getBookingdates().getCheckout(),respPojo.getBooking().getBookingdates().getCheckout());



    }




















}
