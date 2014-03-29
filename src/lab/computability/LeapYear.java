package lab.computability;

/**
 * Created by AdminPC on 20.02.14.
 */

public class LeapYear implements Verifiable {
    private int year;
    private boolean isLeapYear = false;
    private boolean isReady = false;
    private Object locker = new Object();

    public LeapYear(int year) {
        this.year = year;
    }

    public LeapYear() {

    }

    @Override
    public void verify() {
        synchronized (locker) {
            while(!isReady)
            try {
                locker.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //testing (synchronized get)
            //for(int i = 0; i < 10000; i++)
            //    if(i % 100 == 0) ++i;

            isLeapYear =  (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);

            isReady = false;

            locker.notify();
        }
    }

    public boolean getLeapYear() {
        return isLeapYear;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        synchronized (locker) {
            this.year = year;
            isReady = true;

            locker.notify();

            //if not synchronized method  getLeapYear() getYear()
            while (isReady)
            try {
                locker.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
