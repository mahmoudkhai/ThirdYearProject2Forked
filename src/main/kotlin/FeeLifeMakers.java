import java.util.HashMap;
import java.util.List;

public class FeeLifeMakers extends Family {

    public FeeLifeMakers(Student familyManager, String familyName, List<String> familyActivities) {
        super(familyManager, familyName, familyActivities);
    }

    @Override
    public boolean createTrip(Trip trip) {
        HashMap<Family , Trip> familyTripHashMap = new HashMap<>();
        familyTripHashMap.put(this , trip);
        return getFamilyTrips().add( familyTripHashMap );
    }

}
