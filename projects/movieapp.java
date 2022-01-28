package projects;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;
//
//public class movieapp {
//    public static void main(String[] args) throws MalformedURLException {
//        Scanner sc = new Scanner(System.in);
//        String data = "";
//        System.out.println("Enter movie name");
//        String s = sc.nextLine();
//        StringTokenizer st = new StringTokenizer(s);
//        String movie = "";
//        while (st.hasMoreTokens())
//            movie += st.nextToken() + "+";
//        movie = movie.substring(0, movie.length() - 1);
//        System.out.println(movie);
//        URL url = new URL("http://www.omdbapi.com/?t=" + movie + "&apikey=2ce258ad");
//        try {
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            InputStream inputStream = httpURLConnection.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//            String line = "";
//            while (line != null) {
//                line = br.readLine();
//                data += line;
//            }
//            JSONObject js = new JSONObject(data);
//            BufferedImage im = ImageIO.read(new URL((String) js.get("Poster")));
//            File outputfile = new File("C:\\Users\\91810\\Desktop\\image.jpg");
//            ImageIO.write(im, "jpg", outputfile);
//            System.out.println(data);
//            System.out.println(js.getString("Title"));
//            System.out.println(js.get("Year"));
//            System.out.println(js.get("Rated"));
//
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
