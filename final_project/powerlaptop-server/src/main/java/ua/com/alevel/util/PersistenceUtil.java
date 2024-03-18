package ua.com.alevel.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ua.com.alevel.data.datatable.DataTableRequest;

public final class PersistenceUtil {

    private PersistenceUtil() { }

    public static Pageable generatePageableByDataTableRequest(DataTableRequest request) {
        Sort sort = request.getSort().equals("desc")
                ? Sort.by(request.getOrder()).descending()
                : Sort.by(request.getOrder()).ascending();
        return PageRequest.of(request.getPage(), request.getSize(), sort);
    }
}
