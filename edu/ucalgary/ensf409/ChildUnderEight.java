package edu.ucalgary.ensf409;
/**
 * @since 1.0
 * @version 1.3
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
        //Using getters, copy values from the Person object
        setGrains(grain);
        setVeggies(veggie);
        setProtiens(protien);
        setOthers(other);
        setCalories(calorie);
    }

    public static double getGrains() {
        return grains;
    }

    public static void setGrains(double grains) throws IllegalArgumentException{
        checkNotNegative(grains);
        ChildUnderEight.grains = grains;
    }

    public static double getVeggies() {
        return veggies;
    }

    public static void setVeggies(double veggies) throws IllegalArgumentException{
        checkNotNegative(veggies);
        ChildUnderEight.veggies = veggies;
    }

    public static double getProtiens() {
        return protiens;
    }

    public static void setProtiens(double protiens) throws IllegalArgumentException{
        checkNotNegative(protiens);
        ChildUnderEight.protiens = protiens;
    }

    public static double getOthers() {
        return others;
    }

    public static void setOthers(double others) throws IllegalArgumentException{
        checkNotNegative(others);
        ChildUnderEight.others = others;
    }

    public static double getCalories() {
        return calories;
    }

    public static void setCalories(double calories) throws IllegalArgumentException{
        checkNotNegative(calories);
        ChildUnderEight.calories = calories;
    }
    
}
