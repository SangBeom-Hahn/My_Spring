package poly;

public class Human {
    //필드
    private Car car;

    //메서드
    public void getCar(Car car) {
        this.car = car;
        car.myName(); // 자동차 인터페이스
    }
}
