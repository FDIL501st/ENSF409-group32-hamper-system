package edu.ucalgary.ensf409;
/**
 * @since 1.0
 * @version 1.2
 */
public class ChildOverEight extends Person {
    private static double grains;
    private static double veggies;
    private static double protiens;
    private static double others;
    private static double calories;
    
    public ChildOverEight(double percentGrain, double percentVeggies, 
    double percentProtiens, double percentOther, double Calories) 
    throws IllegalArgumentException {
        //Call the Person constructor
        super(percentGrain, percentVeggies, percentProtiens, percentOther, Calories);
    }

    public static double getGrains() {
        return grains;
    }

    public static void setGrains(double grains) {
        ChildOverEight.grains = grains;
    }

    public static double getVeggies() {
        return veggies;
    }

    public static void setVeggies(double veggies) {
        ChildOverEight.veggies = veggies;
    }

    public static double getProtiens() {
        return protiens;
    }

    public static void setProtiens(double protiens) {
        ChildOverEight.protiens = protiens;
    }

    public static double getOthers() {
        return others;
    }

    public static void setOthers(double others) {
        ChildOverEight.others = others;
    }

    public static double getCalories() {
        return calories;
    }

    public static void setCalories(double calories) {
        ChildOverEight.calories = calories;
    }
    
}
