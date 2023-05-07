package hello.jdbc.repository.ex;

public class MyDBRuntimeException extends RuntimeException{
    public MyDBRuntimeException() {
    }

    public MyDBRuntimeException(String message) {
        super(message);
    }

    public MyDBRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDBRuntimeException(Throwable cause) {
        super(cause);
    }
}
