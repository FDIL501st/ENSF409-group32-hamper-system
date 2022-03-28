package edu.ucalgary.ensf409;
/**
 * @since 1.0
 * @version 1.4
 */
public abstract class Person {
    protected double grain;
    protected double veggie;
    protected double protien;
    protected double other;
    protected double calorie;

    public Person(double percentGrain, double percentVeggies, 
                double percentProtiens, double percentOther, double TotalCalories) 
                throws IllegalArgumentException{
        
         // Add a check that the percents add up to 100
        if (percentGrain + percentVeggies + percentProtiens + percentOther != 100) {
            throw new IllegalArgumentException("Calorie percentage needs must add up to 100%.");
        }

        calorie = TotalCalories;
        grain = (percentGrain/100)*TotalCalories;
        veggie = (percentVeggies/100)*TotalCalories;
        protien = (percentProtiens/100)*TotalCalories;
        other = (percentOther/100)*TotalCalories;
    }
    // Above assumes insert values
    // So access database from somewhere before creating this object
  
}
