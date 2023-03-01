package ua.com.alevel.entity;

public class Car extends BaseEntity{

    private String carBrand;
    private String carModel;
    private String vinCode;

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    @Override
    public String toString() {
        return
                "id - " + getId() + '\'' + "; " +
                "Brand: " + carBrand + '\'' + "; " +
                "Model: " + carModel + '\'' + "; " +
                "vinCode: " + vinCode + '\'' + "; " +
                " " + super.toString();
    }
}
