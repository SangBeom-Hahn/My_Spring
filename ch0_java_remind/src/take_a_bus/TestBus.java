package take_a_bus;

public class TestBus {
    public static void main(String[] args) {
        Student student = new Student("james", 5000);
        Bus bus = new Bus(100);

        student.takeBus(bus);
        student.showInfo();
        bus.showInfo();
    }
}
