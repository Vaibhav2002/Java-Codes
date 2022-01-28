package leetcode;

import java.util.HashMap;

public class rom2number {
    public int romanToInt(String s) {
        int num=0;
        HashMap<Character,Integer> ob=new HashMap<>();
        ob.put('I',1);
        ob.put('V',5);
        ob.put('X',10);
        ob.put('L',50);
        ob.put('C',100);
        ob.put('D',500);
        ob.put('M',1000);
        for (int i = 0; i <s.length(); i++) {
            if(i!=s.length()-1&&s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X'))
                num += -1;
            else if(i!=s.length()-1&&s.charAt(i)=='X'&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C'))
                num += -10;
            else if(i!=s.length()-1&&s.charAt(i)=='C'&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M'))
                num += -100;
            else num+=ob.get(s.charAt(i));
        }
        return num;
    }

    public static void main(String[] args) {
        rom2number ob=new rom2number();
        System.out.println(ob.romanToInt("IX"));
    }
}
