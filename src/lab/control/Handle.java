package lab.control;

import lab.computability.LeapYear;
import lab.computability.Task;

import java.util.Scanner;

/**
 * Created by AdminPC on 20.02.14.
 */
public class Handle implements Runnable {
    private LeapYear year1;
    private LeapYear year2;

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

    public void displayData(int y, boolean isLeap) {
        if(isLeap)
            System.out.println("" + y + " - leap year");
        else
            System.out.println("" + y + " - no leap year");
    }


    @Override
    public void run() {
        year1 = new LeapYear();
        year2 = new LeapYear();

        Thread compute1 = new Thread(new Task(year1));
        Thread compute2 = new Thread(new Task(year2));

        compute1.start();
        compute2.start();


        year1.setYear(inputData());
        year2.setYear(inputData());


        displayData(year1.getYear(), year1.getLeapYear());
        displayData(year2.getYear(), year2.getLeapYear());
     }
}
