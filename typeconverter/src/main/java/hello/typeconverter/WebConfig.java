package hello.typeconverter;

import hello.typeconverter.converter.PortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new StringToPortConverter());
        registry.addConverter(new PortToStringConverter());

        registry.addFormatter(new MyNumberFormatter());
    }
}
