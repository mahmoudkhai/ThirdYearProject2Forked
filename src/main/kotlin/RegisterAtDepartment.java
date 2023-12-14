
// Single Responsibility
public class RegisterAtDepartment {

    public Boolean isStudentAllowed(double studentGrade, CollegeDepartments department) {
        switch (department) {
            case COMPUTER_SCIENCE -> {
                if (studentGrade >= 75.0) return true;
                else return false;
            }
            case CONTROL -> {
                if (studentGrade >= 60.0) return true;
                else return false;
            }
            case COMMUNICATION -> {
                if (studentGrade >= 65.0) return true;
                else return false;
            }
            default -> {
                return false;
            }
        }
    }
}
