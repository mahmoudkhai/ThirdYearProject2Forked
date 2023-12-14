public class Course {
    String courseName;
    private int courseHours;
    private Employee courseTeacher;
    private double courseScore;
    private double hourPrice;

    public Course(String courseName, int courseHours, Employee courseTeacher, double courseScore, double hourPrice) {
        this.courseName = courseName;
        this.courseHours = courseHours;
        if (courseTeacher.getJobTitle() != JopTitle.PROFFESOR || courseTeacher.getJobTitle() != JopTitle.TEACHING_ASSISTANT) {
            throw new IllegalArgumentException("Teacher must be either doctor or assistant");
        } else {
            this.courseTeacher = courseTeacher;
        }
        this.courseScore = courseScore;
        this.hourPrice = hourPrice;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public Employee getCourseTeacher() {
        return courseTeacher;
    }

    public double getCourseScore() {
        return courseScore;
    }

    public double getHourPrice() {
        return hourPrice;
    }
}
