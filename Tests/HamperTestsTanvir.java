import java.beans.Transient;

public class Tests{

    @Test
    public void hamperConstructorTest(){
        // Test that the hamper is constructed appropriately with the right numbers of people
        int expectedNumAdultMales = 3;
        int expectedNumAdultFemales = 1; 
        int expectedNumChildrenU8 = 0;
        int expectedNumChildrenO8 = 4;

        Hamper hamp = new Hamper(expectedNumAdultMales, expectedNumAdultFemales, expectedNumChildrenU8, expectedNumChildrenO8);

        int actualNumAdultMales = hamp.getNumAdultMales();
        int actualNumAdultFemales = hamp.getNumAdultFemales();
        int actualNumChildrenU8 = hamp.getNumAdultChildrenU8();
        int actualNumChildrenO8 = hamp.getNumAdultChildrenO8();

        assertEquals("Incorrect number of Adult Males", expectedNumAdultMales, actualNumAdultMales);
        assertEquals("Incorrect number of Adult Females", expectedNumAdultFemales, actualNumAdultFemales);
        assertEquals("Incorrect number of Children Under 8", expectedNumChildrenU8, actualNumChildrenU8);
        assertEquals("Incorrect number of Children Over 8", expectedNumChildrenO8, actualNumChildrenO8);
    }

    @Test
    public void hamperFoodCalculatorGetterTest() {
        // Test that a hamper returns a not null Food Calculator object
        Hamper hamp = new Hamper(1,1,1,1);
        FoodCalculator calc = hamp.getFoodCalculator();
        assertNotNull("The hamper did not create a FoodCalculator object", calc);
    }
}