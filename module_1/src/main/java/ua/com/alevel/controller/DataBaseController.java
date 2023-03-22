package ua.com.alevel.controller;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.IdOwnerAndCar;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.storage.StorageEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataBaseController {

    private StorageEntity storage = new StorageEntity();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("__________________________________________________");
        System.out.println("         CARs and OWNERs DATA BASE               |");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            variants(bf, select);
        }
    }

    private void menu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Make your choice, please:                        |");
        System.out.println("                   CAR           OWNER           |");
        System.out.println("Add                 1              6             |");
        System.out.println("Find                2              7             |");
        System.out.println("Update              3              8             |");
        System.out.println("Delete              4              9             |");
        System.out.println("See all             5              10            |");
        System.out.println("..................................................");
        System.out.println("ATTACH Car to Owner, please enter            11  |");
        System.out.println("FIND Cars of OWNER, please enter             12  |");
        System.out.println("FIND Owners of CAR, please enter             13  |");
        System.out.println("SEPARATE Car and Owner, please enter         14  |");
        System.out.println("REVIEW all Attached Cars with Owners         15  |");
        System.out.println("..................................................");
        System.out.println("If you want to EXIT, please enter             0  |");
        System.out.println("--------------------------------------------------");
    }

    private void variants(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> addCAR(reader);
            case "2" -> findCARbyId(reader);
            case "3" -> updateCAR(reader);
            case "4" -> deleteCAR(reader);
            case "5" -> seeAllCARs();

            case "6" -> addOWNER(reader);
            case "7" -> findOWNERbyId(reader);
            case "8" -> updateOWNER(reader);
            case "9" -> deleteOWNER(reader);
            case "10" -> seeAllOWNERs();

            case "11" -> attachCARsToOWNER(reader);
            case "12" -> findCarsByOwnerId(reader);
            case "13" -> findOwnersByCarId(reader);
            case "14" -> deleteCarsFromOwner(reader);
            case "15" -> seeAttachedCarsOwners(reader);

            case "0" -> System.exit(0);
        }
        menu();
    }

    private void addCAR(BufferedReader reader) throws IOException {
        System.out.println("Please enter the Car Brand:");
        String carBrand = reader.readLine();
        System.out.println("Please enter the Car Model:");
        String carModel = reader.readLine();
        System.out.println("Please enter the Car Vin Code:");
        String vinCode = reader.readLine();
        Car car = new Car();
        car.setCarBrand(carBrand);
        car.setCarModel(carModel);
        car.setVinCode(vinCode);
        storage.addCar(car);
    }

    private void findCARbyId(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of the CAR which you want to Find: ");
        String id = reader.readLine();
        Car car = storage.findCarById(id);
        System.out.println("- " + car);
    }

    private void updateCAR(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of the CAR which you want to Update: ");
        String id = reader.readLine();
        System.out.println("Please enter the Car Brand for Updating:");
        String carBrand = reader.readLine();
        System.out.println("Please enter the Car Model for Updating:");
        String carModel = reader.readLine();
        System.out.println("Please enter the Car Vin Code for Updating:");
        String vinCode = reader.readLine();
        Car car = storage.findCarById(id);
        car.setCarBrand(carBrand);
        car.setCarModel(carModel);
        car.setVinCode(vinCode);
        storage.updateCar(car);
    }

    public void deleteCAR(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of the CAR which you want to Delete: ");
        String id = reader.readLine();
        storage.deleteCar(id);
        System.out.println("Car was deleted!");
    }

    private void seeAllCARs() {
        Car[] cars = storage.seeAllCars();
        for (Car car1 : cars) {
            if (car1 != null) {
                System.out.println("- " + car1);
            }
        }
    }

    private void addOWNER(BufferedReader reader) throws IOException {
        System.out.println("Please enter the OWNER First name:");
        String firstName = reader.readLine();
        System.out.println("Please enter the OWNER Last Name:");
        String lastName = reader.readLine();
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        storage.addOwner(owner);
    }

    private void findOWNERbyId(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of the OWNER whom you want to Find: ");
        String id = reader.readLine();
        Owner owner = storage.findOwnerById(id);
        System.out.println("- " + owner);
    }

    private void updateOWNER(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of the OWNER whom you want to Update: ");
        String id = reader.readLine();
        System.out.println("Please enter the OWNER First name for Updating:");
        String firstName = reader.readLine();
        System.out.println("Please enter the OWNER Last Name for Updating:");
        String lastName = reader.readLine();
        Owner owner = storage.findOwnerById(id);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        storage.updateOwner(owner);
    }

    public void deleteOWNER(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ID of the OWNER whom you want to Delete: ");
        String id = reader.readLine();
        storage.deleteOwner(id);
        System.out.println("Owner was deleted!");
    }

    private void seeAllOWNERs() {
        Owner[] owners = storage.seeAllOwners();
        for (Owner owner1 : owners) {
            if (owner1 != null) {
                System.out.println("- " + owner1);
            }
        }
    }

    public void attachCARsToOWNER(BufferedReader reader) throws IOException {
        System.out.println("Please enter the CAR ID which you want to attach to the OWNER: ");
        String carId = reader.readLine();
        System.out.println("Please enter the OWNER ID whom you want to attach to the CAR: ");
        String ownerId = reader.readLine();
        storage.attachCarToOwner(carId, ownerId);
    }

    private void findCarsByOwnerId(BufferedReader reader) throws IOException {
        System.out.println("Please enter the OWNER ID and you can see his/her Cars: ");
        String id = reader.readLine();
        Car[] carsByOwnerId = storage.findCarsByOwnerId(id);
        for (Car car1 : carsByOwnerId) {
            if (car1 != null) {
                System.out.println("Owner id is # : " + id + "  and his/her " + car1);
            }
        }
    }

    private void findOwnersByCarId(BufferedReader reader) throws IOException {
        System.out.println("Please enter the CAR ID and you can see its Owners: ");
        String id = reader.readLine();
        Owner[] ownerByCarsId = storage.findOwnersByCarId(id);
        for (Owner owner1 : ownerByCarsId) {
            if (owner1 != null) {
                System.out.println("Car id is # : " + id + "  and its " + owner1);
            }
        }
    }

    public void deleteCarsFromOwner(BufferedReader reader) throws IOException {
        System.out.println("Please enter the CAR ID which you want to separate from the OWNER: ");
        String carId = reader.readLine();
        System.out.println("Please enter the OWNER ID whom you want to separate from the CAR: ");
        String ownerId = reader.readLine();
        storage.deleteCarFromOwner(carId, ownerId);
    }

    private void seeAttachedCarsOwners(BufferedReader reader) throws IOException {
        IdOwnerAndCar[] idOwnerAndCars = storage.seeAllCarsWithOwners();
        for (IdOwnerAndCar idOwnerAndCar1 : idOwnerAndCars) {
            if (idOwnerAndCar1 != null) {
                System.out.println("- " + idOwnerAndCar1);
            }
        }
    }

}


