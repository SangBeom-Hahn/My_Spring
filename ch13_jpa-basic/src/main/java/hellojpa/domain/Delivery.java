package hellojpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    
    @OneToOne(mappedBy = "delivery")
    private Order order;
}
