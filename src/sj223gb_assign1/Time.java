package sj223gb_assign1;

/**
* Class Description: This class is about the ninth task of assignment 1.
* A class that will be tested by the TimeDemo class.
* 
* @version 1.0 8 September 2021
* @author Sebastian Jonsson
*/
public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    private int maxSeconds = 86400;
    
    /**
     * Constructor for no params.
     */
    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    
    /**
     * Constructor for three params.
     * 
     * @param seconds - The input seconds.
     * @param minutes - The input minutes.
     * @param hours - The input hours.
     */
    public Time(int seconds, int minutes, int hours) {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    /**
     * Constructor for one param.
     * 
     * @param seconds - The input seconds.
     */
    public Time(int seconds) {
        this.setClock(seconds);
    }

    /**
     * Gets the amount of seconds.
     * 
     * @return - The amount of seconds.
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Sets the amount of seconds and makes certain the input is no bigger than 59.
     * 
     * @param seconds - The amount of seconds.
     */
    public void setSeconds(int seconds) {

        if (seconds < 60 && minutes >= 0) {
            this.seconds = seconds;
        }
        else {
            System.out.println("The amount of seconds were too many.");
        }
    }

    /**
     * Gets the amount of minutes.
     * 
     * @return - The amount of minutes.
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Sets the amount of minutes and makes certain the input is no bigger than 59.
     * 
     * @param minutes - The amount of minutes.
     */
    public void setMinutes(int minutes) {

        if (minutes < 60 && minutes >= 0) {
            this.minutes = minutes;
        }
        else {
            System.out.println("The amount of minutes were too many.");
        }
    }

    /**
     * Gets the amount of hours.
     * 
     * @return - The amount of hours.
     */
    public int getHours() {
        return hours;
    }

    /**
     * Sets the amount of hours and makes certain the input is no bigger than 23.
     * 
     * @param hours - The amount of hours.
     */
    public void setHours(int hours) {

        if (hours < 24 && hours >= 0) {
            this.hours = hours;
        }
        else {
            System.out.println("The amount of hours were too many.");
        }
    }
    
    /**
     * Increments one second to the current Time object.
     */
    public void tick() {
        setClock(getTotalSeconds() + 1);  
    }

    /**
     * Decrements one second from the current Time object.
     */
    public void tickDown() {
        setClock(getTotalSeconds() - 1);
    }

    /**
     * Calculates the sum of the current and second Time object in seconds.
     * 
     * @param time2 - The second Time object.
     * @return - The sum of the current and second Time object.
     */
    public Time addTime(Time time2) {
        return new Time(this.getTotalSeconds() + time2.getTotalSeconds());
    }

    /**
     * Calculates the differences between the current and another Time object.
     * 
     * @param time2 - The second Time object.
     * @return - The calculated difference between the current and second Time object.
     */
    public Time subtracTime(Time time2) {
        return new Time(Math.abs(this.getTotalSeconds() - time2.getTotalSeconds()));
    }
    
    /**
     * Formats the time into a HH:MM:SS format 
     * 
     * @return - The formatted string.
     */
    public String toString() {
        String hours = String.format("%02d", this.hours);
        String minutes = String.format("%02d", this.minutes);
        String seconds = String.format("%02d", this.seconds);

        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * Converts the seconds so that they fit minutes and hours.
     * 
     * @param seconds - The seconds to convert.
     */
    private void setClock(int seconds) {

        if (seconds >= maxSeconds) {
            setClock(seconds -= maxSeconds);
        }
        else if (seconds < 0) {
            setClock(seconds = maxSeconds - 1);
        }
        else {
            int hours = seconds / 60;
            setHours(hours / 60);
            setMinutes(hours % 60);
            setSeconds(seconds % 60);
        }
    }

    /**
     * Gets the total amount of seconds by converting hours and minutes, then adding the leftover seconds.
     * 
     * @return - The total amount of seconds.
     */
    private int getTotalSeconds() {
        return this.seconds + (this.minutes * 60) + (this.hours * 60 * 60);
    }

}
