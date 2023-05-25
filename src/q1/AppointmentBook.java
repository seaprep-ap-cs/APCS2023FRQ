package q1;

import java.util.*;
public class AppointmentBook {

    private boolean isMinuteFree(int period, int minute) {
        List<Boolean> minutes = this.appts.get(period);
        return minutes.get(minute);
    }

    private void reserveBlock(int period, int startMinute, int duration) {
        List<Boolean> minutes = this.appts.get(period);
        for (int i = startMinute; i < startMinute + duration; i++) {
            minutes.set(i, false);
        }
    }

    public int findFreeBlock(int period, int duration) {
        // Check each minute until the minute equals 59 - duration
        for (int startingMinute = 0; startingMinute <= 59 - duration; startingMinute++) {
            // counter of free minutes
            int countFreeMinutes = 0;
            // check if each minute within the duration is available to book
            for (int currentMinute = startingMinute; currentMinute < startingMinute + duration; currentMinute++) {
                if (isMinuteFree(period, currentMinute)) {
                    countFreeMinutes++;
                }
            }

            // once we have checked each minute, check if our counter of free minutes is equal to the duration
            // if so, return the starting minute
            if (countFreeMinutes == duration) {
                return startingMinute;
            }
        }

        // return -1 if no free block is found
        return -1;
    }

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        // check each period
        for (int currentPeriod = startPeriod; currentPeriod <= endPeriod; currentPeriod++) {
            // check whether the period has a free block
            int freeStartMinute = findFreeBlock(currentPeriod, duration);

            // if the period has a free block, reserve that block of time and return true
            if (freeStartMinute != -1) {
                // we have a free block in this period
                reserveBlock(currentPeriod, freeStartMinute, duration);
                return true;
            }
        }

        // if we don't find a free block in any of the periods, return false
        return false;
    }

    public Map<Integer, List<Boolean>> appts;

    public AppointmentBook(Map<Integer, List<Boolean>> appts) {
        this.appts = appts;
    }

    public static void main(String[] args) {
        // create an appointmentBook
        AppointmentBook apptBook = createTestAppointmentBookPartA();

        // Tests from the FRQ

        // tests on findFreeBlock method
        int period = 2;
        int duration = 15;
        int block = apptBook.findFreeBlock(period, duration);
        print("findFreeBlock(" + period +"," + duration + ") returns " + block);

        duration = 9;
        block = apptBook.findFreeBlock(period, duration);
        print("findFreeBlock(" + period +"," + duration + ") returns " + block);

        duration = 20;
        block = apptBook.findFreeBlock(period, duration);
        print("findFreeBlock(" + period +"," + duration + ") returns " + block);

        // tests on makeAppointment method
        AppointmentBook apptBookPartB = createTestAppointmentBookPartB();

        int startPeriod = 2;
        int endPeriod = 4;
        duration = 22;
        boolean result = apptBookPartB.makeAppointment(startPeriod, endPeriod, duration);
        print("makeAppointment(" + startPeriod + "," + endPeriod + "," + duration + ") returns " + result);

        startPeriod = 3;
        endPeriod = 4;
        duration = 3;
        result = apptBookPartB.makeAppointment(startPeriod, endPeriod, duration);
        print("makeAppointment(" + startPeriod + "," + endPeriod + "," + duration + ") returns " + result);

        startPeriod = 2;
        endPeriod = 4;
        duration = 30;
        result = apptBookPartB.makeAppointment(startPeriod, endPeriod, duration);
        print("makeAppointment(" + startPeriod + "," + endPeriod + "," + duration + ") returns " + result);
    }

    private static void print(Object o) {
        System.out.println(o);
    }

    private static void displayPeriods(AppointmentBook apptBook) {
        for (int period:  apptBook.appts.keySet()) {
            print("Period: " + period);
            print(apptBook.appts.get(period));
            print("");
        }
    }

    private static AppointmentBook createTestAppointmentBookPartA() {
        Map<Integer, List<Boolean>> appts = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            List<Boolean> minutes =new ArrayList<Boolean>(Arrays.asList(new Boolean[60]));
            Collections.fill(minutes, true);
            appts.put(i,minutes);
        }

        // create an appointmentBook
        AppointmentBook apptBook = new AppointmentBook(appts);
        // updates minutes in period 2
        apptBook.reserveBlock(2, 0, 10);
        apptBook.reserveBlock(2, 15, 15);
        apptBook.reserveBlock(2, 45, 5);

        return apptBook;
    }

    private static AppointmentBook createTestAppointmentBookPartB() {
        Map<Integer, List<Boolean>> appts = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            List<Boolean> minutes =new ArrayList<Boolean>(Arrays.asList(new Boolean[60]));
            Collections.fill(minutes, true);
            appts.put(i,minutes);
        }

        // create an appointmentBook
        AppointmentBook apptBook = new AppointmentBook(appts);
        // updates minutes in period 2
        apptBook.reserveBlock(2, 0, 25);
        apptBook.reserveBlock(2, 30, 30);

        apptBook.reserveBlock(3, 15, 26);

        apptBook.reserveBlock(4, 0, 5);

        apptBook.reserveBlock(4, 30, 14);

        return apptBook;
    }


}
