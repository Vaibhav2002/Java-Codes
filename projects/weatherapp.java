//package projects;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import javax.imageio.ImageIO;
//import javax.net.ssl.HttpsURLConnection;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Scanner;
//
//public class weatherapp {
//    public static void main(String[] args) {
//        String data = "";
//        final String apikey="a1db9d373196a95908c1f8fde94829ea";
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter city name");
//        String city=sc.nextLine().trim();
//        city = city.replace(' ','+');
//        URL url = null;
//        try {
//            url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apikey);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            assert url != null;
//            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
//            InputStream inputStream = httpsURLConnection.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String line = "";
//            while (line != null) {
//                line = bufferedReader.readLine();
//                data += line;
//            }
//            JSONObject jsonObject = new JSONObject(data);
//            JSONObject js = new JSONObject(jsonObject.getJSONObject("main").toString());
//            JSONObject js1 = new JSONObject(jsonObject.getJSONArray("weather").get(0).toString());
//            System.out.println(js1.toString());
//            String iconcode=js1.getString("icon");
//            System.out.println("name : " + jsonObject.get("name"));
//            System.out.println("Description : " + js1.get("description"));
//            System.out.println("temp : " + (js.getInt("temp") - 273) + "°C");
//            System.out.println("temp max: " + (js.getInt("temp_max") - 273) + "°C");
//            System.out.println("temp min: " + (js.getInt("temp_min") - 273) + "°C");
//            System.out.println("pressure max: " + js.get("pressure"));
//            System.out.println("humidity: " + js.get("humidity"));
//            URL url1=new URL("http://openweathermap.org/img/w/" + iconcode + ".png");
//            BufferedImage bufferedImage= ImageIO.read(url1);
//            File outputfile = new File("C:\\Users\\91810\\Desktop\\image.jpg");
//            ImageIO.write(bufferedImage, "png", outputfile);
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//        }
//    }
//}
