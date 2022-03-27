package edu.ucalgary.ensf409;

public class ChildUnderEight extends Person{
    public ChildUnderEight(int percentGrain, int percentVeggies, 
    int percentProtiens, int percentOther, int Calories) 
    throws IllegalArgumentException {
        //Call the Person constructor
        super(percentGrain, percentVeggies, percentProtiens, percentOther, Calories);
    }
}
