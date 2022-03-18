package sj223gb_assign1;

/**
* Class Description: This class is about the ninth task of assignment 1.
* A class that will be testing the Time class.
* 
* @version 1.0 8 September 2021
* @author Sebastian Jonsson
*/
public class TimeDemo {
    Time timeA;
    byte amountOfTicks = 10;

    /**
     * Initiates the demo as shown in the TimeDemo part of task nine, assignment 1.
     * 
     * @param args
     */
    public void main(String[] args) {
        System.out.println("Object 'timeA' instantiated and ticking ten times:");
        timeA = new Time(86399);
        tickTenTimes(timeA);

        System.out.println("\nObject 'timeB' instantiated and ticking ten times:");
        Time timeB = new Time(27, 13, 0);
        tickTenTimes(timeB);

        System.out.println("\nSum of timeA and timeB:\n" + timeA.addTime(timeB) + "\n");
        
        Time timeC = timeA.subtracTime(timeB);
        System.out.println("Reference timeC: \n" + timeC.toString());
    }

    /**
     * Loops through tick ten times and prints the time each time.
     * 
     * @param timeX - Placeholder for any sent Time object.
     */
    private void tickTenTimes(Time timeX) {

        for (int i = 0; i < amountOfTicks; i++) {
            timeX.tick();
            System.out.println(timeX.toString());
        }
    }


}
