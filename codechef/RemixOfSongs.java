package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemixOfSongs {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        String smallest_word=s;
        while(st.hasMoreTokens()){
            String x=st.nextToken();
            if(smallest_word.length()>x.length())
                smallest_word=x;
        }
        st=new StringTokenizer(s);
        String ans=smallest_word+" ";
        while(st.hasMoreTokens()){
            ans+=st.nextToken()+" "+smallest_word+" ";
        }
        System.out.println(ans);
    }
}
