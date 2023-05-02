package hello.jdbc.con2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DBConUtil2Test {

    @Test
    void getConnection() {
        Connection connection = DBConUtil2.getConnection();
        assertThat(connection).isNotNull();
    }
}