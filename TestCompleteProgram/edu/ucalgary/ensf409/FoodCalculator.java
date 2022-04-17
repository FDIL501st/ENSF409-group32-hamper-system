/**
 * <h1>FoodCalculator</h1>
 * Project for ENSF 409
 * <p>
 * @author Adem
 * @author Fadil Husain <a href="mailto:fadil.husain@ucalgary.ca">fadil.husain@ucalgary.ca</a> | UCID: 30113409
 * @author Sam
 * @author Tanvir Haer <a href="mailto:tanvir.haer@ucalgary.ca">tanvir.haer@ucalgary.ca</a> | UCID: 30039188
 * @version 1.6
 * @since 1.0
 */

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

    private ArrayList<String[]> hamperFoodCombo = new ArrayList<String[]>(); // optimum hamper combo storage variable

    /**
     * Constructor to set the numbers of types of people 
     * and calculate the numbers of calories needed for the hamper
     */
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

    /**
     * Getters for numbers of adult males, adult females, children over 8, and children under 8 in the hamper
     */
    public int getNumAdultMales() { return this.numAdultMales; }
    public int getNumAdultFemales() { return this.numAdultFemales; }
    public int getNumChildrenU8() { return this.numChildrenU8; }
    public int getNumChildrenO8() { return this.numChildrenO8; }

    /**
     * Getters for different types of calories needed for the hamper
     */
    public double getWholeGrainCalories() { return this.wholeGrainCalories; }
    public double getFruitsVeggiesCalories() { return this.fruitsVeggiesCalories; }
    public double getProteinCalories() { return this.proteinCalories; }
    public double getOtherCalories() { return this.otherCalories; }
    public double getTotalCalories() { return this.totalCalories; }

    /**
     * Getter for optimum Hamper Food Combo
     */
    public ArrayList<String[]> getHamperFoodCombo() { return this.hamperFoodCombo; }
    
    /**
     * Calculates the total number of whole grain calories needed for the hamper per day
     */
    public void calculateWholeGrainCalories(){

        double cals = numAdultMales * AdultMale.getGrains()
        + numAdultFemales * AdultFemale.getGrains()
        + numChildrenU8 * ChildUnderEight.getGrains()
        + numChildrenO8 * ChildOverEight.getGrains();
 
        this.wholeGrainCalories = cals;
    }

    /**
     * Calculates the total number of fruits/veggies calories needed for the hamper per day
     */
    public void calculateFruitsVeggiesCalories(){

        double cals = numAdultMales * AdultMale.getVeggies()
        + numAdultFemales*AdultFemale.getVeggies()
        + numChildrenU8 * ChildUnderEight.getVeggies()
        + numChildrenO8 * ChildOverEight.getVeggies();
    
        this.fruitsVeggiesCalories = cals;
    }

    /**
     * Calculates the total number of protein calories needed for the hamper per day
     */
    public void calculateProteinCalories(){

        double cals = numAdultMales*AdultMale.getProteins()
        + numAdultFemales * AdultFemale.getProteins()
        + numChildrenU8 * ChildUnderEight.getProteins()
        + numChildrenO8 * ChildOverEight.getProteins();

        this.proteinCalories = cals;
    }

    /**
     * Calculates the total number of other calories needed for the hamper per day
     */
    public void calculateOtherCalories(){
        double cals = numAdultMales*AdultMale.getOthers()
        + numAdultFemales * AdultFemale.getOthers()
        + numChildrenU8 * ChildUnderEight.getOthers()
        + numChildrenO8 * ChildOverEight.getOthers();

        this.otherCalories = cals;
    }

    /**
     * Calculates the total number of calories needed for the hamper per day
     */
    public void calculateTotalCalories(){
        double cals = numAdultMales * AdultMale.getCalories()
        + numAdultFemales * AdultFemale.getCalories()
        + numChildrenU8 * ChildUnderEight.getCalories()
        + numChildrenO8 * ChildOverEight.getCalories();

        this.totalCalories = cals;
    }

    // REQUIRES TESTING
    /**
     * Calculates the food combo for the hamper. 
     * Food combo calculated is the one with smallest excess.
     */
    public void calculateFoodCombos() {
        
        double[] neededCalories = {wholeGrainCalories, fruitsVeggiesCalories,
        proteinCalories, otherCalories};
        if (FoodInventory.checkShortage(neededCalories)) {
            // there is a shortage, so need to end here
            hamperFoodCombo = new ArrayList<>();
            // make hamperFoodCombo an empty arraylist
            return;
        }
        // find all possible combinations of inventory
        ArrayList<String[]> inventory = FoodInventory.getInventory();
        ArrayList<ArrayList<String[]>> testAllCombos = allPossibleCombos(inventory);
        Iterator<ArrayList<String[]>> allCombosIterator = testAllCombos.iterator();
        TreeMap<Double, ArrayList<String[]>> workingCombos = new TreeMap<>();
        // For every one that meets requirements, add to treemap
        // tree map will sort by total calories of a food item,used as key
        while (allCombosIterator.hasNext()) {
            ArrayList<String[]> combo = allCombosIterator.next();
            if (meetAllCaloricNeeds(combo)) {
                // Only add to working combos if meets all caloric requirements
                Double totalCalories = totalComboCalories(combo);
                workingCombos.put(totalCalories, combo);
            }
        }
        hamperFoodCombo = new ArrayList<>(workingCombos.ceilingEntry(0.0).getValue());
        // Returns combo with that has calories nearest to 0
        // nearest to 0 calories means combo with least calories overall
    }
    //Below are 4 private methods that returns the difference in calories needed to fulful request and
    // current hamper contents
    public double checkRemainingGrain(ArrayList<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[2]);
        }
        // return the difference 
        double difference = current - wholeGrainCalories;
        return difference;
    }

    public double checkRemainingVeggie(ArrayList<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[3]);
        }
        // return the difference 
        return current - fruitsVeggiesCalories;
    }

    public double checkRemainingProtein(ArrayList<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[4]);
        }
        // return the difference 
        return current - proteinCalories;
    }

    public double checkRemainingOther(ArrayList<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[5]);
        }
        // return the difference 
        return current - otherCalories;
    }
    /**
     * Calculates the total calories a food item provides.
     * This is the sum of all 4 types of calories the food provides.
     * @param foodItem the food item from available_food database
     * @return the total calories the food item provides.
     */
    public double totalFoodItemCalories(String[] foodItem) {
        return Double.parseDouble(foodItem[2])
        + Double.parseDouble(foodItem[3])
        + Double.parseDouble(foodItem[4])
        + Double.parseDouble(foodItem[5]);
    }
    /**
     * Calculates the total calories of a combination of food items.
     * This is the sum of the total caloires of each food item in the combination.
     * @param combo the food combination whose total calories to find
     * @return the total calories of the entire food combination
     */
    public double totalComboCalories(ArrayList<String[]> combo) {
        Iterator<String[]> arrayListIterator = combo.iterator();
            double comboCalories = 0;
            while (arrayListIterator.hasNext()) {
                comboCalories += totalFoodItemCalories(arrayListIterator.next());
            }
        return comboCalories;
    }
    /**
     * Essentially returns the power set of ArrayList provided.
     * This means all possible combinations, including an empty ArrayList.
     * @param array the array whose power set will be made
     * @return the power set of array
     * @implNote this is a recursive function
     */
    public ArrayList<ArrayList<String[]>> allPossibleCombos(ArrayList<String[]> array) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
        ArrayList<ArrayList<String[]>> allCombos = new ArrayList<>();
        // Recursive function that simulates choosing and not choosing an element to make a set
        if (array.size() == 1) {
            ArrayList<String[]> e = new ArrayList<>(1);
            // Possible set 1, has the element
            String[] e1 = array.get(0);
            e.add(e1);
            allCombos.add(e);
            // Possible set 2, does not have the element
            e = new ArrayList<>();
            allCombos.add(e);

            return allCombos;
        }
        // Need to recurse but take out first element
        // So can later decide to make 2 more sets, having it and not having it
        ArrayList<String[]> withoutFirstElement = new ArrayList<>(array);
        String[] firstElement = withoutFirstElement.remove(0);
        ArrayList<ArrayList<String[]>> returnedSets = allPossibleCombos(withoutFirstElement);
        Iterator<ArrayList<String[]>> setsIterator = returnedSets.iterator();
        while (setsIterator.hasNext()) {
            ArrayList<String[]> set = setsIterator.next();
            ArrayList<String[]> set2 = new ArrayList<>(set);
            
            set.add(firstElement); //possible set 1, element removed is added
            allCombos.add(set);

            allCombos.add(set2);   // possible set 2, element removed is not added
        }
        return allCombos;
    }
    /**
     * Checks to see if a hamper meets all requirements
     * @param currentHamper the current contents in the hamper
     * @param foodCombo the food combo to add to the currentHamper to make a test hamper 
     * to test if it meets all needs.
     * @return true if the test hamper meets all needs. False otherwise.
     */
    public boolean meetAllCaloricNeeds(ArrayList<String[]> foodCombo) {
        if (foodCombo.isEmpty()) {
            return false;
        }
        // Now check if not meet any requirements, if not meeting, return false
        if (checkRemainingGrain(foodCombo) < 0) {
            return false;
        }
        if (checkRemainingVeggie(foodCombo) < 0) {
            return false;
        }
        if (checkRemainingProtein(foodCombo) < 0) {
            return false;
        }
        if (checkRemainingOther(foodCombo) < 0) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        if (!DatabaseReader.initializeConnection()) {
             System.out.println("Unable to initialize connection.");
             System.exit(0);
         }
         FoodInventory foodInventory = new FoodInventory();
         Iterator<String[]> inventoryIterator = FoodInventory.getInventory().iterator();
         while (inventoryIterator.hasNext()) {
            String[] food = inventoryIterator.next();
             for (String s : food) {
                 System.out.print(s);
                System.out.print("\t");
             }
            System.out.println();
         }
         
        Hamper hamper = new Hamper(0, 0, 0, 1);
        FoodCalculator foodCalculator = hamper.getFoodCalculator();
         foodCalculator.calculateFoodCombos();
         System.out.println("Hamper combo:");
         ArrayList<String[]> hamperCombo = foodCalculator.getHamperFoodCombo();
        Iterator<String[]> hamperIterator = hamperCombo.iterator();
         while (hamperIterator.hasNext()) {
             String[] food = hamperIterator.next();
             for (String s : food) {
                 System.out.print(s);
                System.out.print("\t");
            }
             System.out.println();
         }
        
        FoodInventory.removeHamper(hamperCombo);
        FoodInventory.updateDatabase();
        DatabaseReader.close();
    }

}