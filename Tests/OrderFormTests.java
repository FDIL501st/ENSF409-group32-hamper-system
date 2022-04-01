package Tests;

import edu.ucalgary.ensf409.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class OrderFormTests {
    
        OrderForm form = new OrderForm();
        
        ArrayList<String[]> hamper1;
         
        String[] apple = {"1", "Apples", "30", "30", "10", "30", "10"};
        String[] chicken = {"2", "Chicken", "10", "40", "40", "10", "10"};
        String[] pie = {"3", "Pie", "10", "20", "30", "40", "10"};
        String[] yam = {"4", "Yam", "20", "50", "10", "20", "10"};
        
        ArrayList<String[]> hamper2;
        
        String[] pear = {"8", "Pears", "30", "30", "20", "20", "10"};
        String[] beef = {"7", "Chicken", "10", "40", "40", "10", "10"};
        String[] cake = {"6", "Cake", "10", "20", "20", "50", "10"};
        String[] potato = {"5", "Potato", "20", "60", "10", "10", "10"};
        
        @Before
        public void setUp() {
            hamper1 = new ArrayList<>();
            hamper1.add(apple);
            hamper1.add(chicken);
            hamper1.add(pie);
            hamper1.add(yam);
            
            hamper2 = new ArrayList<>();
            hamper2.add(pear);
            hamper2.add(beef);
            hamper2.add(cake);
            hamper2.add(potato);
        }
        
        @Test
        public void testOrderFormCreated() {
            
            form.createForm(hamper1, hamper2);

            boolean expected = true;
            boolean actual = form.getTextCheck();

            assertEquals("File was not successfully created", expected, actual);
        }
        
        @Test
        public void testReportShortage() {
            
            form.reportShortage();
            
            boolean expected = true;
            boolean actual = form.reportShortage();

            assertEquals("File was not successfully created", expected, actual);
        }
}
