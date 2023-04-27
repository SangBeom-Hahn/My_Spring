package hello.exception.api;

import hello.exception.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 예외를 발생시키는 컨트롤러
public class ApiExceptionController {
    @GetMapping("/api/members/{id}")
    public MemberDTO memberDTO(@PathVariable("id") String id) {
        if(id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }
        if(id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 사용자");
        }
        if(id.equals("uese-ex")) {
            throw new UserException("사용자 지정 에러");
        }
        return new MemberDTO(id, "hello" + id);
    }

    @Data
    @AllArgsConstructor
    static class MemberDTO {
        private String memberId;
        private String name;
    }
}
