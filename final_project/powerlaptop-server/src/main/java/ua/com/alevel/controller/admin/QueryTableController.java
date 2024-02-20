package ua.com.alevel.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.service.crud.product.QueryTableService;

import java.util.Collection;

@RestController
@RequestMapping("/api/private/admin/products/query-table")
public class QueryTableController {

    private final QueryTableService queryTableService;

    public QueryTableController(QueryTableService queryTableService) {
        this.queryTableService = queryTableService;
    }

    @GetMapping
    public ResponseEntity<DataContainer<Collection<String>>> findAll() {
        return ResponseEntity.ok(new DataContainer<>(queryTableService.findAll()));
    }
}
