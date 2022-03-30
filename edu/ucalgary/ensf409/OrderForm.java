/**
 * <h1>OrderForm</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.4
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;


public class OrderForm {
    
    private int formCounter = 1;
    
    public void createForm (ArrayList<String>[] hamper1, ArrayList<String>[] hamper2) { //Full implementation take in an ArrayList of Hampers
        clearText("Order_Form" + formCounter);
        appendToText("Example Food Bank\nHamper Order Form\n\nName:\nDate:\n\nOriginal Request\n", "Order_Form" + formCounter);
        for (int i = 0; i < 2; i++) { //2 is arbitrary from number of inputs
            int counter = i+1;
            appendToText("Hamper " + counter + ": " + "1 Adult Female, 2 Child under 8\n", "Order_Form" + formCounter); //This would take in integer values from the hampers for number of people
        }
        appendToText("\n", "Order_Form" + formCounter);
        //for full implementation we would want a for loop here
        appendToText("Hamper 1 Items:\n", "Order_Form" + formCounter);
        String hamperContents = documentHamper(hamper1);
        appendToText(hamperContents, "Order_Form" + formCounter);
        appendToText("\n\n", "Order_Form" + formCounter);
        appendToText("Hamper 2 Items:\n", "Order_Form" + formCounter);
        hamperContents = documentHamper(hamper2);
        appendToText(hamperContents, "Order_Form" + formCounter);
        this.formCounter++;
    }
    
    public String documentHamper(ArrayList<String>[] hamper) {
        StringBuilder myString = new StringBuilder("");
            for (int j = 0; j < hamper[0].size(); j++) {
                myString.append(hamper[0].get(j) + "\t" + hamper[1].get(j));
                myString.append("\n");
            }
        return myString.toString();
    }
    
    
    /**
     * The appendToText method appends data to a text file. It does not 
     * override any existing data in that file.
     * @param outputString is the data to be printed to the output file.
     * @param outputfile is the name of the desired output file.
     */
     //Method for appending text to a text file
     //Code for this method adapted from reference [1]
    public static void appendToText(String outputString, String outputfile) {
        FileWriter fw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(outputfile + ".txt", true);
            out = new PrintWriter(fw);
            out.printf(outputString);
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        finally {
            if (fw != null) {
                out.close();
            }
            else {
                System.out.println("Error occured, data not"
                + " printed to txt file");
                System.exit(0);
            }
        }
    }
    
    
    /**
     * The clearText method clears any data currently in a specified 
     * text file.
     * @param outputfile is the name of the desired output file.
     */
     //Method for clearing a text file
     //Code for this method adapted from reference [1]
    public static void clearText(String outputfile) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(outputfile + ".txt");
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        finally {
            if (out != null) {
                out.close();
            }
            else {
                System.out.println("Error occured, data not"
                + " printed to txt file");
                System.exit(0);
            }
        }
    }
}
