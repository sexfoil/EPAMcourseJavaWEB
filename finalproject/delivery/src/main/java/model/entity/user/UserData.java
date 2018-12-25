package model.entity.user;

public class UserData {

    private int userId;
    private String cellNumber;
    private String address;


    public UserData(int userId) {
        this(userId, "", "");
    }

    public UserData(int userId, String cellNumber, String address) {
        this.userId = userId;
        this.cellNumber = cellNumber;
        this.address = address;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
