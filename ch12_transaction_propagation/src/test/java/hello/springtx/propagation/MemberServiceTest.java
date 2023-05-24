package hello.springtx.propagation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LogRepository logRepository;

    /**
     * MemberService @Transactional:OFF
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON
     */
    @Test
    void outerTxOff_success() {
        String username = "outerTxOff_success";

        memberService.joinV1(username);

        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * MemberService @Transactional:OFF
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON Exception
     */
    @Test
    void outerTxOff_fail() {
        String username = "로그예외outerTxOff_fail";

        assertThatThrownBy(() -> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);


        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * MemberService @Transactional:ON
     * MemberRepository @Transactional:OFF
     * LogRepository @Transactional:OFF
     */
    @Test
    void outerTxOff_single() {
        String username = "outerTxOff_single";

        memberService.joinV1(username);

        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * MemberService @Transactional:ON
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON
     */
    @Test
    void outerTxOn_success() {
        String username = "outerTxOn_success";

        memberService.joinV1(username);

        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * MemberService @Transactional:ON
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON Exception
     */
    @Test
    void outerTxOn_fail() {
        String username = "로그예외outerTxOff_fail";

        assertThatThrownBy(() -> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);


        Assertions.assertTrue(memberRepository.find(username).isEmpty());
        Assertions.assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * MemberService @Transactional:ON
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON Exception
     */
    @Test
    void recoverException_fail() {
        String username = "로그예외recoverException_fail";

        assertThatThrownBy(() -> memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);

        Assertions.assertTrue(memberRepository.find(username).isEmpty());
        Assertions.assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * MemberService @Transactional:ON
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON(REQUIRES_NEW) Exception
     */
    @Test
    void recoverException_success() {
        String username = "로그예외recoverException_success";

        memberService.joinV2(username);

        Assertions.assertTrue(memberRepository.find(username).isPresent());
        Assertions.assertTrue(logRepository.find(username).isEmpty());
    }
}