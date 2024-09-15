package yugo.test_Epam_2;

class Auto {
    public void drive() {
        System.out.print("A");
    }
}

class Vehicle extends Auto {
    public void drive() {
        System.out.print("W");
    }

    public static void main(String args[]) {
        Auto auto = new Auto();
        Vehicle vehicle = new Vehicle();
        auto.drive();      // line1
        vehicle.drive();   // line2
        auto = vehicle;    // line3
        auto.drive();      // line4
    }
}
