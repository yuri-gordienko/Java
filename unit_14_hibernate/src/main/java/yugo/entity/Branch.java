package yugo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "branches")
public class Branch extends BaseEntity {

    private String name;

    @ManyToOne
    private Employee employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

//  @ManyToOne - в такому випадку тільки одна таблиця знає про другу (Branch знає про Employee)
//Hibernate: create table branches (id bigint not null auto_increment, name varchar(255), employee_id bigint, primary key (id)) engine=InnoDB
//Hibernate: alter table branches add constraint FKop4sqao1ulbo1dr3to3khtmm0 foreign key (employee_id) references employees (id)
//  employee_id може зустрічатися багато разів, у той час коли branches id лише 1 раз
// багато філій веде один керівник