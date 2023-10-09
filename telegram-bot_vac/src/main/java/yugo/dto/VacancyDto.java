package yugo.dto;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacancyDto {

    @CsvBindByName(column = "Id")   // необхідні для того, щоб Спрінг правильно витягував дані з csv файла
    private String id;

    @CsvBindByName(column = "Title")    // щоб знав з якої коллонки в csv файлі брати дані для вставки
    private String title;

    @CsvBindByName(column = "Short description")    // колонки в csv файлі можуть називатися не як фiлди в DTO
    private String shortDescription;

    @CsvBindByName(column = "Long description")
    private String longDescription;

    @CsvBindByName(column = "Company")
    private String company;

    @CsvBindByName(column = "Salary")
    private String salary;

    @CsvBindByName(column = "Link")
    private String link;
}
