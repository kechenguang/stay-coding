package someTest;

public class TestClass {

    public static class Tire {
        private int size;

        Tire(int size) {
            size = size;
        }
    }

    public static class FrameWork {
        private Tire tire;

        FrameWork(Tire tire) {
            this.tire = tire;
        }
    }

    public static class Car {
        private FrameWork frameWork;

        Car(FrameWork frameWork) {
            this.frameWork = frameWork;
        }
    }

    public static void main(String args) {

        Tire tire = new Tire(10);
        FrameWork frameWork = new FrameWork(tire);
        Car car = new Car(frameWork);

    }
}
