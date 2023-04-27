//package hello.exception.resolv;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import hello.exception.exception.UserException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//@Slf4j
//public class UserExRe implements HandlerExceptionResolver {
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        try {
//            log.info("하이루");
//            if (ex instanceof UserException) {
//                String acceptHeader = request.getHeader("accept");
//                response.setStatus(HttpServletResponse.SC_ACCEPTED);
//                log.info("hoifdsf");
//                if("application/json".equals(acceptHeader)) {
//                    log.info("hoi");
//                    Map<String, Object> errorResult = new HashMap<>();
//                    errorResult.put("ex", ex.getClass());
//                    errorResult.put("message", ex.getMessage());
//
//                    String result = objectMapper.writeValueAsString(errorResult);
//                    response.getWriter().write(result);
//                    response.setCharacterEncoding("utf-8");
//                    response.setContentType("application/json");
//
//                    return new ModelAndView();
//
//                } else {
//                    return new ModelAndView("error/500");
//                }
//            }
//        } catch (IOException e) {
//
//        }
//        return null;
//    }
//}
