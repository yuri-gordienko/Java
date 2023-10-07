package yugo.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import yugo.dto.EnglishGrammarBotDto;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class EnglishGrammarBotReaderService {

    public List<EnglishGrammarBotDto> getDataFromCsv (String filename) {
        Resource resource = new ClassPathResource(filename);

        try (InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream(),
                StandardCharsets.UTF_8)) {
            CsvToBean<EnglishGrammarBotDto> csvToBean = new CsvToBeanBuilder<EnglishGrammarBotDto>(inputStreamReader)
                    .withType(EnglishGrammarBotDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + filename, e);
        }
    }
}
