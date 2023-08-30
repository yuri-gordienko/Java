package yugo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import yugo.dto.VacancyDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VacancyService {

    private final Map<String, VacancyDto> vacancies = new HashMap<>(); // создаем коллекцию для сохранения вакансий

    @PostConstruct
    private void init() {
        VacancyDto juniorAm = new VacancyDto();
        juniorAm.setId("1");
        juniorAm.setTitle("Junior java dev at Amazon");
        juniorAm.setShortDescription("from half year experience");
        vacancies.put("1", juniorAm);

        VacancyDto juniorGoo = new VacancyDto();
        juniorGoo.setId("2");
        juniorGoo.setTitle("Junior java dev at Google");
        juniorGoo.setShortDescription("from 1 year experience");
        vacancies.put("2", juniorGoo);

        VacancyDto midEp = new VacancyDto();
        midEp.setId("3");
        midEp.setTitle("Middle java dev at EPAM");
        midEp.setShortDescription("from 2 years experience");
        vacancies.put("3", midEp);
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
}
