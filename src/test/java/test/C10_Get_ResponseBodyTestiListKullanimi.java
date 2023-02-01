package test;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

    /*
            http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
            donen Response'in
            status code'unun 200,
            ve content type'inin aplication/json,
            ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin
            test edin.
     */


    @Test
    public void get01(){

        // 1- URl hazirla

        String url= " http://dummy.restapiexample.com/api/v1/employees" ;

        // 2- Expected data

        // 3- REsponse kaydet

        Response response= given().when().get(url);

      //  response.prettyPrint();

        // status, data ve message bu objenin elementleri, data bir json arrayi ve her bir elementi de id, name,salary, age ve image elementlerini iceren bir json objesi

        // ic ice ararylar oldugunda yolu kontrol etmek icin  jsonpath.com

        // data icinde kac id var bulmak icin jsonpath 'te   data[.id    yaziyoruz ] kullanmadan
        // data[.employee_name tum isimleri getirir


        // 4- Assertion

        response.
                then().
                assertThat().
                statusCode(200).contentType("application/json").
                body("data.id", hasSize(24),
                     "data.employee_name",hasItem("Ashton Cox"),
                      "data.employee_age",hasItems(61,30,40));












    }







}
