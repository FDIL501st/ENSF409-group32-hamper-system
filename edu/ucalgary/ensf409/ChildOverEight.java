package edu.ucalgary.ensf409;

public class ChildOverEight extends Person {
    public ChildOverEight(int percentGrain, int percentVeggies, 
    int percentProtiens, int percentOther, int Calories) 
    throws IllegalArgumentException {
        //Call the Person constructor
        super(percentGrain, percentVeggies, percentProtiens, percentOther, Calories);
    }
}
