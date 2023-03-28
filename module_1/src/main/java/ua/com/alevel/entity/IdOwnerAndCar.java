package ua.com.alevel.entity;

public class IdOwnerAndCar {

    private String carId;
    private String ownerId;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Owner ID is: " + this.ownerId + "; Car ID is: " + this.carId + "; ";
    }
}
