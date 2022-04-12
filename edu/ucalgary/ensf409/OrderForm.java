/**
 * <h1>OrderForm</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.5
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;


public class OrderForm {
    
    private int formCounter = 1;
    private boolean textCheck;
    
    
    public boolean getTextCheck () {
        return this.textCheck;
    }
    
    
    public int getFormCounter () {
        return this.formCounter;
    }
    
    
    //Sort of the main method of this Class. Calls other methods to complete printing of output file.
    public void createForm (ArrayList<Hamper> hamperList) {
        
        Hamper currentHamper = null;
        
        textCheck = createNewText("Order_Form" + formCounter);
        appendToText("Example Food Bank\nHamper Order Form\n\nName:\nDate:\n\nOriginal Request\n", "Order_Form" + formCounter);
        
        formSetup(hamperList);
        
        appendToText("\n", "Order_Form" + formCounter);
        
        for (int i = 0; i < hamperList.size(); i++) {
            currentHamper = hamperList.get(i);
            int counter = i + 1;
            appendToText("Hamper " + counter + "Items:\n", "Order_Form" + formCounter);
            String hamperContents = documentHamper(currentHamper.getFoodCalculator().getHamperFoodCombo());
            appendToText(hamperContents, "Order_Form" + formCounter);
            appendToText("\n\n", "Order_Form" + formCounter);
        }
        this.formCounter++;
    }
    
    
    //I had to create this method to keep CreateForm under 25 lines of code.
    //It basically does most of the printing up until the part that prints each hamper.
    public void formSetup (ArrayList<Hamper> hamperList) {
        Hamper currentHamper = null;
        int numAdultFemale = 0;
        int numAdultMale = 0;
        int numChildU8 = 0;
        int numChildO8 = 0;
        String adultFemaleString = "";
        String adultMaleString = "";
        String childU8String = "";
        String childO8String = "";
        
        for (int i = 0; i < hamperList.size(); i++) {
            currentHamper = hamperList.get(i);
            int counter = i+1;
            numAdultFemale = currentHamper.getNumAdultFemales();
            numAdultMale = currentHamper.getNumAdultMales();
            numChildU8 = currentHamper.getNumChildrenO8();
            numChildO8 = currentHamper.getNumChildrenU8();
            if (numAdultFemale != 0) {
                adultFemaleString = numAdultFemale + "Adult Female, ";
            }
            if (numAdultMale != 0) {
                adultMaleString = numAdultMale + "Adult Male, ";
            }
            if (numChildU8 != 0) {
                childU8String = numChildU8 + "Child under 8, ";
            }
            if (numChildO8 != 0) {
                childO8String = numChildO8 + "Child over 8";
            }
            appendToText("Hamper " + counter + ": " + adultFemaleString + adultMaleString + childU8String + childO8String + "\n", "Order_Form" + formCounter);
        }
    }
    
    
    //Method for creating String representation of each hamper
    public String documentHamper(ArrayList<String[]> hamper) {
        StringBuilder myString = new StringBuilder("");

        for (int j = 0; j < hamper.size(); j++) {
            myString.append(hamper.get(j)[0] + '\t' + hamper.get(j)[1]);
            myString.append('\n');
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
     * The createNewText method clears any data currently in a specified 
     * text file if it already exists, or creates a new one if it doesn't.
     * @param outputfile is the name of the desired output file.
     */
     //Method for creating a text file
    public static boolean createNewText(String outputfile) {
        PrintWriter out = null;
        boolean creationCheck = false;
        try {
            out = new PrintWriter(outputfile + ".txt");
            creationCheck = true;
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            return false;
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
        return creationCheck;
    }
}
