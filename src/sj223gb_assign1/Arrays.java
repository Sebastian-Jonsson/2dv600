package sj223gb_assign1;

/**
* Class Description: This class is about the tenth task of assignment 1.
* A class that will be demonstrated by the ArraysMain class.
* 
* @version 1.1 13 September 2021
* @author Sebastian Jonsson
*/
public class Arrays {
    
    /**
     * Calculates the average value of all values in an array.
     * 
     * @param arr - The array to be tested.
     * @return - The average value of the array.
     */
    public static int average(int[] arr) {
        int totalValue = 0;
        
        for (int i = 0; i < arr.length; i++) {
            totalValue += arr[i];
        }
        return totalValue / arr.length;
    }
    
    /**
     * Calculates the maximum value in an array.
     * 
     * @param arr - The array to be tested.
     * @return - The max value of the array.
     */
    public static int max(int[] arr) {
        int maxValue = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
    
    /**
     * Adds a value to each index point in the array sent into it and returns it.
     * 
     * @param arr - The array to add a value onto each index.
     * @param n - The integer value to add.
     * @return - The modified array.
     */
    public static int[] addN(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] += n;
        }
        return arr;
    }
    
    /**
     * Modifies an original array by copying it and then putting the new array in reverse order.
     * 
     * @param arr - The array to be copied.
     * @return - A copy of the original array that has been modified.
     */
    public static int[] reverse(int[] arr) {
        int[] newArray = new int[arr.length];
        int countDown = newArray.length - 1;
        
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arr[countDown];
            countDown--;
        }
        return newArray;
    }
    
    /**
     * Replaces all occurences of a previous value with a new value in the array.
     * 
     * @param arr - The array to be modified.
     * @param old - The old value to be replaced by the new.
     * @param nw - The new value to replace the old.
     */
    public static void replaceAll(int[] arr, int old, int nw) {
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] == old) {
                arr[i] = nw;
            }
        }
    }
    
    /**
     * Sorts a clone of the input array in ascending order.
     * 
     * @param arr - The array to be cloned.
     * @return - The cloned array.
     */
    public static int[] sort(int[] arr) {
        int[] newArray = new int[arr.length];
        int number = 0;
        
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int x = i + 1;

            for (int j = x; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    number = arr[i];
                    newArray[i] = arr[j];
                    newArray[j] = number;
                }
            }
        }
        return newArray;
    }
    
    /**
     * Checks if the value of one array exists in another array.
     * 
     * @param arr - The array that may contain the other arrays values.
     * @param sub - The array that may be contained in the other arrays values.
     * @return - Returns a boolean, if the array contains the other arrays value.
     */
    public static boolean hasSubString(int[] arr, int[] sub) {
        boolean match = false;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == sub[0]) {
                int patternLength = i + sub.length - 1;

                if (patternLength > arr.length) {
                    // If it's larger than the size of the array, then no match.
                }
                else {
                    match = true;

                    for (int j = 0; j < sub.length; j++) {
                        int arrPosition = i + j;

                        if (arr[arrPosition] != sub[j]) {
                            match = false;
                            break;
                        }
                    }
                    return match;
                }
            }
        }
        return match;
    }
    
    /**
     * Checks what the difference between two arrays is in integers.
     * 
     * @param arr1 - The first array to be checked.
     * @param arr2 - The second array to be checked.
     * @return - An array with the absolute difference between the two arrays.
     */
    public static int[] absDif(int[] arr1, int[] arr2) {

        if (arr1.length == arr2.length) {
            int[] diff = new int[arr1.length];
            
            for (int i = 0; i < diff.length; i++) {
                diff[i] = arr1[i] - arr2[i];

                if(diff[i] < 0) {
                    diff[i] = diff[i] * (-1);
                }
            }
            return diff;
        } 
        else {
            throw new IllegalArgumentException("Both input arrays must be the same length.");
        }
    }
}
