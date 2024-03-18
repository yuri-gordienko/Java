package ua.com.alevel.persistence.elasticsearch.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "querytables")
public class QueryTable {

    @Id
    private String id;

    @Field(name = "queryInfo", type = FieldType.Text)
    private String queryInfo;
}
