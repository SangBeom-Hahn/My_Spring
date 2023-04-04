package take_a_bus;

public class Bus {
    //필드
    int passengerCount;
    int money;
    int su;

    //생성자
    public Bus(int su){
        this.su = su;
        money = 0;
        passengerCount = 0;
    }

    //메서드
    public void take(int money){
        passengerCount++;
        this.money += money;
    }

    void showInfo(){
        System.out.println(money+su+passengerCount);
    }
}
