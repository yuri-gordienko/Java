package yugo.facade;

import yugo.data.datatable.DataTableRequest;
import yugo.data.datatable.DataTableResponse;
import yugo.data.dto.BaseDto;

public interface CrudFacade<DTO extends BaseDto> {

    void create(DTO dto);
    void update(Long id, DTO dto);
    void delete(Long id);
    DTO findById(Long id);
    DataTableResponse<DTO> findAll(DataTableRequest request);
}
