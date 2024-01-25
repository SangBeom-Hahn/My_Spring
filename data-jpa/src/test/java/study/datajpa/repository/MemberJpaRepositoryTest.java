package study.datajpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberJpaRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() {
        Member member = new Member("memberA");

        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedMember.getId()).get();

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
    }
    
    @Test
    @DisplayName("")
    void MemberJpaRepositoryTest() {
        // given
        Member member = new Member("AAA", 10);
        Member member1 = new Member("AAA", 20);

        // when
        memberRepository.save(member);
        memberRepository.save(member1);
//        List<Member> members = memberRepository.findByUsernameAndAgeGreaterThan("AAA", 15);
//
//        // then
//        Assertions.assertThat(members.get(0).getAge()).isEqualTo(20);
    }

    @Test
    @DisplayName("")
    void test() {
        // given
        Member member = new Member("AAA", 10);
        Member member1 = new Member("AAA", 20);

        // when
        memberRepository.save(member);
        memberRepository.save(member1);

//        List<Member> result = memberRepository.findUser("AAA", 10);
//
//        // then
//        assertThat(result.get(0)).isEqualTo(member);
    }

    @Test
    @DisplayName("")
    void test1() {
        // given
        Member member = new Member("AAA", 10);
        Member member1 = new Member("AAA", 20);

        // when
        memberRepository.save(member);
        memberRepository.save(member1);

//        List<String> usernameList = memberRepository.findUsernameList();

        // then
//        for (String s : usernameList) {
//            System.out.println(s);
//        }
    }

    @Test
    @DisplayName("")
    void test2() {
        // given
        Member member = new Member("AAA", 10);
        Member member1 = new Member("BBB", 20);

        // when
        memberRepository.save(member);
        memberRepository.save(member1);

//        List<Member> names = memberRepository.findByNames(Arrays.asList("AAA", "BBB"));
//
//        for (Member name : names) {
//            System.out.println(name);
//        }
    }

    @Test
    @DisplayName("")
    void test3() {
        // given
        Member member = new Member("AAA", 10);
        Member member1 = new Member("AAA", 20);

        // when
        memberRepository.save(member);
        memberRepository.save(member1);

//        Optional<Member> aaab = memberRepository.findOptByUsername("AAA");
//        System.out.println("result =" + aaab);
    }

    @Test
    @DisplayName("")
    void test4() {
        // given
        Member member = new Member("AAA", 10);
        Member member1 = new Member("AAA", 10);
        Member member2 = new Member("AAA", 10);
        Member member3 = new Member("AAA", 10);
        Member member4 = new Member("AAA", 10);

        memberRepository.save(member);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        int age = 10;
        int offset = 0;
        int limit = 3;

        // when
//        List<Member> members = memberRepository.findByPage(age, offset, limit);
//        long totalCount = memberRepository.totalCount(age);
//
//        // then
//        assertThat(members.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("")
    void test5() {
        // given
        Member member = new Member("AAA", 10);
        Member member1 = new Member("AAA", 10);
        Member member2 = new Member("AAA", 10);

        memberRepository.save(member);
        memberRepository.save(member1);
        memberRepository.save(member2);

        int age = 10;
        PageRequest pageRequest =
                PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));

        // when
        Page<Member> page = memberRepository.findByAge(age, pageRequest);
        page.map(member3 -> new MemberDto(member3.getTeam(), member3.getAge()))

        // then
        List<Member> content = page.getContent();
//        long totalElements = page.getTotalElements();

        for (Member member3 : content) {
            System.out.println("member3 = " + member3);
        }
//        System.out.println("totalElements = " + totalElements);
    }
}
