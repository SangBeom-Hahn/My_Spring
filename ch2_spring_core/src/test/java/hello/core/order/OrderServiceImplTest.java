package hello.core.order;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }

}