package pojos;

public class POJOJsonPlaceHolder {

/*
{
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
 */

    // 1- Objemizin icerisinde var olan tum key degerlerini private variabe olarak tanimlayalim

    private String title;

    private String body;

    private int id ;

    private int userId ;

    // 2- getter ve setter hazirla

    // sag tik >> generate >> getter setter hazirla >> hepsini sec
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    // 3- tum parametreleri iceren conscructor create et

    // sag tik >> generate >> constructor

    public POJOJsonPlaceHolder(String title, String body, int id, int userId) {
        this.title = title;
        this.body = body;
        this.id = id;
        this.userId = userId;
    }

    // 4-parametresiz concs olustur (default cons devre disi kaldigi icin) sag tik generate...

    public POJOJsonPlaceHolder() {
    }

    // 5-adim : toString() method'u create et


    @Override
    public String toString() {
        return "PJOJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                '}';
    }
}

