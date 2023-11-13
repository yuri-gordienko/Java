package yugo.entity;

public class Department extends BaseEntity {

    private String depName;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + depName + '\'' +
                '}' + super.toString();
    }
}
