package ua.com.alevel.facade.crud;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.BaseDto;

public interface CrudFacade<DTO extends BaseDto> {

    void create(DTO dto);
    void update(Long id, DTO dto);
    void delete(Long id);
    DTO findById(Long id);
    DataTableResponse<DTO> findAll(DataTableRequest request);
}
