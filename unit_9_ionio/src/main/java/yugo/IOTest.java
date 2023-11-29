package yugo;

import java.io.File;
import java.io.IOException;

public class IOTest {

    private final String DIR_NAME = "unit_9_ionio/src/main/java/yugo/files";
    private final String FILE_NAME = "unit_9_ionio/src/main/java/yugo/files/file.txt";
    private final String LIST_FILE = "unit_9_ionio/src/main/java/yugo/files";
    private final String DELETE_FILE = "unit_9_ionio/src/main/java/yugo/files/file.txt";
    private final String FIND_FILE = "unit_9_ionio/src/main/java/yugo/files/file.txt";
    private final String MOVE_FROM = "unit_9_ionio/src/main/java/yugo/files/file2";
    private final String MOVE_TO = "unit_9_ionio/src/main/java/yugo/new_files/file2";
    private final String DELETE_FROM = "unit_9_ionio/src/main/java/yugo/files/file2";


    public void test() {
        try {
//            createDir(DIR_NAME);
//            createFile(FILE_NAME);
            listFiles(LIST_FILE);
//            delete(DELETE_FILE);
//            findFile(FIND_FILE);
//            removeFile(MOVE_FROM, MOVE_TO);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    };


    // створення папки в зазначеній директорії
    private void createDir(String string) throws IOException {
        File file = new File(string);
        file.mkdir();
    }

    // створення файла в зазначеній директорії
    private void createFile(String string) throws IOException {
        File file = new File(string);
        file.createNewFile();
    }

    // список всіх файлів та папок по зазначеній директорії
    private String listFiles(String string) throws IOException {
        File file = new File(string);
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println("list = " + file1);
        }
        return null;
    }

    // видалення файла чи папки в зазначеній директорії
    private void delete(String string) throws IOException {
        File file = new File(string);
        file.delete();
    }

    // пошук файла чи папки по зазначеній директорії
    private String findFile(String string) throws IOException {
        File file = new File(string);
        String absolutePath = file.getAbsolutePath();
        System.out.println("file = " + absolutePath);
        boolean isFile = file.isFile();
        System.out.println("isFile = " + isFile);
        return absolutePath;
    }

    // переміщення файла чи папки із зазначеної директорії в зазначену директорію
    private File removeFile(String stringFrom, String stringTo) throws IOException {
        File file = new File(stringFrom);
        file.renameTo(new File(stringTo));

        return file;
    }
}
