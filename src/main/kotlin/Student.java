public class Student extends Person {

    private int id;
    private Boolean isGraduated = false;
    private final Double secondarySchoolGrade;


    public Student(String name, int nationalId, GENDER GENDER, String location, Double secondarySchoolGrade, int age, int id, int phoneNumber) {
        super(name, nationalId, GENDER, location, age, phoneNumber);
        this.id = id;

        if (secondarySchoolGrade < College.COLLEGE_GRADE) {
            throw new IllegalArgumentException("Your Grade must be upper than" + College.COLLEGE_GRADE);
        } else {
            this.secondarySchoolGrade = secondarySchoolGrade;
        }

    }


    public Double getSecondarySchoolGrade() {
        return secondarySchoolGrade;
    }


    public Boolean getGraduated() {
        return isGraduated;
    }

    public void setGraduated(Boolean graduated) {
        isGraduated = graduated;
    }
}
