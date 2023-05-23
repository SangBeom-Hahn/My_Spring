package hello.springtx.propa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final LogRepo logRepo;
    private final MemberRepositoy memberRepositoy;
    @Transactional
    public void joinV1(String username) {
        Member member = new Member(username);
        Log logM = new Log(username);

        memberRepositoy.save(member);
        logRepo.save(logM);
    }

    public void joinV2(String username) {
        Member member = new Member(username);
        Log logM = new Log(username);

        memberRepositoy.save(member);

        try {
            logRepo.save(logM);
        } catch (RuntimeException e) {

        }
    }
}
