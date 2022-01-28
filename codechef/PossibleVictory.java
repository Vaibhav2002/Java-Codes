package codechef;

import java.util.Scanner;

public class PossibleVictory {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt(),o=sc.nextInt(),c=sc.nextInt();
        int overs_left=20-o;
        int score_left=r-c;
        int possible_score=overs_left*36;
        System.out.println(possible_score>score_left?"Yes":"No");
    }
}
