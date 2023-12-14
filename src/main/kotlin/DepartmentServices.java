import java.util.Arrays;

public class DepartmentServices {
    private Department department;

    public DepartmentServices(Department department) {
        this.department = department;
    }


    public Boolean enrollStudents(Student... students) {
        return department.getDepartmentStudents().addAll(Arrays.asList(students));
    }

    public Boolean enrollEmployee(Employee... employees) {
        return department.getDepartmentEmployees().addAll(Arrays.asList(employees));
    }

    public Boolean deleteStudent(Student... students) {
        return department.getDepartmentStudents().removeAll(Arrays.asList(students));
    }

    public Boolean deleteEmployee(Employee... employees) {
        return department.getDepartmentEmployees().removeAll(Arrays.asList(employees));
    }
}
