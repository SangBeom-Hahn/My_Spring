package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerConverterTest {

    @Test
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void StringToIpPort () {
        IpportToStringConverter converter = new IpportToStringConverter();
        String result = converter.convert(new IpPort("127.0.0.1", 8080));

        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}