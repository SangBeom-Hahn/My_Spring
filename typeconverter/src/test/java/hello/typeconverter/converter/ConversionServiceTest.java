package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {
    private static ConversionService conversionService;
    @BeforeEach
    void beforeEach() {
        conversionService = new ConversionService();
    }

    @Test
    void conversionService() {
        // 사용
        assertThat(conversionService.defaultConversionService.convert("10", Integer.class)).isEqualTo(10);
//        IpPort ipPort = conversionService.defaultConversionService.convert("'127.0.0.1:8080", IpPort.class)
//        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}
