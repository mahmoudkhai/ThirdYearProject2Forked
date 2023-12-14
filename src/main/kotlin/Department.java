import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Department {
    private CollegeDepartments department;
    private Employee departmentManager;
    private List<Employee> departmentEmployees;
    private List<Student> departmentStudents;
    private List<Course> departmentCourses;
    private double departmentScore;

    public Department(CollegeDepartments department, List<Employee> departmentEmployees, List<Course> departmentCourses,
                      Employee departmentManager, double departmentScore) {
        this.department = department;
        this.departmentCourses = departmentCourses;
        this.departmentEmployees = departmentEmployees;
        this.departmentScore = departmentScore;
        if (departmentManager.getJobTitle() != JopTitle.PROFFESOR) {
            throw new IllegalStateException("Department manager must be a prof");
        } else this.departmentManager = departmentManager;
    }

    public List<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public List<Student> getDepartmentStudents() {
        return departmentStudents;
    }

    public CollegeDepartments getDepartment() {
        return department;
    }

    public List<Course> getDepartmentCourses() {
        return departmentCourses;
    }

    public double getDepartmentScore() {
        return departmentScore;
    }

    public String getDepartmentManager() {
        return departmentManager.getName();
    }

}