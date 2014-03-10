package lab.computability;



/**
 * Created by AdminPC on 20.02.14.
 */
public class LeapYear  {
    private int year;
    private boolean isLeapYear;

    public LeapYear(int year) {
        this.year = year;
    }

    public synchronized void Verify() {
        isLeapYear =  (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

    public synchronized boolean getLeapYear() {
        return isLeapYear;
    }
}
