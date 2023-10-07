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

    @Autowired
    private EnglishGrammarBotReaderService englishGrammarBotReaderService;

    private final Map<String, EnglishGrammarBotDto> tenses = new HashMap<>();

    @PostConstruct
    private void init() {

        List<EnglishGrammarBotDto> list = englishGrammarBotReaderService.getDataFromCsv("tenses.csv");

        for (EnglishGrammarBotDto tense : list) {
            tenses.put(tense.getId(), tense);
        }

//        EnglishGrammarBotDto presentSimple = new EnglishGrammarBotDto();
//        presentSimple.setId("1");
//        presentSimple.setTense("P.Simple");
//        presentSimple.setShortDescription("I write an article - Я пишу статтю.\n" +
//                "* Не прямо зараз, а взагалі. Звичайна повторювана дія.");
//        tenses.put("1", presentSimple);
//
//        EnglishGrammarBotDto presentSimple2 = new EnglishGrammarBotDto();
//        presentSimple2.setId("3");
//        presentSimple2.setTense("p.continuous");
//        presentSimple2.setShortDescription("Present simple is .......");
//        tenses.put("3", presentSimple2);
//
//        EnglishGrammarBotDto presentSimple3 = new EnglishGrammarBotDto();
//        presentSimple3.setId("4");
//        presentSimple3.setTense("p.perfect");
//        presentSimple3.setShortDescription("Present simple is .......");
//        tenses.put("4", presentSimple3);
//
//        EnglishGrammarBotDto presentSimple4 = new EnglishGrammarBotDto();
//        presentSimple4.setId("5");
//        presentSimple4.setTense("p.Perfect continuous");
//        presentSimple4.setShortDescription("Present simple is .......");
//        tenses.put("5", presentSimple4);
//
//        EnglishGrammarBotDto pastCont = new EnglishGrammarBotDto();
//        pastCont.setId("2");
//        pastCont.setTense("Past Continuous");
//        pastCont.setShortDescription("Past cont is..........");
//        tenses.put("2", pastCont);
//
//
//    EnglishGrammarBotDto futureCont = new EnglishGrammarBotDto();
//        futureCont.setId("10");
//        futureCont.setTense("Future Continuous");
//        futureCont.setShortDescription("Past cont is..........");
//        tenses.put("10", futureCont);
    }


    public List<EnglishGrammarBotDto> getPresentSpecifically() {
        return tenses.values().stream()
                .filter(v -> v.getTense()
                .toLowerCase()
                .contains("junior"))
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
