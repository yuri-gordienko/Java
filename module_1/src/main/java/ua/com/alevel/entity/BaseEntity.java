package ua.com.alevel.entity;


public abstract class BaseEntity {

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                '}';
    }
}
