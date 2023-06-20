package ua.com.alevel.controller;

import ua.com.alevel.dao.ElectivesDao;
import ua.com.alevel.dao.PupilsDao;
import ua.com.alevel.dao.impl.ElectivesDaoImpl;
import ua.com.alevel.dao.impl.PupilsDaoImpl;
import ua.com.alevel.dto.ElectivesDto;
import ua.com.alevel.entity.Electives;
import ua.com.alevel.entity.Pupils;
import ua.com.alevel.util.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;


public class ElectivesController {

    private final PupilsDao pupilsDao = new PupilsDaoImpl();
    private final ElectivesDao electivesDao = new ElectivesDaoImpl();
    Color.Colors color = new Color.Colors();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(color.BLUE);
        System.out.println("    _________________________________________________________________________");
        System.out.println("    |                                                    Середня школа № 97 |");
        System.out.println("    |                                                    м.Харків           |");
        System.out.println("    |                       Вітаємо, шановний викладач!                     |");
        System.out.println("    | Додати школярів до факультативних занять                             >>");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            cases(bf, select);
        }
    }

    private void menu() {
        System.out.println(color.YELLOW + "    -------------------------------------------------------------------------");
        System.out.println("    | Ви можете обрати наступне:                                            |");
        System.out.println("    |" + color.WHITE + "                                 ФАКУЛЬТАТИВИ             УЧНІ" + color.YELLOW + "         |");
        System.out.println("    | Додати                         >>    1              >>    11          |");
        System.out.println("    | Оновити                        >>    2              >>    22          |");
        System.out.println("    | Видалити                       >>    3              >>    33          |");
        System.out.println("    | Знайти                         >>    4              >>    44          |");
        System.out.println("    | Переглянути                    >>    5              >>    55          |");
        System.out.println("    .........................................................................");
        System.out.println("    | Додати учня до факультативу                         >>     6          |");
        System.out.println("    | Видалити учня з факультативу                        >>     7          |");
        System.out.println("    | Знайти учня за ім'ям/призвищу у факультативі        >>     8          |");
        System.out.println("    | Всі учні за факультативами                          >>     9          |");
        System.out.println("    |" + color.WHITE + " Отримати рейтинг відвідуваності факультативів       >>    10" + color.YELLOW + "          |");
        System.out.println("    .........................................................................");
        System.out.println("    | " + color.RED + "Завершити                                           >>     0" + color.YELLOW + "          |");
        System.out.println(color.YELLOW + "    -------------------------------------------------------------------------");
    }

    private void cases(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> createEl(reader);
            case "2" -> updateEl(reader);
            case "3" -> deleteEl(reader);
            case "4" -> findElById(reader);
            case "5" -> seeAllEls();

            case "11" -> createPupil(reader);
            case "22" -> updatePupil(reader);
            case "33" -> deletePupil(reader);
            case "44" -> findPupilById(reader);
            case "55" -> seeAllPupils();

            case "6"  -> attachPupilToElectives(reader);
            case "7"  -> deletePupilFromElective(reader);
            case "8"  -> existsPupilInElective(reader);
            case "9"  -> pupilsInElectives(reader);
            case "10" -> getRatingAttendance(reader);

            case "0"  -> System.exit(0);
        }
        menu();
    }

    private void createEl(BufferedReader reader) throws IOException {
        System.out.println("Введіть назву факультативу:");
        String name = reader.readLine();
        Electives elective = new Electives();
        elective.setName(name);
        electivesDao.create(elective);
        System.out.println(color.CYAN + "Факультатив додано!" + color.YELLOW);
    }

    private void updateEl(BufferedReader reader) throws IOException {
        System.out.println("Ведіть ID факультативу, який бажаєте оновити: ");
        Long elId = Long.valueOf(reader.readLine());
        System.out.println("Ведіть назву факультативу, який бажаєте оновити:");
        String name = reader.readLine();
        Electives elective = electivesDao.findById(elId);
        elective.setName(name);
        electivesDao.update(elective);
        System.out.println(color.CYAN + "Факультатив оновлено!" + color.YELLOW);
    }

    public void deleteEl(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID факультативу, який бажаєте видалити: ");
        String id = reader.readLine();
        electivesDao.delete(Long.valueOf(id));
        System.out.println(color.RED + "Факультатив видалено!" + color.YELLOW);
    }

    private void findElById(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID факультативу, який бажаєте знайти: ");
        Long elid = Long.valueOf(reader.readLine());
        Electives elective = electivesDao.findById(elid);
        if (elective != null) {
            System.out.println(color.CYAN + "Факультатив: " + color.WHITE + elective + color.YELLOW);
        } else {
            System.out.println("Перевірте введенні данні.");
        }
    }

    private void seeAllEls() {
        Collection<Electives> electives = electivesDao.findAll();
        System.out.println(color.CYAN + "Факультативи:" + color.YELLOW);
        for (Electives elective : electives) {
            if (elective != null) {
                System.out.println(color.WHITE + elective + color.YELLOW);
            }
        }
    }

    private void createPupil(BufferedReader reader) throws IOException {
        System.out.println("Введіть і'мя:");
        String firstName = reader.readLine();
        System.out.println("Введіть призвище:");
        String lastName = reader.readLine();
        System.out.println("Введіть навчальний клас 1 - 11:");
        String stringClas = reader.readLine();
        int clas = Integer.parseInt(stringClas);
        System.out.println("Введіть e-mail:");
        String email = reader.readLine();
        Pupils pupil = new Pupils();
        pupil.setFirstName(firstName);
        pupil.setLastName(lastName);
        pupil.setClas(clas);
        pupil.setEmail(email);
        pupilsDao.create(pupil);
        System.out.println(color.CYAN + "Учня додано!" + color.YELLOW);
    }

    private void updatePupil(BufferedReader reader) throws IOException {
        System.out.println("Ведіть ID учня, якого бажаєте оновити: ");
        Long pupilId = Long.valueOf(reader.readLine());
        System.out.println("Ведіть ім'я учня, якого бажаєте оновити:");
        String firstName = reader.readLine();
        System.out.println("Ведіть призвище учня, якого бажаєте оновити:");
        String lastName = reader.readLine();
        System.out.println("Введіть навчальний клас:");
        int clas = Integer.parseInt(reader.readLine());
        System.out.println("Ведіть e-mail учня, якого бажаєте оновити:");
        String email = reader.readLine();
        Pupils pupil = pupilsDao.findById(pupilId);
        pupil.setFirstName(firstName);
        pupil.setLastName(lastName);
        pupil.setClas(clas);
        pupil.setEmail(email);
        pupilsDao.update(pupil);
        System.out.println(color.CYAN + "Учня оновлено!" + color.YELLOW);
    }

    public void deletePupil(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID учня, якого бажаєте видалити: ");
        String id = reader.readLine();
        pupilsDao.delete(Long.valueOf(id));
        System.out.println(color.RED + "Учня видалено!" + color.YELLOW);
    }

    private void findPupilById(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID учня, якого бажаєте знайти: ");
        Long pupilid = Long.valueOf(reader.readLine());
        Pupils pupil = pupilsDao.findById(pupilid);
        if (pupil != null) {
            System.out.println(color.CYAN + "Учень: " + color.WHITE + pupil + color.YELLOW);
        } else {
            System.out.println("Перевірте введенні данні.");
        }
    }

    private void seeAllPupils() {
        Collection<Pupils> pupils = pupilsDao.findAll();
        System.out.println(color.CYAN + "Учні:" + color.YELLOW);
        for (Pupils pupil : pupils) {
            if (pupil != null) {
                System.out.println(color.WHITE + pupil + color.YELLOW);
            }
        }
    }

    public void attachPupilToElectives(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID факультативу, до якого бажаєте приєднати учня: ");
        Long electiveId = Long.valueOf(reader.readLine());
        System.out.println("Введіть ID учня, якого бажаєте приєднати до факультативу: ");
        String pupilId = reader.readLine();
        electivesDao.attachPupilsToElectives(electiveId, Long.valueOf(pupilId));
        System.out.println(color.CYAN + "Учня з ID " + Long.valueOf(pupilId) + " додано до факультативу з ID " + electiveId + color.YELLOW);
    }

    public void deletePupilFromElective(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID факультативу, з якого бажаєте видалити учня: ");
        Long electiveId = Long.valueOf(reader.readLine());
        System.out.println("Введіть ID учня, якого бажаєте видалити з факультативу: ");
        String pupilId = reader.readLine();
        electivesDao.detachPupilsToElectives(electiveId, Long.valueOf(pupilId));
        System.out.println(color.RED + "Учня з ID " + Long.valueOf(pupilId) + " видалено із факультативу з ID " + electiveId + color.YELLOW);
    }

    public void existsPupilInElective(BufferedReader reader) throws IOException {
        System.out.println("Введіть ім'я учня: ");
        String firstName = reader.readLine();
        System.out.println("Введіть призвище учня: ");
        String lastName = reader.readLine();
        boolean pupils = pupilsDao.existsByFirstNameOrLastName(firstName, lastName);
        System.out.println(pupils);
    }

    public void getRatingAttendance(BufferedReader reader) throws IOException {
        Collection<ElectivesDto> electiveStatistics = electivesDao.findElectivesStatistics();
        if (electiveStatistics.isEmpty()) {
            System.out.println("Статистики ще немає");
        } else {
            int ratingNumber = 1;
            System.out.println(color.CYAN + "Рейтинг відвідуваності факультативів:" + color.YELLOW);
            for (ElectivesDto electivesDto : electiveStatistics) {
                System.out.println(color.RED + ratingNumber + ". " + color.YELLOW + electivesDto.toString());
                ratingNumber++;
            }
        }
    }

//    public void pupilsInElectives(BufferedReader reader) throws IOException {
//        Collection<ElectivesDto> pupilsInElectives = electivesDao.findPupilsByElectives();
//        if (pupilsInElectives.isEmpty()) {
//            System.out.println("Статистики ще немає");
//        } else {
//            System.out.println(color.CYAN + "Факультативіви та учні:" + color.YELLOW);
//            for (ElectivesDto electivesDto : pupilsInElectives) {
//                System.out.println(electivesDto.toString());
//            }
//        }
////        electivesDao.findPupilsByElectives();
//    }
    private void pupilsInElectives(BufferedReader reader) throws IOException {
        Collection<ElectivesDto> electives = electivesDao.findPupilsByElectives();
        for (ElectivesDto elective : electives) {
            if (elective != null) {
                System.out.println("- " + elective);
            }
        }
    }
}