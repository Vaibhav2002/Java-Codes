package college;

import java.util.Calendar;
import java.util.Scanner;

public class Party {
    static class Timing {
        int hrs, min;

        Timing(String s) {
            int colonIndex = s.indexOf(':');
            int spaceIndex = s.indexOf(' ');
            int hrs = Integer.parseInt(s.substring(0, colonIndex));
            int min = Integer.parseInt(s.substring(colonIndex + 1, spaceIndex));
            String format = s.substring(spaceIndex + 1);
            if (hrs != 12 && format.equals("PM")) hrs += 12;
            if (hrs == 12 && format.equals("AM")) hrs = 0;
            this.hrs = hrs;
            this.min = min;
        }

        boolean isBetween(Timing startTime, Timing endTime) {
            Calendar event = getCalFromTime(), start = startTime.getCalFromTime(), end = endTime.getCalFromTime();
            return event.getTimeInMillis() >= start.getTimeInMillis() && event.getTimeInMillis() <= end.getTimeInMillis();
        }

        private Calendar getCalFromTime() {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, hrs);
            cal.set(Calendar.MINUTE, min);
            return cal;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String x = sc.nextLine();
            Timing eventTime = new Timing(x);
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String input = sc.nextLine();
                String[] times = input.split(",");
                Timing startTime = new Timing(times[0].trim()), endTime = new Timing(times[1].trim());
                System.out.print(eventTime.isBetween(startTime, endTime) ? "1" : "0");
            }
            System.out.println();
        }
    }
}
