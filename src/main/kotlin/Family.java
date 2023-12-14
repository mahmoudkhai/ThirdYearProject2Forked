import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Family {
    private List<HashMap<Family, Trip>> familyTrips;

    private Student familyManager;
    private String familyName;
    private List<String> familyActivities;
    private List<HashMap<Student, FamilyMemberRole>> familyMembers;

    public Family(Student familyManager, String familyName, List<String> familyActivities) {
        this.familyManager = familyManager;
        this.familyName = familyName;
        this.familyActivities = familyActivities;
    }

    public void enrollFamilyMembers(HashMap<Student, FamilyMemberRole>... studentAndRole) {
        familyMembers.addAll(Arrays.asList(studentAndRole));
    }

    public Student getFamilyManager() {
        return familyManager;
    }

    public String getFamilyName() {
        return familyName;
    }

    public List<HashMap<Family, Trip>> getFamilyTrips() {
        return familyTrips;
    }

    public List<String> getFamilyActivities() {
        return familyActivities;
    }

    public List<HashMap<Student, FamilyMemberRole>> getFamilyMembers() {
        return familyMembers;
    }

    public abstract boolean createTrip(Trip trip);

}
