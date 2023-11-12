package ua.com.alevel.storage;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.IdOwnerAndCar;
import ua.com.alevel.entity.Owner;

import java.util.UUID;

public class StorageEntity {

    private Car[] cars = new Car[2];
    private Owner[] owners = new Owner[2];
    private IdOwnerAndCar[] idOwnerAndCar = new IdOwnerAndCar[10];

    public void addCar(Car car) {
        car.setId(generateCarId());
        addIndexCar();
        for(int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = car;
                break;
            }
        }
        arrayGrowth++;
    }

    private String generateCarId() {
        String id = UUID.randomUUID().toString();
        for (Car car : cars) {
            if (car != null && car.getId().equals(id)) {
                return generateCarId();
            }
        }
        return id;
    }

    int arrayGrowth;
    private void  addIndexCar() {
        if (arrayGrowth == cars.length) {
            Car[] addCar = new Car[((cars.length * 3) / 2) + 1];
            for (int i = 0; i < cars.length; i++) {
                addCar[i] = cars[i];
            }
            cars = addCar;
        }
    }

    public Car findCarById(String  id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public void updateCar(Car car) {
        for(int i = 0; i < cars.length; i++) {
            try {
                if (cars[i].getId().equals(car.getId())) {
                    cars[i] = car;
                }
            }
            catch (Exception e) {
                i++;
            }
        }
    }

    public Car deleteCar(String id) {
        for(int i = 0; i < cars.length; i++) {
            try {
                if (cars[i].getId().equals(id)) {
                    cars[i] = null;
                }
            }
            catch (Exception e) {
                i++;
            }
        }
        return null;
    }

    public Car[] seeAllCars() {

        return cars;
    }

    public void addOwner(Owner owner) {
        owner.setId(generateOwnerId());
        addIndexOwner();
        for(int i = 0; i < owners.length; i++) {
            if (owners[i] == null) {
                owners[i] = owner;
                break;
            }
        }
        arrayGrowthOwn++;
    }

    private String generateOwnerId() {
        String id = UUID.randomUUID().toString();
        for (Owner owner : owners) {
            if (owner != null && owner.getId().equals(id)) {
                return generateOwnerId();
            }
        }
        return id;
    }

    int arrayGrowthOwn;
    private void  addIndexOwner() {
        if (arrayGrowthOwn == owners.length) {
            Owner[] addOwner = new Owner[((owners.length * 3) / 2) + 1];
            for (int i = 0; i < owners.length; i++) {
                addOwner[i] = owners[i];
            }
            owners = addOwner;
        }
    }

    public Owner findOwnerById(String id) {
        for (Owner owner : owners) {
            if (owner.getId().equals(id)) {
                return owner;
            }
        }
        return null;
    }

    public void updateOwner(Owner owner) {
        for(int i = 0; i < owners.length; i++) {
            try {
                if (owners[i].getId().equals(owner.getId())) {
                    owners[i] = owner;
                }
            }
            catch (Exception e) {
                i++;
            }
        }
    }

    public void deleteOwner(String id) {
        for(int i = 0; i < owners.length; i++) {
            try {
                if (owners[i].getId().equals(id)) {
                    owners[i] = null;
                }
            }
            catch (Exception e) {
                i++;
            }
        }
    }

    public Owner[] seeAllOwners() {
        return this.owners;
    }

    public void attachCarToOwner(String carId, String ownerId) {
        for(int i = 0; i < idOwnerAndCar.length; i++) {
            if (idOwnerAndCar[i] == null) {
                IdOwnerAndCar idOwnerCar = new IdOwnerAndCar();
                idOwnerCar.setCarId(carId);
                idOwnerCar.setOwnerId(ownerId);
                idOwnerAndCar[i] = idOwnerCar;
                break;
            }
        }
    }

    public void deleteCarFromOwner(String carId, String ownerId) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getId().equals(carId)) {
                cars[i] = null;
                for (i = 0; i < owners.length; i++) {
                    if (owners[i].getId().equals(ownerId)) {
                        owners[i] = null;
                        return;
                    }
                }
            }
        }
    }

    public IdOwnerAndCar[] seeAllCarsWithOwners() {
        return this.idOwnerAndCar;
    }

    public Car[] findCarsByOwnerId(String ownerId) {
        String[] carIds = new String[10];
        for (int i = 0; i < idOwnerAndCar.length; i++) {
            IdOwnerAndCar idOwnerCar = idOwnerAndCar[i];
            if (idOwnerCar != null && idOwnerCar.getOwnerId().equals(ownerId)) {
                for (int i1 = 0; i1 < carIds.length; i1++) {
                    if (carIds[i1] == null) {
                        carIds[i1] = idOwnerCar.getCarId();
                        break;
                    }
                }
            }
        }
        Car[] car = new Car[10];
        for (int i = 0; i < this.cars.length; i++) {
            for (int i1 = 0; i1 < carIds.length; i1++) {
                if (this.cars[i] != null && this.cars[i].getId().equals(carIds[i1])) {
                    for (int i2 = 0; i2 < car.length; i2++) {
                        if (car[i2] == null) {
                            car[i2] = this.cars[i];
                            break;
                        }
                    }
                }
            }
        }
        return car;
    }

    public Owner[] findOwnersByCarId(String carId) {
        String[] ownerIds = new String[10];
        for (int i = 0; i < idOwnerAndCar.length; i++) {
            IdOwnerAndCar idCarOwner = idOwnerAndCar[i];
            if (idCarOwner != null && idCarOwner.getCarId().equals(carId)) {
                for (int i1 = 0; i1 < ownerIds.length; i1++) {
                    if (ownerIds[i1] == null) {
                        ownerIds[i1] = idCarOwner.getOwnerId();
                        break;
                    }
                }
            }
        }
        Owner[] owner = new Owner[10];
        for (int i = 0; i < this.owners.length; i++) {
            for (int i1 = 0; i1 < ownerIds.length; i1++) {
                if (this.owners[i] != null && this.owners[i].getId().equals(ownerIds[i1])) {
                    for (int i2 = 0; i2 < owner.length; i2++) {
                        if (owner[i2] == null) {
                            owner[i2] = this.owners[i];
                            break;
                        }
                    }
                }
            }
        }
        return owner;
    }
}
