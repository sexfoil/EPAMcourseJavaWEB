package model.entity;

import java.time.LocalDateTime;

public class Invoice {

    private int id;
    private int userId;
    private long cargoId;
    private int cost;
    private LocalDateTime dateTime;
    private int statusId;

    public Invoice(int id, int userId, long cargoId, int cost, LocalDateTime dateTime, int statusId) {
        this.id = id;
        this.userId = userId;
        this.cargoId = cargoId;
        this.cost = cost;
        this.dateTime = dateTime;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getCargoId() {
        return cargoId;
    }

    public void setCargoId(long cargoId) {
        this.cargoId = cargoId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
