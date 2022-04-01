package Tests;

import edu.ucalgary.ensf409.*;

import static org.junit.Assert.*;
import org.junit.*;

public class InheritancePersonTests {
    //All the tests also check if the functions can be statically called
    AdultMale adultMale;
    AdultFemale adultFemale;
    ChildOverEight childOverEight;
    ChildUnderEight childUnderEight;
    @Before
    public void setUp() {
        adultMale = new AdultMale(5, 25, 30, 40, 10000);
        adultFemale = new AdultFemale(10,20,30,40,10000);
        childOverEight = new ChildOverEight(15, 15, 35, 35, 10_000);
        childUnderEight = new ChildUnderEight(3, 2, 5, 90, 10_000);
    }
    
    @Test
    public void AdultFemaleGettersTest() {
        // Tests if getters return the correct value
        double expected = 1000;
        double actual = AdultFemale.getGrains();
        assertEquals("Expected grains intake to be 1000.",expected, actual, 0.0001);

        expected = 2000;
        actual = AdultFemale.getVeggies();
        assertEquals("Expected veggies intake to be 2000.", expected, actual, 0.0001);

        expected = 3000;
        actual = AdultFemale.getProtiens();
        assertEquals("Expected protiens intake to be 3000.", expected, actual, 0.0001);

        expected = 4000;
        actual = AdultFemale.getOthers();
        assertEquals("Expected others intake to be 4000.", expected, actual, 0.0001);

        expected = 10000;
        actual = AdultFemale.getCalories();
        assertEquals("Expected total calorie intake to be 10 000.", expected, actual, 0.0001);
    }

    @Test
    public void AdultMaleGettersTest() {
        // Tests if AdultMale getters return correct value
        double expected = 10_000;
        double actual = AdultMale.getCalories();
        assertEquals("Expected total calorie intake to be 10 000.", expected, actual, 0.0001);

        expected = 0.05*10_000;
        actual = AdultMale.getGrains();
        assertEquals("Expected grain intake to be 500.", expected, actual, 0.0001);

        expected = 0.25*10_000;
        actual = AdultMale.getVeggies();
        assertEquals("Expected veggie intake to be 2500.", expected, actual, 0.0001);

        expected = 0.3*10_000;
        actual = AdultMale.getProtiens();
        assertEquals("Expected veggie intake to be 3000.", expected, actual, 0.0001);

        expected = 0.4*10_000;
        actual = AdultMale.getOthers();
        assertEquals("Expected veggie intake to be 4000.", expected, actual, 0.0001);
    }
    @Test
    public void ChildOverEightGettersTest() {
        // Tests ChildUnderEight getters return correct value
        double expected = 10_000;
        double actual = ChildOverEight.getCalories();
        assertEquals("Expected total calorie intake to be 10 000.", expected, actual, 0.0001);

        expected = 0.15*10_000;
        actual = ChildOverEight.getGrains();
        assertEquals("Expected grain intake to be 300.", expected, actual, 0.0001);

        expected = 0.15*10_000;
        actual = ChildOverEight.getVeggies();
        assertEquals("Expected veggie intake to be 1500.", expected, actual, 0.0001);

        expected = 0.35*10_000;
        actual = ChildOverEight.getProtiens();
        assertEquals("Expected veggie intake to be 3500.", expected, actual, 0.0001);

        expected = 0.35*10_000;
        actual = ChildOverEight.getOthers();
        assertEquals("Expected veggie intake to be 3500.", expected, actual, 0.0001);
    }

    @Test
    public void ChildUnderEightGettersTest() {
        // Tests ChildUnderEight getters return correct value
        double expected = 10_000;
        double actual = ChildUnderEight.getCalories();
        assertEquals("Expected total calorie intake to be 10 000.", expected, actual, 0.0001);

        expected = 0.03*10_000;
        actual = ChildUnderEight.getGrains();
        assertEquals("Expected grain intake to be 300.", expected, actual, 0.0001);

        expected = 0.02*10_000;
        actual = ChildUnderEight.getVeggies();
        assertEquals("Expected veggie intake to be 200.", expected, actual, 0.0001);

        expected = 0.05*10_000;
        actual = ChildUnderEight.getProtiens();
        assertEquals("Expected veggie intake to be 500.", expected, actual, 0.0001);

        expected = 0.90*10_000;
        actual = ChildUnderEight.getOthers();
        assertEquals("Expected veggie intake to be 9000.", expected, actual, 0.0001);
    }

    @Test
    public void AdultMaleSettersTest() {
        double expected = 500;
        AdultMale.setCalories(expected);
        double actual = AdultMale.getCalories();
        assertEquals("Expected calorie to be set to 500.", expected, actual, 0.001);
        
        AdultMale.setGrains(expected);
        actual = AdultMale.getGrains();
        assertEquals("Expected grains to be set to 500.", expected, actual, 0.001);

        AdultMale.setVeggies(expected);
        actual = AdultMale.getVeggies();
        assertEquals("Expected veggies to be set to 500.", expected, actual, 0.001);

        AdultMale.setProtiens(expected);
        actual = AdultMale.getProtiens();
        assertEquals("Expected protiens to be set to 500.", expected, actual, 0.001);

        AdultMale.setOthers(expected);
        actual = AdultMale.getOthers();
        assertEquals("Expected others to be set to 500.", expected, actual, 0.001);
    }

    @Test
    public void AdultFemaleSettersTest() {
        double expected = 500;
        AdultFemale.setCalories(expected);
        double actual = AdultFemale.getCalories();
        assertEquals("Expected calorie to be set to 500.", expected, actual, 0.001);
        
        AdultFemale.setGrains(expected);
        actual = AdultFemale.getGrains();
        assertEquals("Expected grains to be set to 500.", expected, actual, 0.001);

        AdultFemale.setVeggies(expected);
        actual = AdultFemale.getVeggies();
        assertEquals("Expected veggies to be set to 500.", expected, actual, 0.001);

        AdultFemale.setProtiens(expected);
        actual = AdultFemale.getProtiens();
        assertEquals("Expected protiens to be set to 500.", expected, actual, 0.001);

        AdultFemale.setOthers(expected);
        actual = AdultFemale.getOthers();
        assertEquals("Expected others to be set to 500.", expected, actual, 0.001);
    }

    @Test
    public void ChildOverEightSettersTest() {
        double expected = 500;
        ChildOverEight.setCalories(expected);
        double actual = ChildOverEight.getCalories();
        assertEquals("Expected calorie to be set to 500.", expected, actual, 0.001);
        
        ChildOverEight.setGrains(expected);
        actual = ChildOverEight.getGrains();
        assertEquals("Expected grains to be set to 500.", expected, actual, 0.001);

        ChildOverEight.setVeggies(expected);
        actual = ChildOverEight.getVeggies();
        assertEquals("Expected veggies to be set to 500.", expected, actual, 0.001);

        ChildOverEight.setProtiens(expected);
        actual = ChildOverEight.getProtiens();
        assertEquals("Expected protiens to be set to 500.", expected, actual, 0.001);

        ChildOverEight.setOthers(expected);
        actual = ChildOverEight.getOthers();
        assertEquals("Expected others to be set to 500.", expected, actual, 0.001);
    }

    @Test
    public void ChildUnderEightSettersTest() {
        double expected = 500;
        ChildUnderEight.setCalories(expected);
        double actual = ChildUnderEight.getCalories();
        assertEquals("Expected calorie to be set to 500.", expected, actual, 0.001);
        
        ChildUnderEight.setGrains(expected);
        actual = ChildUnderEight.getGrains();
        assertEquals("Expected grains to be set to 500.", expected, actual, 0.001);

        ChildUnderEight.setVeggies(expected);
        actual = ChildUnderEight.getVeggies();
        assertEquals("Expected veggies to be set to 500.", expected, actual, 0.001);

        ChildUnderEight.setProtiens(expected);
        actual = ChildUnderEight.getProtiens();
        assertEquals("Expected protiens to be set to 500.", expected, actual, 0.001);

        ChildUnderEight.setOthers(expected);
        actual = ChildUnderEight.getOthers();
        assertEquals("Expected others to be set to 500.", expected, actual, 0.001);
    }

    @Test
    public void ConstructorsThrowExceptionWhenPercentIntakeNot100() {
        //Test exceptions thrown during constructors when first 4 arguments don't add to 100
        boolean exceptionThrown = false;
        try {
            AdultMale adultM = new AdultMale(5, 5, 5, 5, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultFemale adultF = new AdultFemale(5, 100, 5, 5, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildOverEight childOEight = new ChildOverEight(0, 99, 0, 0, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildUnderEight childUEight = new ChildUnderEight(5, 35, 33, 12, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.", exceptionThrown);
    }

    @Test
    public void ConstructorThrowExceptionWhenNegativeArguments() {
        //Test exceptions thrown during constructors when some arguments are negative
        boolean exceptionThrown = false;
        try {
            AdultMale adultM = new AdultMale(-10, 100, 5, 5, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultFemale adultF = new AdultFemale(90, -100, 5, 5, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildOverEight childOEight = new ChildOverEight(0, 99, 1, 0, -10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildUnderEight childUEight = new ChildUnderEight(34, 33, -33, 66, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.()", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildUnderEight childUEight = new ChildUnderEight(32, 35, 33, -12, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected IllegalArugmentException to be throw.", exceptionThrown);
    }

    @Test
    public void AdultFemaleSettersThrowExceptionForNegativeArguement() {
        // Tests IllegalArgumentException is thrown when setters are given a negative number
        boolean exceptionThrown = false;
        try {
            AdultFemale.setCalories(-1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setCalories)", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultFemale.setGrains(-9);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setGrains)", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultFemale.setVeggies(-9);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setVeggies)", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultFemale.setProtiens(-100);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setProtiens)", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultFemale.setOthers(-0.1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setOthers)", exceptionThrown);
    }

    @Test
    public void AdultMaleSettersThrowExceptionForNegativeArguement() {
        // Tests IllegalArgumentException is thrown when setters are given a negative number
        boolean exceptionThrown = false;
        try {
            AdultMale.setCalories(-1.7);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setCalories)", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultMale.setGrains(-90);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setGrains)", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultMale.setVeggies(-94);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setVeggies)", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultMale.setProtiens(-100);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setProtiens)", exceptionThrown);

        exceptionThrown = false;
        try {
            AdultMale.setOthers(-0.1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setOthers)", exceptionThrown);
    }

    @Test
    public void ChildUnderEightSettersThrowExceptionForNegativeArguement() {
        // Tests IllegalArgumentException is thrown when setters are given a negative number
        boolean exceptionThrown = false;
        try {
            ChildUnderEight.setCalories(-1.7);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setCalories)", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildUnderEight.setGrains(-90);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setGrains)", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildUnderEight.setVeggies(-94);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setVeggies)", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildUnderEight.setProtiens(-100);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setProtiens)", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildUnderEight.setOthers(-0.1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setOthers)", exceptionThrown);
    }

    @Test
    public void ChildOverEightSettersThrowExceptionForNegativeArguement() {
        // Tests IllegalArgumentException is thrown when setters are given a negative number
        boolean exceptionThrown = false;
        try {
            ChildOverEight.setCalories(-1.7);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setCalories)", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildOverEight.setGrains(-90);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setGrains)", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildOverEight.setVeggies(-94);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setVeggies)", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildOverEight.setProtiens(-100);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setProtiens)", exceptionThrown);

        exceptionThrown = false;
        try {
            ChildOverEight.setOthers(-0.1);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Expected exception to be thrown.(setOthers)", exceptionThrown);
    }
}
