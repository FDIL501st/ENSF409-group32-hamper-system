package edu.ucalgary.ensf409;
/**
 * @since 1.0
 * @version 1.2
 */
public class AdultMale extends Person {
    private static double grains;
    private static double veggies;
    private static double protiens;
    private static double others;
    private static double calories;
    
    public AdultMale(double percentGrain, double percentVeggies, 
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

    public static void setGrains(double grains) {
        AdultMale.grains = grains;
    }

    public static double getVeggies() {
        return veggies;
    }

    public static void setVeggies(double veggies) {
        AdultMale.veggies = veggies;
    }

    public static double getProtiens() {
        return protiens;
    }

    public static void setProtiens(double protiens) {
        AdultMale.protiens = protiens;
    }

    public static double getOthers() {
        return others;
    }

    public static void setOthers(double others) {
        AdultMale.others = others;
    }

    public static double getCalories() {
        return calories;
    }

    public static void setCalories(double calories) {
        AdultMale.calories = calories;
    }
    
}
