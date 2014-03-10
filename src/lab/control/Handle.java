package lab.control;

import lab.computability.LeapYear;
import lab.computability.Task;

import java.util.Scanner;

/**
 * Created by AdminPC on 20.02.14.
 */
public class Handle implements Runnable {
    private LeapYear year;
    private int y;
    public int inputData() {
        Scanner scan = new Scanner(System.in);
        int temp;
        while(true)
        try {
            System.out.print("Enter year\n>>> ");
            temp =  scan.nextInt();
            break;
        } catch (Exception e) {
            System.out.println("Exception. Try Again...");
            scan.nextLine();
        }
        return temp;
    }

    public void displayData(boolean isLeap) {
        if(isLeap)
            System.out.println("" + y + " - leap year");
        else
            System.out.println("" + y + " - no leap year");
    }


    @Override
    public void run() {
        y = inputData();
        year = new LeapYear(y);
        Thread compute = new Thread(new Task(year));
        compute.start();
        try {
            compute.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        displayData(year.getLeapYear());
     }
}
