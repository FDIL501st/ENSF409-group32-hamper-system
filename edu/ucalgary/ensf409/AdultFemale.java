package edu.ucalgary.ensf409;
/**
 * @since 1.0
 * @version 1.2
 */
public class AdultFemale extends Person{
    private static double grains;
    private static double veggies;
    private static double protiens;
    private static double others;
    private static double calories;
    
    public AdultFemale(double percentGrain, double percentVeggies, 
    double percentProtiens, double percentOther, double Calories) 
    throws IllegalArgumentException {
        //Create a Person object
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
        AdultFemale.grains = grains;
    }

    public static double getVeggies() {
        return veggies;
    }

    public static void setVeggies(double veggies) {
        AdultFemale.veggies = veggies;
    }

    public static double getProtiens() {
        return protiens;
    }

    public static void setProtiens(double protiens) {
        AdultFemale.protiens = protiens;
    }

    public static double getOthers() {
        return others;
    }

    public static void setOthers(double others) {
        AdultFemale.others = others;
    }

    public static double getCalories() {
        return calories;
    }

    public static void setCalories(double calories) {
        AdultFemale.calories = calories;
    }
    
}
