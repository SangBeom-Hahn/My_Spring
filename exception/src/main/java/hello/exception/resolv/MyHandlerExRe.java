//package hello.exception.resolv;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@Slf4j
//public class MyHandlerExRe implements HandlerExceptionResolver {
//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        try {
//            if(ex instanceof RuntimeException) {
//                log.info("하이루루루루");
//                response.sendError(HttpServletResponse.SC_ACCEPTED, ex.getMessage());
//                return new ModelAndView();
//            }
//        } catch (IOException e) {
//
//        }
//
//        return null;
//    }
//}
