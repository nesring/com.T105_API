package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {

    /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

        // bir API sorgusunda daima 4 adim takip edecegiz //

    // 1- Gonderecegimiz request icin gerekli olan URL i ve ihtiyacimiz varsa Body hazirla
    // 2- Eger soruda bize verilmisse Expected Data hazirla
    // 3- -bize donen Response'i Actual Data olarak kaydet
    // 4- Expected Data ile Actual Data karsilastirmasi = Assertion



    @Test
    public void get01(){


        // 1- Gonderecegimiz request icin gerekli olan URL i ve ihtiyacimiz varsa Body hazirla

        String url= "https://restful-booker.herokuapp.com/booking/1143";
        // method Get bu soruda body ihtiyaci yok

        // 2- Eger soruda bize verilmisse Expected Data hazirla
            // karsilastiracagimiz response verilmedigi icin bu adimi atliyoruz

        // 3- -bize donen Response'i Actual Data olarak kaydet

        Response response= given().when().get(url);

        response.prettyPrint();
        // donen bilgiyi response degiskenine atadik, gormek icin yazdirmamiz gerek
        // ancak dogrudan sout ile yazdiramiyoruz, prettyPrint methodu kullanmamiz gerek

        // soruda istenen status codu vb bilgilere yine response objesi uzerinden ulasacagiz

        System.out.println(" Status code :" +response.getStatusCode());
        System.out.println(" content Type :" +response.getContentType());
        System.out.println(" Server Header'inin Degeri :" +response.getHeader("Server"));
        System.out.println(" Status Line :" +response.getStatusLine());
        System.out.println(" Response Suresi :" +response.getTime());

        // 4- Expected Data ile Actual Data karsilastirmasi = Assertion








    }

}
