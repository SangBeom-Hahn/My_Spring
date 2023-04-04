package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP면 10% 할인 적용")
    public void discount(){
        //given
        Member member = new Member(1L, "A", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 1000);

        //then
        Assertions.assertThat(discount).isEqualTo(100);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용 x")
    public void discount_X(){
        //given
        Member member = new Member(1L, "A", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 1000);

        //then
        Assertions.assertThat(discount).isEqualTo(100);
    }
}