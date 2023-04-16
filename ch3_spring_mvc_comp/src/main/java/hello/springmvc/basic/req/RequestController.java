package hello.springmvc.basic.req;

import hello.springmvc.basic.HelDa;
import hello.springmvc.basic.HelloData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequestController {
    @ResponseBody
    @RequestMapping("/request-v1")
    public HelDa requestV1(@ModelAttribute HelDa helDa) {
        return helDa;
    }

    @ResponseBody
    @RequestMapping("/request-v2")
    public HelloData requestV2(@RequestParam String userName,
                           @RequestParam int age) {
        HelloData helloData = new HelloData();
        helloData.setAge(age);
        helloData.setUsername(userName);

        return helloData;
    }
    @ResponseBody
    @PostMapping("/request-string-v1")
    public HttpEntity<String> requestStringV1(HttpEntity<String> httpEntity) {
        String messageBody = httpEntity.getBody();
        return new HttpEntity<>(messageBody);
    }

    @ResponseBody
    @PostMapping("/reqeust-string-v2")
    public String requestStringV2(@RequestBody String messageBody) {
        return messageBody;
    }

    @ResponseBody
    @PostMapping("/request-json")
    public HelDa requestJson(@RequestBody HelDa helDa) {
        return helDa;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @PostMapping("/request-json-status")
    public HelDa requestJsonSta(@RequestBody HelDa helDa) {
        return helDa;
    }

    @ResponseBody
    @PostMapping("/request-json-st-v2")
    public ResponseEntity<HelDa> requestJsonStV2(@RequestBody HelDa helDa) {
        return new ResponseEntity<>(helDa, HttpStatus.ACCEPTED);
    }
}
