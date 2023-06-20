package ua.com.alevel.service.csv;

import au.com.bytecode.opencsv.CSVWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.product.ProductVariantRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ExportCSVService {

    private final ProductVariantRepository productVariantRepository;

    public void export() {
        List<ProductVariant> productVariants = productVariantRepository.findAll(); // достали все продуктварианты
        List<String[]> list = productVariants   // создали лист массива стрингов
                .stream()
                .map(productVariant -> new String[] {   // генерируем позиции для экспорта из базы поставщика в нашу базу
                        productVariant.getCode(),
                        productVariant.getPrice().toString(),
                        productVariant.getQuantity().toString()
                })
                .toList();  // генерируем лист
        try(CSVWriter csvWriter = new CSVWriter(new FileWriter("products.csv"))) {  // пишем в csv данные от поставщика
            csvWriter.writeAll(list);   // записали
            csvWriter.flush();  // сохранили
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}