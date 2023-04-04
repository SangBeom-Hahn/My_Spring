package poly;

import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        Human human = new Human();
        Scanner scanner = new Scanner(System.in);
        int chooseCar = scanner.nextInt();

        if(chooseCar == 1){
            human.getCar(new AvanThe());
        }
        else {
            human.getCar(new K3());
        }
    }
}
