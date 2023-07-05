package exception;

public class exception_adv {
    public static void main(String[] args) {
        method();
    }

    static void method() {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new MyException("hi", e);
        }
    }
}

class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
