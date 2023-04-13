package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MappingController {
    @GetMapping("/mapping/{userID}")
    public String mappingPath(@PathVariable String userID) {
        log.info("mapping variable= {}", userID);
        return "OK";
    }

    @GetMapping("/mapping/users/{userID}/orders/{orderID}")
    public String mappingPath2(@PathVariable String userID, @PathVariable Long orderID) {
        log.info("mapping variable= {}, orderId = {}", userID, orderID);
        return "OK";
    }

    @GetMapping(value = "/mapping/users/{userID}/orders", params = "mode=debug")
    public String mappingParam(@PathVariable String userID) {
        log.info("mapping variable= {}", userID);
        return "OK";
    }
}