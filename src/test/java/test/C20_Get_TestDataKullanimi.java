package test;

import baseURL.DummyBaseUrl;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataDummy;

public class C20_Get_TestDataKullanimi extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi oldugunu test edin.
    Expected Body
    {
    "status":"success",
    "data": {
            "id": 3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */

    @Test
    public void get01(){

        // 1- url hazirla

        specDummy.pathParams("pp1","employee","pp2",3);

        // 2- Expected data

        TestDataDummy testDataDummy =new TestDataDummy();

        JSONObject expData = testDataDummy.expectedBodyOlusturJson();








    }

















}
