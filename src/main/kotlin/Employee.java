public class Employee extends Person {
    private JopTitle jobTitle;
    private double salary;
    private String employmentDate;

    public Employee(String name, int nationalId, GENDER GENDER, String location, int age, JopTitle jobTitle, String employmentDate) {
        super(name, nationalId, GENDER, location, age);
        this.jobTitle = jobTitle;
        this.employmentDate = employmentDate;
    }

    public JopTitle getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }
}
