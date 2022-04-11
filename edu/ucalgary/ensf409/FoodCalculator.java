package edu.ucalgary.ensf409;

import java.util.*;

public class FoodCalculator{
    private double wholeGrainCalories;
    private double fruitsVeggiesCalories;
    private double proteinCalories;
    private double otherCalories;
    private double totalCalories;

    private int numAdultMales;
    private int numAdultFemales;
    private int numChildrenU8;
    private int numChildrenO8;

    ArrayList<String[]> hamperFoodCombo = new ArrayList<String[]>();

    // Constructor
    public FoodCalculator(int numAdultMales, int numAdultFemales, int numChildrenU8, int numChildrenO8){
        this.numAdultMales = numAdultMales;
        this.numAdultFemales = numAdultFemales;
        this.numChildrenU8 = numChildrenU8;
        this.numChildrenO8 = numChildrenO8;

        calculateWholeGrainCalories();
        calculateFruitsVeggiesCalories();
        calculateProteinCalories();
        calculateOtherCalories();
        calculateTotalCalories();
    }

    //Getters for numbers of people
    public int getNumAdultMales() { return this.numAdultMales; }
    public int getNumAdultFemales() { return this.numAdultFemales; }
    public int getNumChildrenU8() { return this.numChildrenU8; }
    public int getNumChildrenO8() { return this.numChildrenO8; }

    //Getters for different types of calories
    public double getWholeGrainCalories() { return this.wholeGrainCalories; }
    public double getFruitsVeggiesCalories() { return this.fruitsVeggiesCalories; }
    public double getProteinCalories() { return this.proteinCalories; }
    public double getOtherCalories() { return this.otherCalories; }
    public double getTotalCalories() { return this.totalCalories; }

    //Getter for Hamper Food Combo
    public ArrayList<String[]> getHamperFoodCombo() { return this.hamperFoodCombo; }


    //Calculate the total number of whole grain calories needed
    public void calculateWholeGrainCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getGrains();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getGrains();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getGrains();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getGrains();
        }

        this.wholeGrainCalories = cals;

        //Calculations can be written as such
        // this.wholeGrainCalories = numAdultMales*AdultMale.getGrains
        // + numAdultFemales*AdultFemale.getGrains()
        // + numChildrenU8*ChildUnderEight.getGrains()
        // + numChildrenO8*ChildOverEight.getGrains();
    }

    //Calculate the total number of fruits/veggies calories needed
    public void calculateFruitsVeggiesCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getVeggies();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getVeggies();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getVeggies();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getVeggies();
        }

        this.fruitsVeggiesCalories = cals;
    }

    //Calculate the total number of protein calories needed
    public void calculateProteinCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getProteins();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getProteins();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getProteins();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getProteins();
        }

        this.proteinCalories = cals;
    }

    //Calculate the total number of other calories needed
    public void calculateOtherCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getOthers();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getOthers();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getOthers();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getOthers();
        }

        this.otherCalories = cals;
    }

    //Calculate the total number of calories needed
    public void calculateTotalCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getCalories();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getCalories();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getCalories();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getCalories();
        }

        this.totalCalories = cals;
    }

    // INCOMPLETE METHOD

    public void calculateFoodCombos() {
        double[] calories = {wholeGrainCalories, fruitsVeggiesCalories,
        proteinCalories, otherCalories};
        FoodInventory.checkShortage(calories);

        Comparator<String[]> decsendingTotalCalories = new Comparator<String[]>() {
           @Override
           public int compare(String[] o1, String[] o2) {
               //Compare total calories provided by each food
               // Sort so that greater one comes first (returns negative)
               double o1Calories = Double.parseDouble(o1[2])
               + Double.parseDouble(o1[3])
               + Double.parseDouble(o1[4])
               + Double.parseDouble(o1[5]);

               double o2Calories = Double.parseDouble(o2[2])
               + Double.parseDouble(o2[3])
               + Double.parseDouble(o2[4])
               + Double.parseDouble(o2[5]);

               return Double.compare(o2Calories, o1Calories);
               //Does help to order from greatest to least total calories
           }
        };

        TreeSet<String[]> inventory = new TreeSet<>(decsendingTotalCalories);
        Iterator<String[]> inventoryIterator = inventory.iterator();
        inventory.addAll(FoodInventory.getInventory());
        // Stored inventory in descending order of total calories a food provides
        TreeSet<String[]> hamper = new TreeSet<>(decsendingTotalCalories);

        //Loop through inventory from start to end
        // adding 1 item at a time then checking for surplus.
        //Quit loop when surplus in even one is detected
        while (inventoryIterator.hasNext()) {
            String[] foodItem = inventoryIterator.next();
            hamper.add(foodItem);
            double grainDifference = checkRemainingGrain(hamper);
            double veggieDifference = checkRemainingVeggie(hamper);
            double proteinDifference = checkRemainingProtein(hamper);
            double otherDifference = checkRemainingOther(hamper);
            if (grainDifference > 0) {
                break;
            }
            if (veggieDifference > 0) {
                break;
            }
            if (proteinDifference > 0) {
                break;
            }
            if (otherDifference > 0) {
                break;
            }
        }
        
        
        // Then remove last item from hamper
        // Check all remainings and see which food item would meet all needs
        
        //If there is no 1 item that meets all needs, then add the item that was removed
        // and do check for all remainings again
        //Keep looping this process until all calories are supluses

        /*
        Iterator<String[]> foodsIterator= inventory.iterator();
        while (foodsIterator.hasNext()) {
            String[] info = foodsIterator.next();
            double x = Double.parseDouble(info[2])
               + Double.parseDouble(info[3])
               + Double.parseDouble(info[4])
               + Double.parseDouble(info[5]);
            System.out.println(x);
        }
        */  

    }
    //Below are 4 private methods that returns the difference in calories between inventory and hamper
    private double checkRemainingGrain(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[2]);
        }
        // return the difference 
        return FoodInventory.getInventoryGrainCalories() - current;
    }

    private double checkRemainingVeggie(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[3]);
        }
        // return the difference 
        return FoodInventory.getInventoryVeggieCalories() - current;
    }

    private double checkRemainingProtein(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[4]);
        }
        // return the difference 
        return FoodInventory.getInventoryProteinCalories() - current;
    }

    private double checkRemainingOther(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[5]);
        }
        // return the difference 
        return FoodInventory.getInventoryOtherCalories() - current;
    }
    public static void main(String[] args) {
        DatabaseReader.initializeConnection();
        FoodInventory foodInventory = new FoodInventory();
        FoodCalculator foodCalculator = new FoodCalculator(1, 1, 1, 1);
        foodCalculator.calculateFoodCombos();
        DatabaseReader.close();
    }

}