package ua.com.alevel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // указываем, что здесь эндпоинты для AppStart
@RequestMapping("/") // адрес конкретного эндпоинта
public class DemoController {

    @GetMapping // указываем, что это Get запрос
    public String demo() {
        return "index"; // говорим, что вернуть из папки templates файл index.html
    }
}
















