import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void add(){
        System.out.println("Add Method");
        int actual = Calculator.add(2,5);
        assertEquals(7,actual,"Test Fail");

    }    @Test
    void testCase1(){
        System.out.println("Test Case 1");
//        fail("Not Implemented yet.");
        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);

    }    @Test
    void testCase2(){
        System.out.println("Test Case 2");
        assertArrayEquals(new int[]{1,2,3,},new int[]{1,3,2});

    }    @Test
    void testCase3(){
        System.out.println("Test Case 3");
        String nullString = null;
        String notNullString = "Cydeo";
//        assertNull(notNullString);
        assertNotNull(nullString);

    }    @Test
    void testCase4(){
        System.out.println("Test Case 4");
        String str1 = "hello";
        String str2 = "hello";
        assertSame(str1,str2);

    }    @Test
    void testCase5(){
        System.out.println("Test Case 5");

    }

}