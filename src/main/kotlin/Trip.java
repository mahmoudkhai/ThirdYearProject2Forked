import java.util.List;

public class Trip {
    private String location, title, description, date;
    private double price;
    private Boolean isDone = false;
    private List<Person> tripMembers;

    public List<Person> getTripMembers() {
        return tripMembers;
    }

    public Trip(String location, String title, String description, String date, double price) {
        this.location = location;
        this.title = title;
        this.description = description;
        this.date = date;
        this.price = price;
    }

    public Boolean isDone() {
        return isDone;
    }

    // don't get boolean value as a parameter , this 'll break encapsulation.
    public void setIsDoneToTrue() {
        isDone = true;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
