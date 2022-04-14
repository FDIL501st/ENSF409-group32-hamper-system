/**
 * <h1>OrderForm</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.7
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;
import java.time.LocalDate;


public class OrderForm {
    
    private int formCounter = 1; //Counter variable used to give different order forms different names
    private boolean textCheck; //Used for error checking
    
    
    public boolean getTextCheck () {
        return this.textCheck;
    }
    
    
    public int getFormCounter () {
        return this.formCounter;
    }
    
    
    public String getFormName () {
        return "Order_Form" + this.formCounter;
    }
    
    
    /**
     * The reportShortage method creates the order form in the case of a shortage, 
     * and then writes details on the shortage the the order form.  
     */
    public void reportShortage () {
        
        textCheck = createNewText("Order_Form" + formCounter);
        appendToText("Example Food Bank\nHamper Order Form\n\nName: ", "Order_Form" + formCounter);
        appendToText("Order_Form" + formCounter, "Order_Form" + formCounter);
        appendToText("\nDate: ", "Order_Form" + formCounter);
        appendToText(LocalDate.now(), "Order_Form" + formCounter);
        appendToText("\n\nOriginal Request\n", "Order_Form" + formCounter);
        formSetup(hamperList); //Print begining of form
        appendToText("\n", "Order_Form" + formCounter);
        appendToText("Shortage detected!!!", "Order_Form" + formCounter);
        appendToText(FoodInventory.shortageMessage, "Order_Form" + formCounter);
        this.formCounter++; //Increment form counter so that next form has different name
    }            
        
    
    
    /**
     * The createForm method creates the order form, and then calls different 
     * methods in this file to format and complete the printing of form data. It 
     * also does some of this formatting itself. Finally, it helps the program keep 
     * track of how many order forms have been printed, and assures each has a unique
     * name so that no important data is overwritten.
     * @param hamperList is the ArrayList of Hampers that are part of the order. 
     */
    //Calls other methods to complete printing of output file.
    public void createForm (ArrayList<Hamper> hamperList) {
        
        Hamper currentHamper = null;
        
        textCheck = createNewText("Order_Form" + formCounter);
        appendToText("Example Food Bank\nHamper Order Form\n\nName: ", "Order_Form" + formCounter);
        appendToText("Order_Form" + formCounter, "Order_Form" + formCounter);
        appendToText("\nDate: ", "Order_Form" + formCounter);
        appendToText(LocalDate.now(), "Order_Form" + formCounter);
        appendToText("\n\nOriginal Request\n", "Order_Form" + formCounter);
        formSetup(hamperList); //Print begining of form
        
        appendToText("\n", "Order_Form" + formCounter);
        
        for (int i = 0; i < hamperList.size(); i++) { //Print each hamper
            currentHamper = hamperList.get(i);
            int counter = i + 1;
            appendToText("Hamper " + counter + "Items:\n", "Order_Form" + formCounter);
            String hamperContents = documentHamper(currentHamper.getFoodCalculator().getHamperFoodCombo());
            appendToText(hamperContents, "Order_Form" + formCounter);
            appendToText("\n\n", "Order_Form" + formCounter);
        }
        this.formCounter++; //Increment form counter so that next form has different name
    }
    
    
    /**
     * The fromSetup method prints the begining of an order form, properly formatted 
     * and with intformation that is specific to each hamper in the order.
     * @param hamperList is the ArrayList of Hampers that are part of the order. 
     */
    //Does most of the printing up until the part that prints each hamper.
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
        
        for (int i = 0; i < hamperList.size(); i++) { //Go through each hamper
            currentHamper = hamperList.get(i); //Set currentHamper to the current hamper
            int counter = i+1;
            numAdultFemale = currentHamper.getNumAdultFemales(); //Set data from current hamper
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
            appendToText("Hamper " + counter + ": " + adultFemaleString + adultMaleString + 
                childU8String + childO8String + "\n", "Order_Form" + formCounter);
        }
    }
    
    
    /**
     * The documentHamper method gets and formats information about a  
     * hamper, and returns it as a formatted String.
     * @param hamper is the ArrayList of String arrays from a hamper that 
     * contains data about the hamper's contents.
     * @return returns the formatted String to be printed.
     */
    //Method for creating String representation of each hamper
    public String documentHamper(ArrayList<String[]> hamper) { 
        StringBuilder myString = new StringBuilder(""); //will eventually return this

        for (int j = 0; j < hamper.size(); j++) { //For every hamper in the order
            myString.append(hamper.get(j)[0] + '\t' + hamper.get(j)[1]); //Get ID and name
            myString.append('\n'); //Formatting 
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
        try { //Try to open the file to print to
            fw = new FileWriter(outputfile + ".txt", true);
            out = new PrintWriter(fw);
            out.printf(outputString); // Write data to file
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        finally {
            if (fw != null) {
                out.close(); //Close file after successful printing
            }
            else { //Else report error
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
        try { //Try to open outputfile
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
                out.close(); //Close file after successful creation
            }
            else { //Else report error
                System.out.println("Error occured, data not"
                + " printed to txt file");
                System.exit(0);
            }
        }
        return creationCheck;
    }
}
