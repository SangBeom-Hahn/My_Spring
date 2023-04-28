package hello.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyNumberFormatterTest {
    MyNumberFomatter fomatter = new MyNumberFomatter();

    @Test
    void parse() throws ParseException {
        Number number = fomatter.parse("1,000", Locale.KOREA);
        assertThat(number).isEqualTo(1000L);
    }

    @Test
    void print() {
        String result = fomatter.print(1000, Locale.KOREA);
        assertThat(result).isEqualTo("1,000");
    }
}