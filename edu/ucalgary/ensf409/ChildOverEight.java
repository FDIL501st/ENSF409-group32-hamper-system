/**
 * <h1>ChildOverEight</h1>
 * Project for ENSF 409
 * <p>
 * @author Adem Soufi <a href="mailto:adem.soufi@ucalgary.ca">adem.soufi@ucalgary.ca</a> | UCID: 30101252
 * @author Fadil Husain <a href="mailto:fadil.husain@ucalgary.ca">fadil.husain@ucalgary.ca</a> | UCID: 30113409
 * @author Saman Hosseini <a href="mailto:saman.hosseini@ucalgary.ca">saman.hosseini@ucalgary.ca</a> | UCID: 30092208
 * @author Tanvir Haer <a href="mailto:tanvir.haer@ucalgary.ca">tanvir.haer@ucalgary.ca</a> | UCID: 30039188
 * @version 1.3
 * @since 1.0
 */

package edu.ucalgary.ensf409;

public class ChildOverEight extends Person {

    // Member Variables
    private static double grains;
    private static double veggies;
    private static double proteins;
    private static double others;
    private static double calories;

    /**
     * Constructor to set the caloric needs
     * @param percentGrain is the percentage of grain calories needed by child over 8
     * @param percentVeggies is the percentage of fruits and veggies calories needed by child over 8
     * @param percentProteins is the percentage of protein calories needed by child over 8
     * @param percentOther is the percentage of other calories needed by child over 8
     * @param Calories is the total number of calories needed by child over 8
     * @throws IllegalArgumentException is an exception for when the arguments to the constructor are invalid
     */
    public ChildOverEight(double percentGrain, double percentVeggies, 
    double percentProteins, double percentOther, double Calories) 
    throws IllegalArgumentException {
        //Call the Person constructor
        super(percentGrain, percentVeggies, percentProteins, percentOther, Calories);
        //Using getters, copy values from the Person object
        setGrains(grain);
        setVeggies(veggie);
        setProteins(protein);
        setOthers(other);
        setCalories(calorie);
    }

    /**
     * Getter for the amount of grain calories needed.
     * @return double value of the amount of grain calories needed
     */
    public static double getGrains() {
        return grains;
    }

    /**
     * Setter for the amount of grain calories needed
     * @param grains is the amount of grain calories needed
     * @throws IllegalArgumentException is an exception for when the argument is invalid
     */
    public static void setGrains(double grains) throws IllegalArgumentException{
        checkNotNegative(grains);
        ChildOverEight.grains = grains;
    }

    /**
     * Getter for the amount of fruits and veggies calories needed.
     * @return double value of the amount of fruits and veggies calories needed
     */
    public static double getVeggies() {
        return veggies;
    }

    /**
     * Setter for the amount of fruits and veggies calories needed
     * @param veggies is the amount of fruits and veggies calories needed
     * @throws IllegalArgumentException is an exception for when the argument is invalid
     */
    public static void setVeggies(double veggies) throws IllegalArgumentException{
        checkNotNegative(veggies);
        ChildOverEight.veggies = veggies;
    }

    /**
     * Getter for the amount of protein calories needed.
     * @return double value of the amount of protein calories needed
     */
    public static double getProteins() {
        return proteins;
    }

    /**
     * Setter for the amount of protein calories needed
     * @param proteins is the amount of protein calories needed
     * @throws IllegalArgumentException is an exception for when the argument is invalid
     */
    public static void setProteins(double proteins) throws IllegalArgumentException{
        checkNotNegative(proteins);
        ChildOverEight.proteins = proteins;
    }
    
    /**
     * Getter for the amount of other calories needed.
     * @return double value of the amount of other calories needed
     */
    public static double getOthers() {
        return others;
    }

    /**
     * Setter for the amount of other calories needed
     * @param others is the amount of other calories needed
     * @throws IllegalArgumentException is an exception for when the argument is invalid
     */
    public static void setOthers(double others) throws IllegalArgumentException{
        checkNotNegative(others);
        ChildOverEight.others = others;
    }

    /**
     * Getter for the amount of total calories needed.
     * @return double value of the amount of total calories needed
     */
    public static double getCalories() {
        return calories;
    }

    /**
     * Setter for the amount of total calories needed
     * @param calories is the amount of total calories needed
     * @throws IllegalArgumentException is an exception for when the argument is invalid
     */
    public static void setCalories(double calories) throws IllegalArgumentException{
        checkNotNegative(calories);
        ChildOverEight.calories = calories;
    }
    
}
