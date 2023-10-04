package yugo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yugo.dto.VacancyDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VacancyService {

    @Autowired
    private VacancyReaderService vacancyReaderService;

    private final Map<String, VacancyDto> vacancies = new HashMap<>(); // создаем коллекцию для сохранения вакансий

    @PostConstruct
    private void init() {

        List<VacancyDto> list = vacancyReaderService.getVacanciesFromFile("vacancies.csv");
        for (VacancyDto vacancy : list){
            vacancies.put(vacancy.getId(), vacancy);
        }

        // Ручное создание вакансий
//        VacancyDto juniorAm = new VacancyDto();
//        juniorAm.setId("15");
//        juniorAm.setTitle("Junior java dev at Amazon");
////        juniorAm.setShortDescription("from half year experience");
//        juniorAm.setShortDescription("https://e1.pxfuel.com/desktop-wallpaper/202/582/desktop-wallpaper-indian-boy-pic-indian-boy.jpg");
//        sendMessage.disableWebPagePreview(); // деактивация превью вебстраниц
//        vacancies.put("15", juniorAm);
//
//        VacancyDto juniorGoo = new VacancyDto();
//        juniorGoo.setId("2");
//        juniorGoo.setTitle("Junior java dev at Google");
//        juniorGoo.setShortDescription("from 1 year experience");
//        vacancies.put("2", juniorGoo);
//
//        VacancyDto midEp = new VacancyDto();
//        midEp.setId("3");
//        midEp.setTitle("Middle java dev at EPAM");
//        midEp.setShortDescription("from 2 years experience");
//        vacancies.put("3", midEp);
//
//        VacancyDto midSs = new VacancyDto();
//        midSs.setId("4");
//        midSs.setTitle("Middle java dev at Soft Serve");
//        midSs.setShortDescription("from 1 years experience");
//        vacancies.put("4", midSs);
//
//        VacancyDto senPb = new VacancyDto();
//        senPb.setId("5");
//        senPb.setTitle("Senior java dev at Privat bank");
//        senPb.setShortDescription("from 5 years experience");
//        vacancies.put("5", senPb);
//
//        VacancyDto senNix = new VacancyDto();
//        senNix.setId("6");
//        senNix.setTitle("Senior java dev at NIX");
//        senNix.setShortDescription("from 4 years experience");
//        vacancies.put("6", senNix);
    }

    public VacancyDto get(String id) { // вытаскиваем вакансии, на вход принимаем идентификатор
        return vacancies.get(id);   // возвращаем по идентификатору из Мапы
    }

    public List<VacancyDto> getJunVac() {   // создаем лист для получения вакансий, заранее сколько их не знаем
        return vacancies.values().stream()  // возвращаем мапу с вакансиями
                .filter(v -> v.getTitle()   // получаем все заголовки
                .toLowerCase()              // переводим в нижний регистр
                .contains("junior"))        // проверяем на содержание ключевого слова "junior"
                .toList();                  // формируем список
    }

    public List<VacancyDto> getMidVac() {
        return vacancies.values().stream()
                .filter(v -> v.getTitle()
                .toLowerCase()
                .contains("middle"))
                .toList();
    }

    public List<VacancyDto> getSeniorVac() {
        return vacancies.values().stream()
                .filter(v -> v.getTitle()
                .toLowerCase()
                .contains("senior"))
                .toList();
    }
}
