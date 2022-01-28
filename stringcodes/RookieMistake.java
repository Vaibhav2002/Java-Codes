package stringcodes;

import java.util.HashSet;

public class RookieMistake {
    public boolean solve(String s) {
        HashSet<Integer> b_pos=new HashSet<>();
        char ch[]=s.toCharArray();
        int index_r=Integer.MIN_VALUE;
        boolean blocked_before=false,blocked_after=false;
        for(int i=0;i<ch.length;i++){
            char c=ch[i];
            if(c=='R')
                index_r=i;
            else if(c=='B'){
                if(index_r==Integer.MIN_VALUE)
                    blocked_before=true;
                else
                    blocked_after=true;
            }
        }
        return !blocked_after||!blocked_before;
    }
}
