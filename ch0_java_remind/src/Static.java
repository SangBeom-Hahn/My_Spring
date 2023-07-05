public class Static {
    long a;
    long b;

    long add() {
        return a + b;
    }

    static long add(long a, long b) {
        return a + b;
    }
}
