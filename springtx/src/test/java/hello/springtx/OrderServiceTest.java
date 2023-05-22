package hello.springtx;

import hello.springtx.order.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor
class OrderServiceTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @Autowired
    private DataSource dataSource;


    @Test
    void order() throws NotEnoughMoneyException {
        Order order = new Order();
        order.setUsername("정상");

        orderService.order(order);
        log.info("hi {}", dataSource.getClass());

        Order findOrder = orderRepository.findById(order.getId()).get();
        assertThat(findOrder.getPayStatus()).isEqualTo(PayStatus.COMP);
    }

    @Test
    void runTime() throws NotEnoughMoneyException {
        Order order = new Order();
        order.setUsername("예외");

        orderService.order(order);

        Optional<Order> orderOptional = orderRepository.findById(order.getId());
        assertThat(orderOptional.isEmpty()).isTrue();
    }

    @Test
    void bizEx() throws NotEnoughMoneyException {
        Order order = new Order();
        order.setUsername("잔고부족");

        try {
            orderService.order(order);
        } catch (NotEnoughMoneyException e) {
            log.info("고객에게 알림");
        }

        Order order1 = orderRepository.findById(order.getId()).get();
        assertThat(order1.getPayStatus()).isEqualTo(PayStatus.WAIT);
    }
}