package ua.com.alevel.data.datatable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTableRequest {

    private int page;
    private int size;
    private String sort;
    private String order;
}
