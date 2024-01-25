package yugo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "balances")
public class Balance extends BaseEntity {

    private Long salary;

    @OneToOne
    private Employee employee;  // додаємо обʼєкт, який привʼязуємо до таблиці "balances" через поле employee_id з foreign key

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long balance) {
        this.salary = balance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

//  @OneToOne - коли є 2 сутності і вони знають один про одну, але у одної сутності може бути лише одна сутність
//Hibernate: create table balances (id bigint not null auto_increment, salary bigint, employee_id bigint, primary key (id))
//Hibernate: alter table balances add constraint FKjjt6gaxsdvyaw6m3f02bfluni foreign key (employee_id) references employees (id)
// employee_id може зустрічатися лише 1 раз і balances id може бути лише один
// наприклад, у мене є один рахунок і він тільки мій, відповідно у мого рахунку тільки я
// у мене є донька і вона тільки моя, у моєї доньки є тільки один справжній папа

