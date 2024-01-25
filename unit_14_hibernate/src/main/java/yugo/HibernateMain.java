package yugo;

public class HibernateMain {
    public static void main(String[] args) {

        System.out.println("Hello hibernate!");
//        HibernateConfig hibernateConfig = HibernateConfig.getInstance();

//        new EmployeeTest().start();

        new DepartmentTest().run();
    }
}