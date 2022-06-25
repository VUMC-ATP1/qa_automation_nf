public class Employee {

    // Add fields: name, surname, year, role
    // Getters/setters
    // All args, no args constructor
    // Test under test/java package
    // Goal: 100% coverage

    private String name;
    private String surname;
    private int year;
    private String role;

    // Getters/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Constructors
    public Employee() {
    }

    public Employee(String name, String surname, int year, String role) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.role = role;
    }
}
