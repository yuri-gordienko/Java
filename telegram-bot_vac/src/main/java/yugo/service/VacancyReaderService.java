package yugo.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import yugo.dto.VacancyDto;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class VacancyReaderService {

    public List<VacancyDto> getVacanciesFromFile(String fileName) { // метод повертає список об'єктів з файлу
        Resource resource = new ClassPathResource(fileName);    // створили об'єкт і файл представлен у вигляді ресурсу,
        // з нього і будемо читати

        try (InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream(), // об'єкт читає дані
                StandardCharsets.UTF_8)) { // з файлу та перетворює їх на масив байтів
            CsvToBean<VacancyDto> csvToBean = new CsvToBeanBuilder<VacancyDto>(inputStreamReader) // читає байти та
                    // перетворює їх на об'єкти, з якими будемо працювати, а саме об'єкти DTO
                    .withType(VacancyDto.class)  // створюємо об'єкт
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();   //  повертаємо список DTO
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + fileName, e);
        }
    }
}

