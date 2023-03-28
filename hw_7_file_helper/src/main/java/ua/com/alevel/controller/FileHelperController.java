package ua.com.alevel.controller;

import ua.com.alevel.service.FileHelperService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHelperController {

    FileHelperService fileHelperService = new FileHelperService();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            cases(bf, select);
        }
    }

    private void menu() {
        System.out.println("     ___________________________________________________________");
        System.out.println("    |  Operations:                                              |");
        System.out.println("    1 >> Add Directory in directory...                          |");
        System.out.println("    2 >> Add File in directory...                               |");
        System.out.println("    3 >> List files in directory...                             |");
        System.out.println("    4 >> Delete File or Directory in directory...               |");
        System.out.println("    5 >> Move file between directories...                       |");
        System.out.println("    6 >> Find File in directory...                              |");
        System.out.println("    7 >> Find Text in directory...                              |");
        System.out.println("    0 >> Exit...________________________________________________|");
//        System.out.println("    ");
    }

    public void cases(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> addD(reader);
            case "2" -> addF(reader);
            case "3" -> list(reader);
            case "4" -> delete(reader);
            case "5" -> move(reader);
            case "6" -> findFile(reader);
            case "7" -> findText(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    public void addD(BufferedReader reader) throws IOException {
        System.out.println("Enter path directory and directory name throw '/':");
        String addD = reader.readLine();
        fileHelperService.createDirectory(addD);
    }

    public void addF(BufferedReader reader) throws IOException {
        System.out.println("Enter path directory and file name throw '/':");
        String addF = reader.readLine();
        fileHelperService.createFile(addF);
    }

    public void list(BufferedReader reader) throws IOException {
        System.out.println("Enter name of Directory:");
        File file = new File(reader.readLine());
       fileHelperService.listFile(String.valueOf(file));
    }

    public void delete(BufferedReader reader) throws IOException {
        System.out.println("Enter file or directory name throw '/':");
        String delete = reader.readLine();
        fileHelperService.deleteFile(delete);
    }

    public void move(BufferedReader reader) throws IOException {
        System.out.println("Enter path of directory the file to move from:");
        File directory = new File(reader.readLine());
        System.out.println("Enter file name:");
        File file = new File(directory, reader.readLine());
        System.out.println("Enter path of directory the file to move to:");
        File newDirectory = new File(reader.readLine());
        file.renameTo(new File(newDirectory, file.getName()));
        System.out.println("File was moved to directory: " + newDirectory);
    }

    public void findFile(BufferedReader reader) throws IOException {
        System.out.println("Enter path of Directory:");
        String dir = reader.readLine();
        System.out.println("Enter File name:");
        String file = reader.readLine();
        fileHelperService.findFileOrFolder(new File(dir), file);
    }

    private void findText(BufferedReader reader) throws IOException {
            System.out.println("Enter path of Directory:");
            File dir = new File(reader.readLine());
            System.out.println("Enter the text which you want to find:");
            String text = reader.readLine().toLowerCase();
            fileHelperService.findTextInFiles(dir, text);
    }
}
