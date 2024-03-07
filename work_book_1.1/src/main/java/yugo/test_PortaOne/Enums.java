package yugo.test_PortaOne;

public enum Enums {

    DATA_FILE("/data_test.txt");

    public final String pathToDataFile;

    Enums(String pathToDataFile) {
        this.pathToDataFile = pathToDataFile;
    }

    public String getDataFile() {
        return pathToDataFile;
    }
}
