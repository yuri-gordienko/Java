package ua.com.alevel;

import ua.com.alevel.dao.ElectivesDao;
import ua.com.alevel.dao.PupilsDao;
import ua.com.alevel.dao.impl.ElectivesDaoImpl;
import ua.com.alevel.dao.impl.PupilsDaoImpl;
//import ua.com.alevel.datatable.DataTableRequest;
//import ua.com.alevel.datatable.DataTableResponse;
import ua.com.alevel.entity.Electives;
import ua.com.alevel.entity.Pupils;

import java.util.Random;

public class CrudTest {     // искусственно наполняем таблицы

    private final PupilsDao PupilsDao = new PupilsDaoImpl();
    private final ElectivesDao ElectivesDao = new ElectivesDaoImpl();

    private Pupils Pupils = new Pupils();

    public void run() {
//        createPupils();
//        createElectives();
//        attachPupilsToElectives();
//        detachPupilsFromElectives();
//        createPupilsList();
//        dataTable();
    }

    public void createPupils() {
        Pupils.setFirstName("fs");
        Pupils.setLastName("gasgasgas");
        Pupils.setMark(22);
        Pupils.setEmail("fdsafasfdsfas");

        PupilsDao.create(Pupils);
    }

    public void createPupilsList() {
        for (int i = 0; i < 1000; i++) {
            Pupils.setFirstName("FirstName" + i);
            Pupils.setLastName("LastName" + i);
            Pupils.setMark(new Random().nextInt(20, 35));
            Pupils.setEmail("email" + i + "@gmail.com");
            PupilsDao.create(Pupils);
        }
    }

    public void updatePupils() {
        Pupils.setFirstName("fdsfds");
        Pupils.setLastName("dsfsd");
        Pupils.setMark(43);
        Pupils.setEmail("fdsfsd");

        PupilsDao.create(Pupils);
    }

    public void deletePupils() {
        PupilsDao.delete(Pupils);
    }

    public void createElectives() {
        Electives Electives = new Electives();
        Electives.setName("JAVA");
        ElectivesDao.create(Electives);
    }

    public void attachPupilsToElectives() {
        Electives Electives = ElectivesDao.findById(2L).get();
        Pupils Pupils2 = PupilsDao.findById(2L).get();
        Pupils Pupils3 = PupilsDao.findById(3L).get();
        ElectivesDao.attachPupilsToElectives(Electives, Pupils2);
        ElectivesDao.attachPupilsToElectives(Electives, Pupils3);
    }

    public void detachPupilsFromElectives() {
        Electives Electives = ElectivesDao.findById(2L).get();
        Pupils Pupils2 = PupilsDao.findById(2L).get();
        ElectivesDao.detachPupilsToElectives(Electives, Pupils2);
    }

//    public void dataTable() {
//        DataTableRequest dataTableRequest = new DataTableRequest();
//        dataTableRequest.setPage(3);
//        dataTableRequest.setSize(10);
//        dataTableRequest.setOrderBy("asc");
//        dataTableRequest.setSortBy("email");
//        DataTableResponse<Pupils> response = PupilsDao.findAll(dataTableRequest);
//        for (Pupils item : response.getItems()) {
//            System.out.println("item = " + item);
//        }
//    }
}