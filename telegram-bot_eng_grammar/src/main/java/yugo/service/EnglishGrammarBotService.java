package yugo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import yugo.dto.EnglishGrammarBotDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnglishGrammarBotService {

    private final Map<String, EnglishGrammarBotDto> tenses = new HashMap<>();

    @PostConstruct
    private void init() {
        EnglishGrammarBotDto eg = new EnglishGrammarBotDto();
        eg.setId("1");
        eg.setTense("Present 1");
        eg.setShortDescription("descrip for 1");
        tenses.put("1", eg);


        eg.setId("2");
        eg.setTense("Present 2");
        eg.setShortDescription("descrip for 2");
        tenses.put("2", eg);
    }


    public List<EnglishGrammarBotDto> getPresentSpecifically() {
        return tenses.values().stream()
                .filter(v -> v.getTense()
                .toLowerCase()
                .contains("present"))
                .toList();
    }

    public List<EnglishGrammarBotDto> getPastSpecifically() {
        return tenses.values().stream()
                .filter(v -> v.getTense()
                .toLowerCase()
                .contains("past"))
                .toList();
    }

    public List<EnglishGrammarBotDto> getFutureSpecifically() {
        return tenses.values().stream()
                .filter(v -> v.getTense()
                .toLowerCase()
                .contains("future"))
                .toList();
    }

    public EnglishGrammarBotDto get(String id) {
        return tenses.get(id);
    }

}
