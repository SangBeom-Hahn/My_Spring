package hello.springtx.order;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; //정상, 예외, 잔고부족
    private PayStatus payStatus; //대기, 완료
}
