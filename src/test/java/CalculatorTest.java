import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void TestAddMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10,20), 30, "Looks like add method has some issues!");
    }

    @Test
    public void TestSubtractMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.substract(10, 20), -10, "Looks like subtract method has some issues!");
    }

    @Test
    public void TestMultiplyMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiple(10, 20), 200, "Looks like multiple method has some issues!");
    }

    @Test
    public void TestDivideMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(10, 20), 0.5, "Looks like divide method has some issues!");
    }
}
