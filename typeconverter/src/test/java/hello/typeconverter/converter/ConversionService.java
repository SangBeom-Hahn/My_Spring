package hello.typeconverter.converter;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Component;

@Component
public class ConversionService {
    DefaultConversionService defaultConversionService = new DefaultConversionService();
    public void add() {
        defaultConversionService.addConverter(new StringToIntegerConverter());
        defaultConversionService.addConverter(new StringToPortConverter());
    }
}
