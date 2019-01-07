package model.entity.user;


public class UserData {

    private int userId;
    private String cellNumber;


    public UserData(int userId, String cellNumber) {
        this.userId = userId;
        this.cellNumber = cellNumber;
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

}
