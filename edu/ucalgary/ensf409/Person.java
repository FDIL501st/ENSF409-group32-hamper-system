package edu.ucalgary.ensf409;

public abstract class Person {
    private static int grains;
    private static int veggies;
    private static int protiens;
    private static int others;
    private static int calories;

    public Person(int percentGrain, int percentVeggies, 
                int percentProtiens, int percentOther, int Calories) 
                throws IllegalArgumentException{
        
         // Add a check that the percents add up to 100
        if (percentGrain + percentVeggies + percentProtiens + percentOther != 100) {
            throw new IllegalArgumentException("Calorie percentage needs must add up to 100%.");
        }

        calories = Calories;
        grains = percentGrain*Calories;
        veggies = percentVeggies*Calories;
        protiens = percentProtiens*Calories;
        others = percentOther*Calories;
    }
    // Above assumes insert values
    // So access database from somewhere else

}
