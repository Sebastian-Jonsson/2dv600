package sj223gb_assign1;

/**
* Class Description: This class is about the tenth task of assignment 1.
* A class that will be testing the Arrays class.
* 
* @version 1.1 14 September 2021
* @author Sebastian Jonsson
*/
public class ArraysMain {
    int[] intArray1 = {1, 2, 3, 4, 5};
    int[] intArray2 = {1, 2, 3, 4, 5};
    int[] subArray1 = {1, 2, 3, 4, 5};
    int[] subArray2 = {3, 4, 5};
    int oldInt = 2;
    int nwInt = 5;
    
    /**
     * Initiates the demonstration of the Arrays class.
     * @param args
     */
    public void main(String[] args) {
        runDemonstration();
    }

    /**
     * Prints the demonstrations and proper values.
     */
    private void runDemonstration() {
        arrayUsedFirstPart();
        averageDemo();
        maxDemo();
        addNDemo();
        reverseDemo();

        arrayUsedSecondPart();
        replaceAllDemo();
        sortDemo();
        haSubStringDemo();
        absDifDemo();
    }

    private void absDifDemo() {
        System.out.println("\nAbsDif: \n" + "IntArray1: " + printDemo(intArray1) 
        + "\nIntArray2: " + printDemo(intArray2) 
        + "\nNew dist array: " + printDemo(Arrays.absDif(intArray1, intArray2)));

        System.out.println("\nAbsDif: \n" + "IntArray1: " + printDemo(intArray1) 
        + "\nSubArray2: " + printDemo(subArray2) 
        + "\nException Handling: \n");
        printDemo(Arrays.absDif(intArray1, subArray2));
    }

    private void haSubStringDemo() {
        System.out.println("\nHasSubstring:\nSubstring subArray1: " + 
        printDemo(subArray1) + "\nIntArray2 array: " + printDemo(intArray2) + 
        "\n" + Arrays.hasSubString(intArray2, subArray1));

        System.out.println("\nSubstring subArray2: " + printDemo(subArray2) + 
        "\nIntArray2 array: " + printDemo(intArray2) + "\n" + 
        Arrays.hasSubString(intArray2, subArray2));
    }

    private void sortDemo() {
        int[] sortedArray = new int[intArray2.length];
        sortedArray = Arrays.sort(intArray2);
        
        System.out.println("\nIntArray2 arr: " + printDemo(intArray2) + 
        "\nNew array sortedArray: " + printDemo(sortedArray));
    }

    private void replaceAllDemo() {
        Arrays.replaceAll(intArray2, oldInt, nwInt);
        System.out.println("ReplaceAll: " + printDemo(intArray2));
    }

    private void arrayUsedSecondPart() {
        System.out.println("\nIntArray2: " + printDemo(intArray2));
    }

    private void reverseDemo() {
        System.out.println("Reverse: " + printDemo(Arrays.reverse(intArray1)));
    }

    private void addNDemo() {
        System.out.println("AddN: " + printDemo(Arrays.addN(intArray1, oldInt)));
    }

    private void maxDemo() {
        System.out.println("Max: " + Arrays.max(intArray1));
    }

    private void averageDemo() {
        System.out.println("Average: " + Arrays.average(intArray1));
    }

    private void arrayUsedFirstPart() {
        System.out.println("IntArray1: " + printDemo(intArray1));
    }

    /**
     * Helper function to print arrays to string for demonstration.
     * @param arg - The array to be printed.
     * @return - The printed string.
     */
    private String printDemo(int[] arg) {
        return java.util.Arrays.toString(arg);
    }

}
