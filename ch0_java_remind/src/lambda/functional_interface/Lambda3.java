package lambda.functional_interface;

@FunctionalInterface
interface MyFunction {
    void run();
}

public class Lambda3 {
    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f1.run");
        return f;

        // return() -> System.out.println("f1.run");
    }

    public static void main(String[] args) {
        MyFunction f1 = getMyFunction();
        f1.run();
    }
}
