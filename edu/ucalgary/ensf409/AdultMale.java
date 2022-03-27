package edu.ucalgary.ensf409;

public class AdultMale extends Person {
    public AdultMale(int percentGrain, int percentVeggies, 
    int percentProtiens, int percentOther, int Calories) 
    throws IllegalArgumentException {
        //Call the Person constructor
        super(percentGrain, percentVeggies, percentProtiens, percentOther, Calories);
    }
}
