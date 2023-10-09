package yugo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yugo.dto.EnglishGrammarBotDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnglishGrammarBotService {

    private final Map<String, EnglishGrammarBotDto> tenses = new HashMap<>();

    @Autowired
    private EnglishGrammarBotReaderService englishGrammarBotReaderService;

    @PostConstruct
    private void init() {

        List<EnglishGrammarBotDto> list = englishGrammarBotReaderService.getDataFromCsv("tenses.csv");

        for (EnglishGrammarBotDto tense : list) {
            tenses.put(tense.getId(), tense);
        }
    }

    public List<EnglishGrammarBotDto> getPresentSpecifically() {
        return tenses.values().stream()
                .filter(v -> v.getTense()
                .toLowerCase()
                .contains("^"))
                .toList();
    }

    public List<EnglishGrammarBotDto> getPastSpecifically() {
        return tenses.values().stream()
                .filter(v -> v.getTense()
                .toLowerCase()
                .contains("<"))
                .toList();
    }

    public List<EnglishGrammarBotDto> getFutureSpecifically() {
        return tenses.values().stream()
                .filter(v -> v.getTense()
                .toLowerCase()
                .contains(">"))
                .toList();
    }

    public EnglishGrammarBotDto get(String id) {
        return tenses.get(id);
    }
}
