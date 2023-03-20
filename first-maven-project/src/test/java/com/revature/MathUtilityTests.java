package com.revature;

import org.junit.*;

public class MathUtilityTests {

    private MathUtility mathUtil;

    @Before // Used to run the method before each and every test
    public void setup() {
        // Arrange
        System.out.println("setup() invoked");
        this.mathUtil = new MathUtility();
    }

    @After // used to run the method after each and every test
    public void cleanup() {
        System.out.println("cleanup() invoked");
    }

    @BeforeClass // used to run before running all tests
    public static void beforeRunningTests() {
        System.out.println("beforeRunningTests() invoked");
    }

    @AfterClass // used to run after running all tests
    public static void afterRunningTests() {
        System.out.println("afterRunningTests() invoked");
    }

    @Test
    public void testSum2and2is4() {
        // Act
        double actual = mathUtil.sum(2, 2);

        // Assert
        double expected = 4.0;
        Assert.assertEquals(expected, actual, 0.001); // 0.001 is the tolerance
    }

    @Test
    public void testSubtract10and3is7() {
        double actual = mathUtil.subtract(10, 3);

        double expected = 7;
        Assert.assertEquals(expected, actual, 0.001);
    }


}
