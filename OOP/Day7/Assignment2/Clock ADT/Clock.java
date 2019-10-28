/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59). 
 * To do so, implement the following public API:
 * 
 * @author Siva Sankar and Aiswarya
 */

public class Clock {
    int h;
    int m;
    // Creates a clock whose initial time is h hrs and m min.
    /**
     * The parameterised constructor will instatiates the object with the values of
     * the parameters h and m to the respective hrs nad min.
     * @param h
     * @param m
     */
    public Clock(int h, int m) {
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.

    public Clock(String s) {
        this.h = Integer.valueOf(s.substring(0,2));
        this.m = Integer.valueOf(s.substring(3,5));
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String hour = String.valueOf(this.h);
        String min = String.valueOf(this.m);
        if (this.h<=9){
            hour = "0"+hour;
        }
        if (this.m<=9){
            min = "0"+min;
        }
        return hour+":"+min;

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        int hour = that.h;
        int min = that.m;
        int totalMinutes = 0;
        totalMinutes += this.h*60;
        totalMinutes += this.m;
        int thatTotalMin = 0;
        thatTotalMin += hour*60;
        thatTotalMin += min;
        if (totalMinutes < thatTotalMin){
            return true;
        }else return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.toc(1);
    }

    // Adds Δ min to the time on this clock.
    public void toc(int delta) {
        if (delta>1440){
            int d = delta/1440;
            int s = d*1440;
            delta = delta-s;
        } if (delta > 0){
        int totalMinutes = 0;
        totalMinutes += this.h*60;
        totalMinutes += this.m;
        totalMinutes += delta;
        if (totalMinutes >= 1440){
            totalMinutes -= 1440;
            this.h = 0;
            this.m = totalMinutes;
        }else {
            
        float f = totalMinutes/60;
        int s = (int) f;
        this.h = s;
        this.m = (totalMinutes-(s*60));
        }
    }
        
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock("13:00");
        clock.toc(661);
        System.out.println(clock);
    }
}