package ua.com.alevel.service;

import au.com.bytecode.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Product;
import ua.com.alevel.repository.ProductRepository;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ImportProductToCsvService {

    private final ProductRepository productRepository;

    public void importCsv() {
        try(CSVReader csvReader = new CSVReader(new FileReader("products.csv"))) {
            List<String[]> list = csvReader.readAll();
            List<Product> products = new ArrayList<>();
            if (!list.isEmpty()) {
                for (String[] elements : list) {
                    Product product = new Product();
                    product.setCode(elements[0]);
                    product.setPrice(generateRandomBigDecimalFromRange(new BigDecimal("100.00"), new BigDecimal("400.00")));
                    product.setQuantity(new Random().nextInt(0, 20));
                    products.add(product);
                }
            }
            productRepository.saveAll(products);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
