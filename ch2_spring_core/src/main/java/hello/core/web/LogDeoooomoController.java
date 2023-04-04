package hello.core.web;

import hello.core.common.LLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDeoooomoController {
    private final LogDemoSSSService logDemoSSSService;
    private final LLogger lLogger;
    @RequestMapping("log-demooo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        lLogger.setRequestURL(requestURL);

        lLogger.log("controller test");
        logDemoSSSService.logic("testID");
        return "OK";
    }
}
