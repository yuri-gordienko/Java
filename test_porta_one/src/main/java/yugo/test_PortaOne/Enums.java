package yugo.test_PortaOne;

public enum Enums {

    DATA_FILE("/10m_06_24.txt");


    public final String pathToDataFile;

    Enums(String pathToDataFile) {

        this.pathToDataFile = pathToDataFile;
    }

    public String getDataFile() {

        return pathToDataFile;
    }
}
