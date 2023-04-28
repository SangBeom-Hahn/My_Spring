package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpportToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpportConverter;
import hello.typeconverter.formatter.MyNumberFomatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new IpportToStringConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpportConverter());
        registry.addConverter(new StringToIntegerConverter());

        registry.addFormatter(new MyNumberFomatter());
    }
}
