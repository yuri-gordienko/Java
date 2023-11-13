package yugo.entity;

public class Dep_Emp {

    private String depId;
    private String empId;

//    private Department department; // Перемістіть тут для коректного ініціалізації

//    public Dep_Emp(String depId, String empId, Department department) {
//        this.depId = depId;
//        this.empId = empId;
//        this.department = department;
//    }

    Department department = new Department();

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }


    @Override
    public String toString() {
        return "Dep_Emp{" +
                "depId='" + depId + '\'' + "depName='" + department.getDepName() + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Dep_Emp{" +
//                "depId='" + depId + '\'' +
//                ", depName='" + department.getDepName() + '\'' +
//                ", empId='" + empId + '\'' +
//                '}';
//    }
}
