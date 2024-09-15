package yugo.test_Epam_1;

public class Q19_Quest {

    public static void main(String[] args) {
        final SpacePlane plane = new CargoSpaceShip();
        System.out.print(plane.fly());
    }
}

class Plane {
    private final String fly() {
        return "Plane";
    }
}

class SpacePlane extends Plane {
    protected String fly() {   // line1
        return "Space";
    }
}

class CargoSpaceShip extends SpacePlane {
    public final String fly() {
        return "Cargo";
    }
}
