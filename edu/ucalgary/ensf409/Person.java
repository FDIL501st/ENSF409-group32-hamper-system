package edu.ucalgary.ensf409;

/**
 * <h1>Person</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.5
 * @since 1.0
 */

public abstract class Person {
    protected double grain;
    protected double veggie;
    protected double protein;
    protected double other;
    protected double calorie;

    protected Person(double percentGrain, double percentVeggies, 
                double percentProteins, double percentOther, double TotalCalories) 
                throws IllegalArgumentException{
        
         // Add a check that the percents add up to 100
        if (percentGrain + percentVeggies + percentProteins + percentOther != 100) {
            throw new IllegalArgumentException("Calorie percentage needs must add up to 100%.");
        }
        // Add a check that each argument is positive
        if (percentGrain < 0) {
            throw new IllegalArgumentException("Can't have negative percent grain intake.");
        }
        if (percentVeggies < 0) {
            throw new IllegalArgumentException("Can't have negative percent veggie intake.");
        }
        if (percentProteins < 0) {
            throw new IllegalArgumentException("Can't have negative percent protein intake.");
        }
        if (percentOther < 0) {
            throw new IllegalArgumentException("Can't have negative percent other intake.");
        }
        if (TotalCalories < 0) {
            throw new IllegalArgumentException("Can't have negative calorie intake.");
        }
        calorie = TotalCalories;
        grain = (percentGrain/100)*TotalCalories;
        veggie = (percentVeggies/100)*TotalCalories;
        protein = (percentProteins/100)*TotalCalories;
        other = (percentOther/100)*TotalCalories;
    }
    // Above assumes insert values
    // So access database from somewhere before creating this object  

    // Throws IllegalArguementException if number is negative
    protected static void checkNotNegative(double number) throws IllegalArgumentException{
        if (number < 0) {
            throw new IllegalArgumentException("Negative value not allowed.");
        }
    }
}
