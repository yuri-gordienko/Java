package ua.com.alevel.facade.process;

import ua.com.alevel.data.dto.product.ProductProcessDto;

public interface ProductProcessFacade { // необходим чтоб приатачить к продукту картинки и продукт-вариант

    void attach(Long id, ProductProcessDto dto);
    void detach(Long id, ProductProcessDto dto);
}

// в методах указываем что нужно обработать ProductProcessDto, а чтоб понять с каким продуктом работать - указываем id
