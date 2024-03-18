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
        List<ProductVariant> productVariants = productVariantRepository.findAll();
        List<String[]> list = productVariants
                .stream()
                .map(productVariant -> new String[] {
                        productVariant.getCode(),
                        productVariant.getPrice().toString(),
                        productVariant.getQuantity().toString()
                })
                .toList();
        try(CSVWriter csvWriter = new CSVWriter(new FileWriter("products.csv"))) {
            csvWriter.writeAll(list);
            csvWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
