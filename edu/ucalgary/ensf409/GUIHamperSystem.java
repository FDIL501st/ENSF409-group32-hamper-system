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

    private JLabel instructions;
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


    public GUIHamperSystem(){
        super("Create a Hamper Request");
        setupGUI();
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupGUI(){

        instructions = new JLabel("Please enter the numbers of the types of people for this hamper as a digit e.g. 2. ");
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

        addHamper = new JButton("Add another Hamper Request");
        addHamper.addActionListener(this);

        createHampers = new JButton("Create Hampers");
        createHampers.addActionListener(this);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        JPanel hamperPanel = new JPanel();
        hamperPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        headerPanel.add(instructions);
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

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(hamperPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }

    public void actionPerformed(ActionEvent event){
        numAdultMales = maleInput.getText();
        numAdultFemales = femaleInput.getText();
        numChildO8 = childO8Input.getText();
        numChildU8 = childU8Input.getText();

        //validate the input
        if(validateInput()){

            // add data to the hamper request ArrayList
            int[] hamper = {adultMales, adultFemales, childO8, childU8};
            hamperRequests.add(hamper);

            //check which button was pressed
            if (event.getSource() == createHampers){
                JOptionPane.showMessageDialog(this, "Your hamper request is being created.");
                //start the calculation process here
           
                // testing storage of elements
                for(int[] arr : hamperRequests){
                    for (int num : arr){
                        System.out.print(num);
                        System.out.print("\\");
                    }
                    System.out.println();
                }

            } else if(event.getSource() == addHamper){
                //here we add another hamper to the request

            }
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

    // check that input is valid

    public boolean validateInput(){

        //sub in zero where the field was left blank

        boolean allInputValid = true;

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

        //check if any numbers are negative

        if(adultMales < 0 || adultFemales < 0 || childO8 < 0 || childU8 < 0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, "Please enter positive values only.");
        }

        return allInputValid;
    }



    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
        new GUIHamperSystem().setVisible(true);
        });
    }
}