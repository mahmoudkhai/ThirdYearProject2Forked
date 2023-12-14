public abstract class Person {
    private String name;
    private int nationalId;
    private GENDER GENDER;
    private String location;
    private int phoneNumber;
    private int age;

    public Person(String name, int nationalId, GENDER GENDER, String location, int age, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalId = nationalId;
        this.GENDER = GENDER;
        this.location = location;
        if (age > 18) {
            throw new IllegalArgumentException("Age must be below or equal 18");
        } else {
            this.age = age;
        }
    }

    public GENDER getGENDER() {
        return GENDER;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getNationalId() {
        return nationalId;
    }

    public GENDER getType() {
        return GENDER;
    }

    public String getLocation() {
        return location;
    }

    public int getAge() {
        return age;
    }
}
