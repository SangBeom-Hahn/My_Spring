//package hello.exception.api;
//
//import hello.exception.exception.UserException;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//public class ApiExCont {
//
//    @GetMapping("/api/members/{id}")
//    public MemberDTO ApiExCont(@PathVariable String id) {
//        if(id.equals("ex")) {
//            throw new RuntimeException();
//        }
//        if(id.equals("user")) {
//            log.info("fdsf");
//            throw new UserException("사용자 지지지지ㅣ");
//        }
//
//        return new MemberDTO("hello" + id, id);
//    }
//    @Data
//    @AllArgsConstructor
//    static class MemberDTO {
//        private String name;
//        private String id;
//    }
//}
