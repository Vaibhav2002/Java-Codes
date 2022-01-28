package stringcodes;

public class WordRev {
    String reverseWords(String s) {
        String a[]=s.split("\\.");
        String ans = "";
        for (String st : a)
            ans = "." + st + ans;
        return ans.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(new WordRev().reverseWords("i.like.this.program.very.much"));
    }

}
