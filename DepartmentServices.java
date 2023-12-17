import java.util.Arrays;

/**
 * The DepartmentServices class provides services for managing students and employees within a department.
 * It allows enrolling and deleting students and employees from the department.
 */

public class DepartmentServices {

    // Instance variable to reference the associated department
    private Department department;

    // Constructor to initialize DepartmentServices with a specific department.

    public DepartmentServices(Department department) {
        this.department = department;
    }

   // Method to enroll students in the associated department

    public Boolean enrollStudents(Student... students) {
        return department.getDepartmentStudents().addAll(Arrays.asList(students));
    }


   //Method to enroll employees in the associated department.

    public Boolean enrollEmployee(Employee... employees) {
        return department.getDepartmentEmployees().addAll(Arrays.asList(employees));
    }



   //Method to delete students from the associated department.Method to delete students from the associated department.

    public Boolean deleteStudent(Student... students) {
        return department.getDepartmentStudents().removeAll(Arrays.asList(students));
    }

  // Method to delete employees from the associated department.

    public Boolean deleteEmployee(Employee... employees) {
        return department.getDepartmentEmployees().removeAll(Arrays.asList(employees));
    }
}
