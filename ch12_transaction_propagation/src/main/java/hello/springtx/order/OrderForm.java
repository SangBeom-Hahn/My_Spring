package hello.springtx.order;

import lombok.Data;

@Data
public class OrderForm {
    private String username; //정상, 예외, 잔고부족
    private String payStatus; //대기, 완료
}
