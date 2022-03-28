package edu.ucalgary.ensf409;
/**
 * @since 1.0
 * @version 1.2
 */
public class ChildUnderEight extends Person{
    private static double grains;
    private static double veggies;
    private static double protiens;
    private static double others;
    private static double calories;

    public ChildUnderEight(double percentGrain, double percentVeggies, 
    double percentProtiens, double percentOther, double Calories) 
    throws IllegalArgumentException {
        //Call the Person constructor
        super(percentGrain, percentVeggies, percentProtiens, percentOther, Calories);
    }
}
