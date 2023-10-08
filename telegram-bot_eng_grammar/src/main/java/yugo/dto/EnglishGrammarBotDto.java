package yugo.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnglishGrammarBotDto {

    @CsvBindByName(column = "Id")
    private String id;

    @CsvBindByName(column = "Tense")
    private String tense;

    @CsvBindByName(column = "Short description")
    private String shortDescription;

    @CsvBindByName(column = "Example")
    private String example;

    @CsvBindByName(column = "Explanation")
    private String explanation;
}
