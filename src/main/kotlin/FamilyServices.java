import java.util.Arrays;

public class FamilyServices {


    public Boolean reserveTrip(Trip trip, Person... persons) {
        return trip.getTripMembers().addAll(Arrays.asList(persons));
    }

    public Boolean cancelTripReservation(Trip trip, Person... persons) {
        return trip.getTripMembers().removeAll(Arrays.asList(persons));
    }

    public FamilyEvent createEvent(Family eventOwnerFamily,
                                   String eventName,
                                   String eventLocation,
                                   String eventDescription,
                                   int startAt,
                                   int endAt,
                                   int eventId) {
        return new FamilyEvent(eventName, eventLocation, eventDescription, startAt, endAt, eventId, eventOwnerFamily);
    }

    public Boolean cancelEvent(FamilyEvent familyEvent) {
        return familyEvent.getFamilyEventList().remove(familyEvent);
    }

}
