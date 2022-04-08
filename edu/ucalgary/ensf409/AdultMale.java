package edu.ucalgary.ensf409;
/**
 * @since 1.0
 * @version 1.3
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
        setProteins(protien);
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
        return protiens;
    }

    public static void setProteins(double protiens) throws IllegalArgumentException{
        checkNotNegative(protiens);
        AdultMale.protiens = protiens;
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
