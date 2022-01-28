//package projects;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//
//import javax.net.ssl.HttpsURLConnection;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//
//public class news {
//    public static void main(String[] args) {
//        String ans="";
//        try {
//            URL url=new URL( "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
//            HttpsURLConnection httpsURLConnection= (HttpsURLConnection) url.openConnection();
//            InputStream inputStream=httpsURLConnection.getInputStream();
//            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
//            BufferedReader br=new BufferedReader(inputStreamReader);
//            int data=br.read();
//            while(data!=-1)
//            {
//                ans+=(char)data;
//                data=br.read();
//            }
//            JSONArray jsonArray=new JSONArray(ans);
//            for(int i=0;i< jsonArray.length();i++)
//                System.out.println(jsonArray.getInt(i));
//
//
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//        }
//    }
//}
