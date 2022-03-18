/*
* Date: 2020-09-14.
* File Name: App.Java
* Author: Sebastian Jonsson
*
* Copyright (c): Here comes the copyright statement if any ...
*/

import sj223gb_assign1.ISBN;
import sj223gb_assign1.ArmstrongNumber;
import sj223gb_assign1.SquareRoot;
import sj223gb_assign1.TextProcessor;

import java.io.IOException;

import sj223gb_assign1.Anagram;
import sj223gb_assign1.Codestrip;
import sj223gb_assign1.Point;
import sj223gb_assign1.InvoiceTest;
import sj223gb_assign1.TimeDemo;
import sj223gb_assign1.ArraysMain;

/**
 * Class that is used for testing each of the tasks for the first assignment.
 * 
 * Uncomment what you want to run.
 */
public class App {
    public static void main(String[] args) throws Exception {
        // isbn();
        // armstrongNumber();
        // squareRoot();
        // textProcessor();
        // anagram();
        codestripDemo();
        // pointDemoCode();
        // invoiceTestDemo();
        // timeDemo();
        // arraysMainDemo(); 
    }

    private static void arraysMainDemo() {
        ArraysMain arraysMain = new ArraysMain();
        arraysMain.main(null);
    }

    private static void timeDemo() {
        TimeDemo timeDemo = new TimeDemo();
        timeDemo.main(null);
    }

    private static void invoiceTestDemo() {
        InvoiceTest invoiceTest = new InvoiceTest();
        invoiceTest.runDemonstration();  
    }

    private static void pointDemoCode() {
        Point p1 = new Point();
        Point p2 = new Point(3,4);

        System.out.println(p1.toString()); // ==> (0,0)
        System.out.println(p2.toString()); // ==> (3,4)

        if (p1.isEqualTo(p2)) // False!
            System.out.println("The two points are equal");

        double dist = p1.distanceTo(p2);

        System.out.println("Point Distance: "+dist);

        p2.move(5,-2); // ==> (8,2)
        p1.moveToXY(8,2); // ==> (8,2)
        
        if (p1.isEqualTo(p2)) // True!
        System.out.println("The two points are equal");
    }

    private static void codestripDemo() throws IOException {
        Codestrip codestrip = new Codestrip();
        codestrip.readFileLines();
    }

    private static void anagram() throws IOException {
        Anagram anagram = new Anagram();
        anagram.getUserInput();
    }

    private static void textProcessor() {
        TextProcessor textProcessor = new TextProcessor();
        textProcessor.getUserInput();
    }

    private static void squareRoot() {
        SquareRoot squareRoot = new SquareRoot();
        squareRoot.getUserInput();
    }

    private static void armstrongNumber() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        armstrongNumber.getUserInput();
    }

    private static void isbn() {
        ISBN isbn = new ISBN();
        isbn.inputGatherer();
    }

}
