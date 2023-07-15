package ua.com.alevel.util;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.web.context.request.WebRequest;

import ua.com.alevel.data.datatable.DataTableRequest;

import java.util.Map;

public final class WebRequestUtil {

    private final static int DEFAULT_PAGE = 0;
    private final static int DEFAULT_SIZE = 10;
    private final static String DEFAULT_SORT = "desc";
    private final static String DEFAULT_ORDER = "id";

    private final static String DEFAULT_PAGE_PARAM = "page";
    private final static String DEFAULT_SIZE_PARAM = "size";
    private final static String DEFAULT_SORT_PARAM = "sort";
    private final static String DEFAULT_ORDER_PARAM = "order";

    private WebRequestUtil() { }    // утилита для стандартных запросов в Контроллерах

    public static DataTableRequest generateDataTableRequest(WebRequest webRequest) {
        int page = DEFAULT_PAGE;
        int size = DEFAULT_SIZE;
        String sort = DEFAULT_SORT;
        String order = DEFAULT_ORDER;
        // проверяет по ключу Стринг и велью Массив стрингов т.к. в запросе если выставляются фильтры то это уже массив
        Map<String, String[]> parameterMap = webRequest.getParameterMap(); // загоняем параметры в Мапу
        // Массив строк необходим для того, что параметры могут идти через запятую (перечень) id, name, something
        // чтоб строку потом не разбивать (проверять) .split (Сплитом), в Спринке сделали webRequest как
        // Map<String, String[]> коорый возвращает массив строк getParameterMap()
        if (MapUtils.isNotEmpty(parameterMap)) {    // если не пустая мапа (а реквест это мапа, как в Постмене писали параметры через амперсанты)
            // метод проверки isNotEmpty от апечевской библиотеки MapUtils
            String[] pageParams = parameterMap.get(DEFAULT_PAGE_PARAM); // проверка наличия по ключу пейдж
            if (ArrayUtils.isNotEmpty(pageParams)) { // если массив не пустой, то
                String pageParam = pageParams[0];   // берем первый
                if (StringUtils.isNumericSpace(pageParam)) { // если массив номер
                    page = Integer.parseInt(pageParam); // персит в интеджер
                }
            }
            String[] sizeParams = parameterMap.get(DEFAULT_SIZE_PARAM); // и так по всем 4м полям повторяется
            if (ArrayUtils.isNotEmpty(sizeParams)) {
                String sizeParam = sizeParams[0];
                if (StringUtils.isNumericSpace(sizeParam)) {
                    size = Integer.parseInt(sizeParam);
                }
            }
            String[] sortParams = parameterMap.get(DEFAULT_SORT_PARAM);
            if (ArrayUtils.isNotEmpty(sortParams)) {
                sort = sortParams[0];
            }
            String[] orderParams = parameterMap.get(DEFAULT_ORDER_PARAM);
            if (ArrayUtils.isNotEmpty(orderParams)) {
                order = orderParams[0];
            }
        }
        DataTableRequest request = new DataTableRequest();  // после проверок формируем запрос
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return request; // и возвращаем запрос
    }
}