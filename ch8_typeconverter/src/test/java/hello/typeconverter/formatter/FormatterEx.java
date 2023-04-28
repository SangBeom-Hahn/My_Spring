package hello.typeconverter.formatter;

import hello.typeconverter.converter.StringToIntegerConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormatterEx {
    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService defaultFormattingConversionService = new DefaultFormattingConversionService();

        defaultFormattingConversionService.addConverter(new StringToIntegerConverter());
        defaultFormattingConversionService.addFormatter(new MyNumberFomatter());

        Long result = defaultFormattingConversionService.convert("1,000", Long.class);
        Assertions.assertThat(result).isEqualTo(1000);
    }
}
