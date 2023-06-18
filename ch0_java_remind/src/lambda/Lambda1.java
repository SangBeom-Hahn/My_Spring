package lambda;

public class Lambda1 {

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    Object o = (int a, int b) -> a > b ? a : b

    new Object() {
        int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
