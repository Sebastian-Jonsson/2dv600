import java.util.Scanner;

public class aTentaPlugg {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String sentence = scanner.next();

        // System.out.println(isPalindrome(sentence));

        runPatterns();
    }

    private static boolean isPalindrome(String sentence) {
        System.out.print(sentence);

        String reverse = "";

        for (int i = sentence.length() - 1; i >= 0 ; i--) {
            reverse += sentence.charAt(i);
        }

        return sentence.toLowerCase().equals(reverse.toLowerCase());
    }

    private static void runPatterns() {
        int number = scanner.nextInt();
        
        if (number % 2 == 0) {
            System.out.println("Restart and pick a valid number.");
        }
        else
        createFigure(number);
    }

    private static void createFigure(int nextInt) {
        int i, j;

        // createDoubleSizeDiamond(nextInt);
        // createDiamond(nextInt);
        //  topDiamond(i, nextInt);
        //  bottomDiamond(i, nextInt);
        //  reverseHillPattern(i, nextInt);
        
        for (i = 0; i < nextInt; i++) {  // rows what happens on each // num/2 +1 avrundar neråtkompensation
            hillPattern(i, nextInt);
        //     // bredd botten pyramid *
        //     for (int j2 = nextInt; j2 > i; j2--) { // columns
        //         System.out.print(" ");
        //     }
        //     for (int j2 = 0; j2 < i; j2++) { // columns
        //         System.out.print("* ");
        //     }
        //     System.out.println(); // Makes certain a linebreak occurs, pattern change row
        // }
        // for (i = nextInt; i > 0; i--) {
        //     for (int j2 = i; j2 < nextInt; j2++) { // columns
        //         System.out.print(" ");
        //     }
        //     for (int k = 0; k < i; k++) { // columns
        //         System.out.print("* ");
        //     }
            System.out.println();
        }
    }

    private static void createDoubleSizeDiamond(int nextInt) {
        int i;
        for (i = 0; i < nextInt - 1; i++) {  // columns, what happens on each // num/2 +1 avrundar neråtkompensation
            hillPattern(i, nextInt);
            System.out.println(); // Makes certain a linebreak occurs, pattern change row
        }
        for (i = 0; i < nextInt; i++) {  // columns, what happens on each // num/2 +1 avrundar neråtkompensation
            reverseHillPattern(i, nextInt);
            System.out.println(); // Makes certain a linebreak occurs, pattern change row
        }
    }

    private static void createDiamond(int nextInt) {
        for (int i = 0; i < nextInt; i++) {
            topDiamond(i, nextInt);
            System.out.println();
        }
        for (int i = 0; i < nextInt; i++) {
            bottomDiamond(i, nextInt);
            System.out.println();
        }
    }

    private static void hillPattern(int i, int nextInt) {
        int j;
        // platt topp triangel
        for(j = i; j < nextInt - 1; j++) {
            System.out.print("  ");
        }
        for(j = 0; j < i; j++) {
            System.out.print("* ");
        }
        for(j = 0; j < i; j++) {
            System.out.print("* ");
        }
    }

    private static void reverseHillPattern(int i, int nextInt) {
        int j;

        for(j = 0; j < i; j++) {  // minus i här på nextInt blir 
            System.out.print("  ");
        }
        // platt topp triangel
        for(j = i; j < nextInt - 1; j++) {  // minus i här på nextInt blir 
            System.out.print("* ");
        }
        for(j = i; j < nextInt; j++) {  // minus i här på nextInt blir 
            System.out.print("* ");
        }
        
    }



    private static void topDiamond(int outer, int nextInt) {
        int j;
        // Tänk efter på spaces, lägger du till en efter så förlänger du raden efter, gentemot före
        for(j = outer; j < nextInt; j++) {  // Om man vill BÖRJA så långt ut som möjligt
            System.out.print(" ");
        }
        for(j = 0; j < outer; j++) {  // kör du utan space till höger här så blir det en rak högerkant
            System.out.print("* ");
        }
    }
    private static void bottomDiamond(int outer, int nextInt) {
        int j;
        // Tänk efter på spaces, lägger du till en efter så förlänger du raden efter, gentemot före
        for(j = outer; j > 0; j--) {  // Om man vill BÖRJA så långt ut som möjligt
            System.out.print(" ");
        }
        for(j = outer; j < nextInt; j++) {  // kör du utan space till höger här så blir det en rak högerkant
            System.out.print("* ");
        }
    }

}
