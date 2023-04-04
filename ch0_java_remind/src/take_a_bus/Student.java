package take_a_bus;

public class Student {
    //필르
    String name;
    int money;

    //생성자
    public Student(String name, int money){
        this.name = name;
        this.money = money;
    }

    //메서드
    void takeBus(Bus bus){
        bus.take(1000);
        money -= 1000;
    }

    void showInfo(){
        System.out.println(money);
    }
}
