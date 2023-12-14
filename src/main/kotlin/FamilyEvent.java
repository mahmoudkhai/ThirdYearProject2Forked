import java.util.List;

public class FamilyEvent {
    private List<FamilyEvent> familyEventList;
    private String eventName , description , location ;
    private int startAt , endAt ,id ;
    private Family eventFamily ;

    public FamilyEvent(String eventName, String description, String location, int startAt, int endAt, int id, Family eventFamily) {
        this.eventName = eventName;
        this.description = description;
        this.location = location;
        this.startAt = startAt;
        this.endAt = endAt;
        this.id = id;
        this.eventFamily = eventFamily;
    }

    public int getEventId() {
        return id;
    }

    public List<FamilyEvent> getFamilyEventList() {
        return familyEventList;
    }
    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getStartAt() {
        return startAt;
    }

    public int getEndAt() {
        return endAt;
    }

    public Family getEventFamily() {
        return eventFamily;
    }
}
