package yugo.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnglishGrammarBotDto {

    @CsvBindByName(column = "Id")
    String id;

    @CsvBindByName(column = "Tense")
    String tense;

    @CsvBindByName(column = "Short description")
    String shortDescription;
}
