package yugo;

import yugo.controller.CompanyController;

import java.io.IOException;

public class MainCompany {

    public static void main(String[] args) throws IOException {
        CompanyController companyController = new CompanyController();
        companyController.start();
    }
}