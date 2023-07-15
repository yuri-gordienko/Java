package ua.com.alevel.persistence.elasticsearch.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "productindex")   // в терминах эластика indexName - таблица
public class ProductIndex {

    @Id     // первичный ключ
    private String id;

    @Field(name = "productInfo", type = FieldType.Text) // @Field = @Column, по этому полю будем собирать инфу по ноуту
    private String productInfo; // ячейка, в которой храниться инфо про продукту (название, процик и т.п), выпадает в поиске
}