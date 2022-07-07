package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    @BeforeMethod
    public void MethodTestingStarted() {
        System.out.println("The method testing started");
    }

    @Test
    public void TestAddMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10,20), 30, "Looks like add method has some issues!");
    }

    @Test
    public void TestSubtractMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.subtract(20,10), 10, "Looks like subtract method has some issues!");
    }

    @Test
    public void TestMultiplyMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(20,10), 200, "Looks like multiply method has some issues!");
    }
    @Test
    public void TestDivideMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(20,10), 2, "Looks like divide method has some issues!");
    }
}