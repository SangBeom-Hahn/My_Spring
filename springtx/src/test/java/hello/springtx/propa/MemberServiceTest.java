package hello.springtx.propa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

import javax.persistence.Table;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceTest {
    @Autowired
    private LogRepo logRepo;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepositoy memberRepositoy;


    @Test
    void outerTxOff_success() {
        String username = "로그예외outerTxOff_success";

        assertThatThrownBy(() -> memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);

        Assertions.assertTrue(memberRepositoy.find(username).isEmpty());
        Assertions.assertTrue(logRepo.find(username).isEmpty());
    }
}