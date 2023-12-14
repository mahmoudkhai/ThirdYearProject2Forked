import java.awt.*;

public class CollegeServices {
    public static final double FEES_FOR_GRADUATION_CERTIFICATE = 50.0;

    public Boolean requestGraduationCertificate(int studentId, int graduationYear) {
        return true;
    }

    public Boolean uploadCertificateToCloud (Image image) {
        // upload logic.
        return true;
    }
//    public Image getCertificateFromCloud (int studentId) {
//        //TODO()
//    }
    public Boolean payFees(CollegeYears year , double fees) {
        switch (year) {
            case FIRST_YEAR -> {
            }
            case SECOND_YEAR -> {
            }
            case THIRD_YEAR -> {
            }
            case FOURTH_YEAR -> {
            }
            case FIFTH_YEAR -> {
            }

        }
        return true;
    }


}
