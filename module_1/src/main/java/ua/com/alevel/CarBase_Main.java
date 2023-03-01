package ua.com.alevel;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.storage.StorageEntity;

public class CarBase_Main {

    public static void main(String[] args) {
        StorageEntity storage = new StorageEntity();

        Car car = new Car();
        car.setCarBrand("BMW");
        car.setCarModel("i_330");
        car.setVinCode("2424");
        storage.addCar(car);

        car = new Car();
        car.setCarBrand("Mercedes");
        car.setCarModel("E-Class coup");
        car.setVinCode("0440");
        storage.addCar(car);

        car = new Car();
        car.setCarBrand("Honda");
        car.setCarModel("Accord");
        car.setVinCode("9479");
        storage.addCar(car);

        car = new Car();
        car.setCarBrand("Mercedes");
        car.setCarModel("C-Class");
        car.setVinCode("4477");
        storage.addCar(car);

        car = new Car();
        car.setCarBrand("Renault");
        car.setCarModel("Clio");
        car.setVinCode("2702");
        storage.addCar(car);

        Car[] cars = storage.findAllCars();
        for (Car car1 : cars) {
            if (car1 != null) {
            System.out.println("Car: " + car1);
            }
        }

        Owner owner = new Owner();
        owner.setFirstName("Dmitri");
        owner.setLastName("Polupan");
        storage.addOwner(owner);

        owner = new Owner();
        owner.setFirstName("Yuri");
        owner.setLastName("Gordienko");
        storage.addOwner(owner);

        owner = new Owner();
        owner.setFirstName("Kat");
        owner.setLastName("Berdnikova");
        storage.addOwner(owner);

        Owner[] owners = storage.findAllOwners();

        for (Owner owner1 : owners) {
            if (owner1 != null) {
                System.out.println("Owner: " + owner1);
            }
        }

        storage.attachCarToOwner(1, 1);
        storage.attachCarToOwner(2, 1);
        storage.attachCarToOwner(3,2);
        storage.attachCarToOwner(4,2);
        storage.attachCarToOwner(5,2);
        storage.attachCarToOwner(5,3);

        Car[] carsByOwner = storage.findCarsByOwner(1);
        for (Car car1 : carsByOwner) {
            if (car1 != null) {
                System.out.println("Car by owner id #1 is: " + car1);
            }
        }
        carsByOwner = storage.findCarsByOwner(2);
        for (Car car1 : carsByOwner) {
            if (car1 != null) {
                System.out.println("Car by owner id #2 is: " + car1);
            }
        }
        carsByOwner = storage.findCarsByOwner(3);
        for (Car car1 : carsByOwner) {
            if (car1 != null) {
                System.out.println("Car by owner id #3 is: " + car1);
            }
        }
    }

}