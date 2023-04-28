package ua.com.alevel.controller;

import ua.com.alevel.dao.PupilsDao;
import ua.com.alevel.dao.ElectivesDao;
import ua.com.alevel.dao.impl.ElectivesDaoImpl;
import ua.com.alevel.dao.impl.PupilsDaoImpl;
import ua.com.alevel.dto.ElectivesDto;
import ua.com.alevel.entity.Electives;
import ua.com.alevel.entity.Pupils;
import ua.com.alevel.service.ElectiveService;
import ua.com.alevel.service.PupilsService;
import ua.com.alevel.service.impl.ElectiveServiceImpl;
import ua.com.alevel.service.impl.PupilsServiceImpl;
import ua.com.alevel.util.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import static ua.com.alevel.util.Enum.Enums.*;

public class ElectivesController {

    private final PupilsService pupilsService = new PupilsServiceImpl();
    private final ElectiveService electivesService = new ElectiveServiceImpl();
    private final ElectivesDao electivesDao = new ElectivesDaoImpl();
    private final PupilsDao pupilsDao = new PupilsDaoImpl();
    Color.Colors color = new Color.Colors();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(color.BLUE);
        System.out.println("    _________________________________________________________________________");
        System.out.println("    |" + color.PURPLE + "                            A-LEVEL Ukraine" + color.BLUE + "                            |");
        System.out.println("    |" + color.PURPLE + "                                                             iT-освіта" + color.BLUE + " |");
        System.out.println("    |                        База даних освітніх курсів                     |");
        System.out.println("    | Напрямок ПРОГРАМУВАННЯ                                               >>");
        String select;
        menu();
        createEl();
        while ((select = bf.readLine()) != null) {
            cases(bf, select);
        }
    }

    private void menu() {
        System.out.println(color.BLUE + "    -------------------------------------------------------------------------");
        System.out.println(color.YELLOW + "    | Шановний менеджер, додайте студентів до курсів згідно отриманих заявок:");
        System.out.println("    |" + color.WHITE + "                                    КУРСИ                 УЧНІ" + color.YELLOW + "         |");
        System.out.println("    | Додати                    >>    " + color.GREEN + "завантажено" + color.YELLOW + "       >>      11          |");
        System.out.println("    | Редагувати                >>    немає  прав       >>      22          |");
        System.out.println("    | Видалити                  >>    немає  прав       >>      33          |");
        System.out.println("    | Знайти                    >>         4            >>      44          |");
        System.out.println("    | Переглянути               >>         5            >>      55          |");
        System.out.println("    .........................................................................");
        System.out.println("    | Додати студента до курсу                          >>       6          |");
        System.out.println("    | Видалити студента з курсу                         >>       7          |");
        System.out.println("    | Переглянути студентів, закріплених за курсом      >>       8          |");
        System.out.println("    | Переглянути курси, закріплені за студентом        >>       9          |");
        System.out.println("    | Отримати рейтинг відвідуваності курсів            >>      10          |");
        System.out.println("    .........................................................................");
        System.out.println("    | " + color.RED + "Вихід                                             >>       0" + color.YELLOW + "          |");
        System.out.println(color.YELLOW + "    -------------------------------------------------------------------------");
    }

    private void cases(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "4" -> findElById(reader);
            case "5" -> seeAllEls();

            case "11" -> createPupil(reader);
            case "22" -> updatePupil(reader);
            case "33" -> deletePupil(reader);
            case "44" -> findPupilById(reader);
            case "55" -> seeAllPupils();

            case "6"  -> attachPupilToElectives(reader);
            case "7"  -> deletePupilFromElective(reader);
            case "8"  -> seeAllPupilsByElective(reader);
            case "9"  -> seeAllElectivesByPupil(reader);
            case "10" -> getRatingAttendance(reader);

            case "0"  -> System.exit(0);
        }
        menu();
    }

    private void createEl() {
        Electives elective = new Electives();
        elective.setName(GOLANG);
        electivesService.create(elective);
        elective.setName(NET);
        electivesService.create(elective);
        elective.setName(BASIC);
        electivesService.create(elective);
        elective.setName(JAVA);
        electivesService.create(elective);
        elective.setName(PYTHON);
        electivesService.create(elective);
        elective.setName(FRONT);
        electivesService.create(elective);
        System.out.println(color.GREEN + "Курси завантажені, можете працювати..." + color.YELLOW);
    }

    private void findElById(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID курсу, який бажаєте знайти: ");
        Long elId = Long.valueOf(reader.readLine());
        Electives elective = electivesService.findById(elId);
        if (elective != null) {
            System.out.println(color.CYAN + "Курс: " + color.WHITE + elective + color.YELLOW);
        } else {
            System.out.println("ID не коректний, перевірте введенні данні.");
        }
    }

    private void seeAllEls() {
        Collection<Electives> electives = electivesService.findAll();
        System.out.println(color.CYAN + "Курси:" + color.YELLOW);
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
        System.out.println("Початковий рівень знань студента:");
        System.out.println("Введіть оцінку, отриману студентом за пройдений вступний тест 1 - 5:");
        String stringClas = reader.readLine();
        int mark = Integer.parseInt(stringClas);
        System.out.println("Введіть e-mail:");
        String email = reader.readLine();
        Pupils pupil = new Pupils();
        pupil.setFirstName(firstName);
        pupil.setLastName(lastName);
        pupil.setMark(mark);
        pupil.setEmail(email);
        pupilsService.create(pupil);
        System.out.println(color.CYAN + "Студента додано!" + color.YELLOW);
    }

    private void updatePupil(BufferedReader reader) throws IOException {
        System.out.println("Ведіть ID студента, якого бажаєте оновити: ");
        Long pupilId = Long.valueOf(reader.readLine());
        Pupils pupil = new Pupils();
        System.out.println("Ведіть ім'я студента, якого бажаєте оновити:");
        String firstName = reader.readLine();
        System.out.println("Ведіть призвище студента, якого бажаєте оновити:");
        String lastName = reader.readLine();
        System.out.println("Введіть оцінку, отриману студентом за пройдений вступний тест 1 - 5:");
        int mark = Integer.parseInt(reader.readLine());
        System.out.println("Ведіть e-mail студента, якого бажаєте оновити:");
        String email = reader.readLine();
        pupil.setFirstName(firstName);
        pupil.setLastName(lastName);
        pupil.setMark(mark);
        pupil.setEmail(email);
        pupil.setUpdated(new Date());
        pupilsService.update(pupil, pupilId);
        System.out.println(color.CYAN + "Студента оновлено!" + color.YELLOW);
    }

    public void deletePupil(BufferedReader reader) throws IOException {
        try {
            System.out.println("Введіть ID студента, якого бажаєте видалити: ");
            Long pupilsid = Long.valueOf(reader.readLine());
            Pupils pupil = pupilsService.findById(pupilsid);
            pupilsService.delete(pupil);
            System.out.println(color.RED + "Студента видалено!" + color.YELLOW);
        } catch (SecurityException e) {
            System.out.println("Не коректний ID, спробуйте інший.");
        } catch (Exception e) {
            System.out.println("Unknown error.");
        }
    }

    private void findPupilById(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID студента, якого бажаєте знайти: ");
        Long pupilid = Long.valueOf(reader.readLine());
        Pupils pupil = pupilsService.findById(pupilid);
        if (pupil != null) {
            System.out.println(color.CYAN + "Студент: " + color.WHITE + pupil + color.YELLOW);
        } else {
            System.out.println("ID не коректний, перевірте введенні данні.");
        }
    }

    private void seeAllPupils() {
        Collection<Pupils> pupils = pupilsService.findAll();
        System.out.println(color.CYAN + "Студенти:" + color.YELLOW);
        for (Pupils pupil : pupils) {
            if (pupil != null) {
                System.out.println(color.WHITE + pupil + color.YELLOW);
            }
        }
    }

    public void attachPupilToElectives(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID курсу, до якого бажаєте приєднати студента: ");
        Long electiveId = Long.valueOf(reader.readLine());
        System.out.println("Введіть ID студента, якого бажаєте приєднати до курсу: ");
        Long pupilId = Long.valueOf(reader.readLine());
        Electives electives = electivesService.findById(electiveId);
        Pupils pupils = pupilsService.findById(pupilId);
        electivesDao.attachPupilsToElectives(electives, pupils);
        System.out.println(color.CYAN + "Студента з ID: " + Long.valueOf(pupilId) + " додано до курсу з ID: " + electiveId + color.YELLOW);
    }

    public void deletePupilFromElective(BufferedReader reader) throws IOException {
        System.out.println("Введіть ID курсу, з якого бажаєте видалити студента: ");
        Long electiveId = Long.valueOf(reader.readLine());
        System.out.println("Введіть ID студента, якого бажаєте видалити з курсу: ");
        Long pupilId = Long.valueOf(reader.readLine());
        Electives electives = electivesService.findById(electiveId);
        Pupils pupils = pupilsService.findById(pupilId);
        electivesDao.detachPupilsToElectives(electives, pupils);
        System.out.println(color.RED + "Студента з ID: " + Long.valueOf(pupilId) + " видалено із курсу з ID: " + electiveId + color.YELLOW);
    }

    private void seeAllPupilsByElective(BufferedReader reader) throws IOException {
        System.out.println(color.CYAN + "Переглянути усіх студентів за курсом  >>");
        seeAllEls();
        System.out.println("------------------------------------------------------------");
        System.out.println("Ведіть ID курсу, щоб отримати перелік закріплених студентів:");
        String elId = reader.readLine();
        try {
            Set<Pupils> pupils = electivesDao.findById(Long.valueOf(elId)).get().getPupil();
            System.out.println(color.CYAN + "Студенти:" + color.YELLOW);
            for (Pupils pupil : pupils) {
                if (pupils != null) {
                    System.out.println(color.WHITE + pupil.toString() + color.YELLOW);
                } else {
                    System.out.println(color.RED + "За даним курсом студенти не закріплені." + color.YELLOW);
                }
            }
        } catch(Exception e){
            System.out.println(color.RED + "Курсу з таким ID не існує, перевірте коректність ID." + color.YELLOW);
            start();
        }
    }

    private void seeAllElectivesByPupil(BufferedReader reader) throws IOException {
        System.out.println(color.CYAN + "Переглянути усі курси, за якими закріплений студент  >>");
        seeAllPupils();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Ведіть ID студента, щоб отримати перелік закріплених за ним курсів:");
        String pupId = reader.readLine();
        System.out.println(color.CYAN + "Курси:" + color.YELLOW);
        try {
            Set<Electives> electives = pupilsDao.findById(Long.valueOf(pupId)).get().getElctive();
            for (Electives elective : electives) {
                if (electives != null) {
                    System.out.println(color.WHITE + elective.toString() + color.YELLOW);
                } else {
                    System.out.println(color.RED + "За даним студентом курси ще не закріплені." + color.YELLOW);
                }
            }
        } catch(Exception e){
            System.out.println(color.RED + "Студента з таким ID не існує, перевірте коректність ID." + color.YELLOW);
            start();
        }
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
}