package ua.com.alevel.storage;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.CarOwner;
import ua.com.alevel.entity.Owner;

public class StorageEntity {

    private Owner[] owners = new Owner[10];
    private Car[] cars = new Car[10];
    private CarOwner[] carOwners= new CarOwner[10];

    public void addCar(Car car) {
        car.setId(generateCarId());
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == null) {
                    cars[i] = car;
                    break;
                }
            }
    }
    private int generateCarId() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                return i + 1;
            }
        }
        return 0;
    }
    public void addOwner(Owner owner) {
        owner.setId(generateOwnerId());
            for (int i = 0; i < owners.length; i++) {
                if (owners[i] == null) {
                    owners[i] = owner;
                    break;
                }
            }
    }
    public void attachCarToOwner(int carId, int ownerId) {
        for (int i = 0; i < carOwners.length; i++) {
            if (carOwners[i] == null) {
                CarOwner carOwner = new CarOwner();
                carOwner.setCarId(carId);
                carOwner.setOwnerId(ownerId);
                carOwners[i] = carOwner;
                break;
            }
        }
    }
    public Car[] findCarsByOwner(int ownerId) {
        int[] carIds = new int[10];
        for (int i = 0; i < carOwners.length; i++) {
            CarOwner carOwner = carOwners[i];                                       // получаем CarOwner class
            if (carOwner != null && carOwner.getOwnerId() == ownerId) {             // проверяем
                for (int i1 = 0; i1 < carIds.length; i1++) {
                    if (carIds[i1] == 0) {
                        carIds[i1] = carOwner.getCarId();       // получили массивчик carIds
                        break;
                    }
                }

            }
        }
        Car[] cars = new Car[10];
        for (int i = 0; i < this.cars.length; i++) {
            for (int i1 = 0; i1 < carIds.length; i1++) {
                if (this.cars[i] != null && this.cars[i].getId() == carIds[i1]) {
                    for (int i2 = 0; i2 < cars.length; i2++) {
                        if (cars[i2] == null) {
                            cars[i2] = this.cars[i];
                            break;
                        }
                    }
                }

            }
        }
        return cars;
    }
    public Car[] findAllCars() {
        return this.cars;
    }
    public Owner[] findAllOwners() {
        return this.owners;
    }
    private int generateOwnerId() {
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] == null) {
                return i + 1;
            }
        }
        return 0;
    }


}
