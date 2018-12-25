package model.entity;

public class Address {

    private int userId;
    private int streetId;
    private String building;
    private String section;
    private String apartment;

    public Address(int userId) {
        this(userId, 0, "", "", "");
    }

    public Address(int userId, int streetId, String building, String section, String apartment) {
        this.userId = userId;
        this.streetId = streetId;
        this.building = building;
        this.section = section;
        this.apartment = apartment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
