package projects;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class celeb {
    public static void main(String[] args) throws MalformedURLException {
        String f="";
        URL url=new URL("https://www.bollywoodhungama.com/celebrities/top-100/");
        try {
            HttpsURLConnection httpsURLConnection= (HttpsURLConnection) url.openConnection();
            InputStream inputStream=httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            int data=inputStreamReader.read();
            while(data!=-1)
            {
                f+=(char)data;
                data=inputStreamReader.read();
            }
            Pattern pattern = Pattern.compile("src=(.*?)class");
            Matcher matcher= pattern.matcher(f);
            String im="no maatch";
            while (matcher.find())
                System.out.println(matcher.group(1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
