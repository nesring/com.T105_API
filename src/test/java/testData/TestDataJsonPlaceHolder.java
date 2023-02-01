package testData;

import org.json.JSONObject;

public class TestDataJsonPlaceHolder {

   public int basariliStatusCode = 200;
   public String contentType = "application/json; charset=utf-8";
   public String connectionHeaderDegeri = "keep-alive";

    public JSONObject expectedBodyOlusturJSON () {


        JSONObject expBodyJSON = new JSONObject();

        expBodyJSON.put("userId",3);
        expBodyJSON.put("id",22);
        expBodyJSON.put("title","dolor sint quo a velit explicabo quia nam");
        expBodyJSON.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum " +
                          "mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expBodyJSON;

    }

    /*
     Request Body
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    public JSONObject requestBodyOlusturJSON () {


        JSONObject reqBodyJSON = new JSONObject();

        reqBodyJSON.put("userId",10);
        reqBodyJSON.put("id",70);
        reqBodyJSON.put("title","Ali");
        reqBodyJSON.put("body","Merhaba");

        return reqBodyJSON;

    }

}
