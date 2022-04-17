/**
 * <h1>GUIHamperSystem</h1>
 * Project for ENSF 409
 * <p>
 * @author Adem
 * @author Fadil
 * @author Sam
 * @author Tanvir Haer <a href="mailto:tanvir.haer@ucalgary.ca">tanvir.haer@ucalgary.ca</a> | UCID: 30039188
 * @version 1.4
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

/* Notes:
   - Need max number of people for each field
   - Do we want to clear the fields every time you press the button to submit/add another hamper? wasnt sure how to do this
   - Can you guys think of any other things we should check for in validating the input?
   - Currently terminates program when the user closes the window
*/

public class GUIHamperSystem extends JFrame implements ActionListener, MouseListener{

    private String numAdultMales;
    private String numAdultFemales;
    private String numChildO8;
    private String numChildU8;

    private int adultMales;
    private int adultFemales;
    private int childO8;
    private int childU8;

    // store each hamper request as an array in this arraylist (order of array: adultMales, adultFemales, childO8, childU8)
    ArrayList<int[]> hamperRequests = new ArrayList<int[]>();

    // hamper request variable
    private HamperRequest hamperRequestToCreate;

    private JLabel instructions1;
   // private JLabel instructions2;
    private JLabel maleLabel;
    private JLabel femaleLabel;
    private JLabel childO8Label;
    private JLabel childU8Label;

    private JTextField maleInput;
    private JTextField femaleInput;
    private JTextField childO8Input;
    private JTextField childU8Input;

    private JButton createHampers;
    private JButton addHamper;

    /**
     * Constructor to create the GUI window
     */

    public GUIHamperSystem(){
        super("Create a Hamper Request");
        setupGUI();
        setSize(1000,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Function to set up the graphical user interface and its fields
     */
    public void setupGUI(){

        instructions1 = new JLabel("Please enter the numbers of the types of people for this hamper as a digit (e.g. 2) up to a maximum of 10 family members per hamper.");
     //   instructions2 = new JLabel("Press 'Add Another Hamper Request' to add another hamper or 'Create Hampers' to create the hampers");
        maleLabel = new JLabel("Number of Adult Males:");
        femaleLabel = new JLabel("Number of Adult Females:");
        childO8Label = new JLabel("Number of Children Over 8:");
        childU8Label = new JLabel("Number of Children Under 8:");

        maleInput = new JTextField("", 3);
        femaleInput = new JTextField("", 3);
        childO8Input = new JTextField("", 3);
        childU8Input = new JTextField("", 3);

        maleInput.addMouseListener(this);
        femaleInput.addMouseListener(this);
        childO8Input.addMouseListener(this);
        childU8Input.addMouseListener(this);

        addHamper = new JButton("Add Another Hamper Request");
        addHamper.addActionListener(this);

        createHampers = new JButton("Create Hampers");
        createHampers.addActionListener(this);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        // JPanel instructionsPanel = new JPanel();
        // headerPanel.setLayout(new FlowLayout());

        JPanel hamperPanel = new JPanel();
        hamperPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        headerPanel.add(instructions1);
    //    instructionsPanel.add(instructions2);
        hamperPanel.add(maleLabel);
        hamperPanel.add(maleInput);
        hamperPanel.add(femaleLabel);
        hamperPanel.add(femaleInput);
        hamperPanel.add(childO8Label);
        hamperPanel.add(childO8Input);
        hamperPanel.add(childU8Label);
        hamperPanel.add(childU8Input);
        submitPanel.add(addHamper);
        submitPanel.add(createHampers);

        this.add(headerPanel, BorderLayout.PAGE_START);
       // this.add(instructionsPanel, BorderLayout.WEST);
        this.add(hamperPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }

    /**
     * Function to perform the necessary actions when the user interacts with the buttons 
     * on the GUI. It will read in the data entered into the GUI, validate the information, 
     * and either allow them to enter another hamper or submit to create the hampers requested.
     * @params event parameter is an event created by the user when clicking a button on the GUI
     */
    public void actionPerformed(ActionEvent event){
        numAdultMales = maleInput.getText();
        numAdultFemales = femaleInput.getText();
        numChildO8 = childO8Input.getText();
        numChildU8 = childU8Input.getText();

        //validate the input
        if(validateInput()){

            // add data to the hamper request ArrayList
            int[] hamper = {adultMales, adultFemales, childU8, childO8};
            hamperRequests.add(hamper);

            //check which button was pressed
            if (event.getSource() == createHampers){
                JOptionPane.showMessageDialog(this, "Your hamper request is being created.");
                //this.setVisible(false);
           
                // testing storage of elements
                // for(int[] arr : hamperRequests){
                //     for (int num : arr){
                //         System.out.print(num);
                //         System.out.print("\\");
                //     }
                //     System.out.println();
                // }

                //create the hamper request
                if (hamperRequestToCreate == null){
                    hamperRequestToCreate = new HamperRequest(hamperRequests);
                    hamperRequests.clear();
                } else{
                    hamperRequestToCreate.addHampers(hamperRequests);
                    hamperRequests.clear();
                }

                hamperRequestToCreate.createHampers();

                JOptionPane.showMessageDialog(this, "The hamper request has been processed. Please review the text file output. If you wish to add another hamper request, please do so. Otherwise, close the Hamper Request window to terminate the program.");
                //this.setVisible(true);
            }

            // } else if(event.getSource() == addHamper){
            //     //here we add another hamper to the request but we dont actually need to do anything
            // }
        }
    }

    public void mouseClicked(MouseEvent event){

    }

    public void mouseEntered(MouseEvent event){

    }

    public void mouseExited(MouseEvent event){

    }

    public void mousePressed(MouseEvent event){

    }

    public void mouseReleased(MouseEvent event){

    }

    /**
     * Validates the user's input into the GUI. The function tests if a field 
     * was given a valid non-negative integer, or was left blank in which case 
     * a zero is assumed. The function provides a message to the user when 
     * invalid input is provided, prompting them to correct the input.
     * @return boolean value indicating if the input is valid (true) or not valid (false)
     */
    public boolean validateInput(){

        boolean allInputValid = true;

        //substitute in zero where the field was left blank
        try{
            if (numAdultMales.isEmpty() == true){
                adultMales = 0;
            } else{
                adultMales = Integer.parseInt(numAdultMales);
            }

            if (numAdultFemales.isEmpty() == true){
                adultFemales = 0;
            } else{
                adultFemales = Integer.parseInt(numAdultFemales);
            }

            if (numChildO8.isEmpty() == true){
                childO8 = 0;
            } else{
                childO8 = Integer.parseInt(numChildO8);
            }

            if (numChildU8.isEmpty() == true){
                childU8 = 0;
            } else{
                childU8 = Integer.parseInt(numChildU8);
            }

        } catch (Exception e){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, "Please enter integer values for all fields.");
        }

        //Check if all numbers in input are 0
        if(adultMales == 0 && adultFemales == 0 && childO8 == 0 && childU8 == 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, "Please enter at least 1 person for the hamper.");
        }

        //check if any numbers are negative
        if(adultMales < 0 || adultFemales < 0 || childO8 < 0 || childU8 < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, "Please enter positive values only.");
        }

        //check that there is a max of 10 family members in the hamper
        if((adultMales + adultFemales + childO8 + childU8) > 10){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, "Please enter no more than 10 family members per hamper.");
        }

        return allInputValid;
    }

    public static void main(String args[]) {
        if (!DatabaseReader.initializeConnection()) {
            System.out.println("Connection failed.");
            System.exit(0);
        }
        EventQueue.invokeLater(() -> {
        new GUIHamperSystem().setVisible(true);
        });
        DatabaseReader.close();
    }
}
