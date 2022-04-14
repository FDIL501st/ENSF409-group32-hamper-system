package edu.ucalgary.ensf409;
/**
 * @since 1.0
 * @version 1.3
 */
public class AdultMale extends Person {
    private static double grains;
    private static double veggies;
    private static double proteins;
    private static double others;
    private static double calories;
    
    public AdultMale(double percentGrain, double percentVeggies, 
    double percentProteins, double percentOther, double Calories) 
    throws IllegalArgumentException {
        //Call the Person constructor
        super(percentGrain, percentVeggies, percentProteins, percentOther, Calories);
        //Using getters, copy values from the Person object
        setGrains(grain);
        setVeggies(veggie);
        setProteins(protein);
        setOthers(other);
        setCalories(calorie);
    }

    public static double getGrains() {
        return grains;
    }

    public static void setGrains(double grains) throws IllegalArgumentException{
        checkNotNegative(grains);
        AdultMale.grains = grains;
    }

    public static double getVeggies() {
        return veggies;
    }

    public static void setVeggies(double veggies) throws IllegalArgumentException{
        checkNotNegative(veggies);
        AdultMale.veggies = veggies;
    }

    public static double getProteins() {
        return proteins;
    }

    public static void setProteins(double proteins) throws IllegalArgumentException{
        checkNotNegative(proteins);
        AdultMale.proteins = proteins;
    }

    public static double getOthers() {
        return others;
    }

    public static void setOthers(double others) throws IllegalArgumentException{
        checkNotNegative(others);
        AdultMale.others = others;
    }

    public static double getCalories() {
        return calories;
    }

    public static void setCalories(double calories) throws IllegalArgumentException{
        checkNotNegative(calories);
        AdultMale.calories = calories;
    }
    
}
