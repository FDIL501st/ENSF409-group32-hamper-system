package Tests;

import edu.ucalgary.ensf409.*;

import static org.junit.Assert.*;
import org.junit.*;

public class OrderFormTests {
    
    OrderForm form = new OrderForm();
        
         ArrayList<String>[] hamper1 = new ArrayList[2];
         for (int i = 0; i < 2; i++) {
             hamper1[i] = new ArrayList<String>();
         }
         hamper1[0].add("1");
         hamper1[1].add("Cucumber, 3-pack");
         hamper1[0].add("4");
         hamper1[1].add("Oat Meal, 12-pack");
         hamper1[0].add("12");
         hamper1[1].add("Chicken Breast, 12 oz");
         hamper1[0].add("96");
         hamper1[1].add("Avacado, dozen");
         hamper1[0].add("111");
         hamper1[1].add("Avacado, dozen");
         hamper1[0].add("109");
         hamper1[1].add("Tomato, dozen");
         hamper1[0].add("2");
         hamper1[1].add("Ground Beef, 1 lb");
         
         ArrayList<String>[] hamper2 = new ArrayList[2];
         for (int i = 0; i < 2; i++) {
             hamper2[i] = new ArrayList<String>();
         }
         hamper2[0].add("3");
         hamper2[1].add("Lettuce, head");
         hamper2[0].add("17");
         hamper2[1].add("Oat Meal, 12-pack");
         hamper2[0].add("38");
         hamper2[1].add("Chicken Wings, 2 dozen");
         hamper2[0].add("42");
         hamper2[1].add("Avacado, dozen");
         hamper2[0].add("90");
         hamper2[1].add("Peach, dozen");
         hamper2[0].add("60");
         hamper2[1].add("Tomato, dozen");
         hamper2[0].add("112");
         hamper2[1].add("Ground Beef, 2 lbs");
         
        @Test
        public void testOrderFormCreated() {
            
            form.createForm(hamper1, hamper2);

            boolean expected = true;
            boolean actual = form.getTextCheck;

            assertEquals("File was not successfully created", expected, actual);
        }
        
        @Test
        public void testReportShortage() {
            
            form.reportShortage();
            
            boolean expected = true;
            boolean actual = form.reportShortage;

            assertEquals("File was not successfully created", expected, actual);
        }
}
