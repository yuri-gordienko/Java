package yugo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments") // а вот без этой аннотации обойтись можно, по дефолту Hibernate будет называть именем джава класса
public class Department extends BaseEntity {

    private String name;

    @ManyToMany  // може бути багато департаментів, і в кожному з них багато працівників
    @JoinTable(
            name = "dep_emp",
            joinColumns = @JoinColumn(name = "dep_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    private Set<Employee> employees = new HashSet<>();

//    @JoinTable - потрібно Hibernate пояснити, який клас є базою для 3ї таблиці, описуємо алгоритм генерації 3ї таблиці
//    name = "dep_emp" - даємо назву 3ю таблиці
//    joinColumns - пояснюємо яка колонка головна і як її назвати
//    inverseJoinColumns - пояснюємо яка колонка другорядна
// Hibernate: create table dep_emp (dep_id bigint not null, emp_id bigint not null, primary key (dep_id, emp_id)) engine=InnoDB
// Hibernate: alter table dep_emp add constraint FK60u8r0gfanjepg3oydsg53bko foreign key (emp_id) references employees (id)
// Hibernate: alter table dep_emp add constraint FKnvkwny1yj266gyeangkej3qdj foreign key (dep_id) references departments (id)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
