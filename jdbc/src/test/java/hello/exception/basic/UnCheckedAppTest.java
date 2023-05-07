package hello.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
@Slf4j
public class UnCheckedAppTest {

    @Test
    void checked() {
        Controller controller = new Controller();
        assertThatThrownBy(() -> controller.request()).isInstanceOf(RuntimeSQLException.class);
    }

    @Test
    void exPrint() {
        Controller controller = new Controller();
        try {
            controller.request();
        } catch (Exception e) {
//            log.info("ex", e);
        }
    }

    static class Controller {
        Service service = new Service();

        void request() {
            service.logic();
        }
    }

    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        void logic() {
            repository.call();
            networkClient.call();
        }
    }

    static class NetworkClient {
        void call() {
            throw new RuntimeConnectionException("fail");
        }
    }

    static class Repository {

        void call() {
            try {
                runSQL();
            } catch (SQLException e) {
                throw new RuntimeSQLException(e);
//                throw new IllegalStateException(e);
            }
        }
        void runSQL() throws SQLException {
            throw new SQLException("ex");
        }
    }

    static class RuntimeSQLException extends RuntimeException {
        public RuntimeSQLException() {
        }

        public RuntimeSQLException(Throwable cause) {
            super(cause);
        }
    }

    static class RuntimeConnectionException extends RuntimeException {
        public RuntimeConnectionException(String message) {
            super(message);
        }
    }
}
