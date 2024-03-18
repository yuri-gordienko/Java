package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.repository.BaseRepository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface AccountRepository extends BaseRepository<Account> {

    Collection<Account> findAccountsByClientId(Long id);

    Optional<Account> findAccountByAccountNumber(int accountNumber);
}

// Варианты специфических запросов (которые превращаются в sql запросы). Create это не специфический запрос:
// Конвенции и правила:
// начало метода на findAll, deleteAll, countAll или без (All), потом идет By, после обязательно имя филда, после..
// после набор операторов (много, Идея подсказывает), после один из двух операторов (And или Or), после
// после имя филда, после один из операторов и т.д.
// операторы в скобочках указываем в строгом порядке как идут команды в методе (типо как sql подставляетзнаки ?)

// List<Employee> findAllByAgeBetween(Integer left, Integer right);
// select * from employees where age in (21, 27)
// имплементация прописывается в Service классе AccountServiceImpl например по этому проекту
//  private void findAllByAgeBetween() {
//        List<Employee> employees = employeeRepository.findAllByAgeBetween(30, 40);
//        System.out.println("employees = " + employees.size());
//    }

// List<Employee> findAllByAgeBeforeAndAgeAfterAndEmailInAndAgeBetween(Integer left, Integer right, List<String> emails, Integer start, Integer end);
// select * from employees where age < 30 and age > 25 и т.д.
//

// void deleteAllByFirstNameContainingIgnoreCase(String like);
// delete from employees where first_name like 'Юрий'

// Long countAllByFirstNameContainingIgnoreCaseAndAgeBeforeAndLastNameEndsWith(String like, Integer age, String name);
// select count(id) from pupil where first_name like "%r%" and class < 30 and last_name like 'gordienko'; типа этого
// имплементация
// private void countAllByFirstNameContainingIgnoreCaseAndAgeBeforeAndLastNameEndsWith() {
//    long count = employeeRepository.countAllByFirstNameContainingIgnoreCaseAndAgeBeforeAndLastNameEndsWith("99", 30, "Update");
//    System.out.println("count = " + count);
//    }

// boolean existsAllByEmailContainingIgnoreCase(String email);
// имплементация
// private void existsAllByEmailContainingIgnoreCase() {
//        boolean ex = employeeRepository.existsAllByEmailContainingIgnoreCase("email996@MAIL.com");
//        System.out.println("ex = " + ex);
//    }

// пагинация:
//  private void datatable() {
//        Page<Employee> page = employeeRepository.findAll(
//                PageRequest.of(0, 25, Sort.by("id").descending())
//        );
//        System.out.println("getTotalPages = " + page.getTotalPages());
//        System.out.println("getContent = " + page.getContent());
//        System.out.println("getTotalElements = " + page.getTotalElements());
//        System.out.println("getSize = " + page.getSize());
//        System.out.println("getSort = " + page.getSort());
//        System.out.println("getPageable = " + page.getPageable());
//    }
