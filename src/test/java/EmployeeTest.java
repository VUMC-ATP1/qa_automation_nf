import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {

    @Test
    public void employeeNameTest() {
        Employee employee = new Employee();
        employee.setName("Nikita");
        Assert.assertEquals(employee.getName(), "Nikita", "Name method has some issues");
    }

    @Test
    public void employeeSurnameTest() {
        Employee employee = new Employee();
        employee.setSurname("Milka");
        Assert.assertEquals(employee.getSurname(), "Milka", "Surname method has some issues");
    }

    @Test
    public void employeeYearTest() {
        Employee employee = new Employee();
        employee.setYear(35);
        Assert.assertEquals(employee.getYear(), 35, "Year method has some issues");
    }

    @Test
    public void employeeRoleTest() {
        Employee employee = new Employee();
        employee.setRole("QA engineer");
        Assert.assertEquals(employee.getRole(), "QA engineer", "Role method has some issues");
    }

    @Test
    public void employeeAllArgumentsTest() {
        Employee employee = new Employee("Nikita", "Milka", 35, "QA engineer");
        Assert.assertEquals(employee.getName(),"Nikita", "EmployeeAllArgument method has some issues");
        Assert.assertEquals(employee.getSurname(),"Milka", "EmployeeAllArgument method has some issues");
        Assert.assertEquals(employee.getYear(),35, "EmployeeAllArgument method has some issues");
        Assert.assertEquals(employee.getRole(),"QA engineer", "EmployeeAllArgument method has some issues");
    }
}