package codechef;

import java.util.Scanner;

public class ChefAndMeetings {
    static class Time {
        int hr, min;

        Time(String s) {
            char[] c = s.toCharArray();
            int h = Integer.parseInt(c[0] + "" + c[1]);
            int m = Integer.parseInt(c[3] + "" + c[4]);
            String ampm = c[6] + "" + c[7];
            if (ampm.equals("PM")&&h!=12)
                h += 12;
            else if(ampm.equals("AM")&&h==12)
                h=0;
            hr = h;
            min = m;
        }

        boolean compare(Time start, Time end) {
            return this.hr >= start.hr && this.hr <= end.hr && this.min >= start.min && this.min <= end.min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            Time meetingTime=new Time(sc.nextLine());
            int n=Integer.parseInt(sc.nextLine());
            for(int i=0;i<n;i++){
                String x=sc.nextLine();
                Time start=new Time(x.substring(0,8));
                Time end=new Time(x.substring(9));
                if(meetingTime.compare(start,end))
                    System.out.print("1");
                else
                    System.out.print("0");
            }
            System.out.println();
        }
    }
}
