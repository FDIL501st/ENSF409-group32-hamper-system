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

    private ArrayList<String[]> hamperFoodCombo = new ArrayList<String[]>();
    private Comparator<String[]> decsendingTotalCalories = new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            //Compare total calories provided by each food
            // Sort so that greater one comes first (returns negative)
            double o1Calories = totalFoodItemCalories(o1);
            double o2Calories = totalFoodItemCalories(o2);

            return Double.compare(o2Calories, o1Calories);
            //Does help to order from greatest to least total calories
        }
     };

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

    // REQUIRES TESTING

    public void calculateFoodCombos() {
        double[] neededCalories = {wholeGrainCalories, fruitsVeggiesCalories,
        proteinCalories, otherCalories};
        if (FoodInventory.checkShortage(neededCalories)) {
            // there is a shortage, so need to end here
            hamperFoodCombo = null;
            return;
        }

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
        hamper.pollLast();
        //double[] calorieRemain = new double[4];
        //calorieRemain[0] = checkRemainingGrain(hamper);
        //calorieRemain[1] = checkRemainingVeggie(hamper);
        //calorieRemain[2] = checkRemainingProtein(hamper);
        //calorieRemain[3] = checkRemainingOther(hamper);
        //Brute force less efficient option (time consuming)
        // Make all possible combination of food items from remaining inventory
        // Then check for each calorie type provided and match needed
        // Then make descicion of which to choose based off of lowest total calorie
        inventory.removeAll(hamper);    // remove all stuff from inventory that is in hamper
        ArrayList<String[]> remainingInventory = new ArrayList<>(inventory);
        // How to store test hampers? Best in a TreeSet with ascending calories of test hamper
        Comparator<ArrayList<String[]>> ascendingHamperCalories = new Comparator<ArrayList<String[]>>() {
            @Override
            public int compare(ArrayList<String[]> o1, ArrayList<String[]> o2) {
                Iterator<String[]> arrayListIterator = o1.iterator();
                double o1Calories = 0;
                while (arrayListIterator.hasNext()) {
                    o1Calories += totalFoodItemCalories(arrayListIterator.next());
                }
                arrayListIterator = o2.iterator();
                double o2Calories = 0;
                while (arrayListIterator.hasNext()) {
                    o2Calories += totalFoodItemCalories(arrayListIterator.next());
                }
                return Double.compare(o1Calories, o2Calories);
            }
        };
        TreeSet<ArrayList<String[]>> testRemainingCombos = new TreeSet<>(ascendingHamperCalories);
        
        testRemainingCombos.addAll(allPossibleCombos(remainingInventory));
        Iterator<ArrayList<String[]>> testCombosIterator = testRemainingCombos.iterator();
        while (testCombosIterator.hasNext()) {
            ArrayList<String[]> combo = testCombosIterator.next();
            // Because already ordered by lowest to highest total calorie, 
            // just need to find first combo that meets all requirements
            if (meetAllCaloricNeeds(hamper, combo)) {
                hamper.addAll(combo);
                //What gets added to hamper is the first one that meets all requirements
            }
        }
        hamperFoodCombo = new ArrayList<>(hamper);
        /*
        Iterator<String[]> foodsIterator= inventory.iterator();
        while (foodsIterator.hasNext()) {
            String[] info = foodsIterator.next();
            double x = totalFoodItemCalories(info);
            System.out.println(x);
        }
        */
    }
    //Below are 4 private methods that returns the difference in calories needed to fulful request and
    // current hamper contents
    private double checkRemainingGrain(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[2]);
        }
        // return the difference 
        return wholeGrainCalories - current;
    }

    private double checkRemainingVeggie(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[3]);
        }
        // return the difference 
        return fruitsVeggiesCalories - current;
    }

    private double checkRemainingProtein(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[4]);
        }
        // return the difference 
        return proteinCalories - current;
    }

    private double checkRemainingOther(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[5]);
        }
        // return the difference 
        return otherCalories - current;
    }
    // private method to calculate total calories a food provides
    //  this is done by summing up calories of each type
    private double totalFoodItemCalories(String[] foodItem) {
        return Double.parseDouble(foodItem[2])
        + Double.parseDouble(foodItem[3])
        + Double.parseDouble(foodItem[4])
        + Double.parseDouble(foodItem[5]);
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
            String[] e1 = array.get(0);
            e.add(e1);
            allCombos.add(e);

            e = new ArrayList<>();
            allCombos.add(e);

            return allCombos;
        }
        // Need to recurse but take out first element
        ArrayList<String[]> withoutFirstElement = new ArrayList<>(array);
        String[] firstElement = withoutFirstElement.remove(0);
        ArrayList<ArrayList<String[]>> returnedSets = allPossibleCombos(withoutFirstElement);
        Iterator<ArrayList<String[]>> setsIterator = returnedSets.iterator();
        while (setsIterator.hasNext()) {
            ArrayList<String[]> set = setsIterator.next();
            ArrayList<String[]> set2 = new ArrayList<>(set);
            
            set.add(firstElement); //possible set 1, element is added
            allCombos.add(set);

            allCombos.add(set2);   // possible set 2, element is not added
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
    public boolean meetAllCaloricNeeds(TreeSet<String[]> currentHamper, ArrayList<String[]> foodCombo) {
        TreeSet<String[]> testHamper = new TreeSet<>(decsendingTotalCalories);
        testHamper.addAll(currentHamper);
        testHamper.addAll(foodCombo);
        // Now check if not meet any requirements, if not meeting, return false
        if (checkRemainingGrain(testHamper) < 0) {
            return false;
        }
        if (checkRemainingVeggie(testHamper) < 0) {
            return false;
        }
        if (checkRemainingProtein(testHamper) < 0) {
            return false;
        }
        if (checkRemainingOther(testHamper) < 0) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        DatabaseReader.initializeConnection();
        FoodInventory foodInventory = new FoodInventory();
        FoodCalculator foodCalculator = new FoodCalculator(1, 1, 1, 1);
        //foodCalculator.calculateFoodCombos();
        DatabaseReader.close();
        ArrayList<String[]> array = new ArrayList<>(4);
        String[] e1 = {"hi"};
        String[] e2 = {"Fly"};
        String[] e3 = {"Kite"};
        String[] e4 = {"Night"};
        array.add(e1);
        array.add(e2);
        array.add(e3);
        array.add(e4);

        ArrayList<ArrayList<String[]>> c = foodCalculator.allPossibleCombos(array);
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < c.get(i).size(); j++) {
                System.out.print(c.get(i).get(j)[0] + "\t");
            }
            System.out.println();
        }
    }

}