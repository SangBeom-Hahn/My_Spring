package hello.typeconverter.formatter;

import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MyNumberFomatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        NumberFormat format = NumberFormat.getNumberInstance(locale);
        return format.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        NumberFormat instance = NumberFormat.getNumberInstance(locale);
        return instance.format(object);
    }
}
