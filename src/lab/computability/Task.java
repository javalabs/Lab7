package lab.computability;

/**
 * Created by AdminPC on 27.02.14.
 */
public class Task implements Runnable {
    private LeapYear year;

    public Task(LeapYear year) {
        this.year = year;
    }
    @Override
    public void run() {
        year.verify();
    }
}
