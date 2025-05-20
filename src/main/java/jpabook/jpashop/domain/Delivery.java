package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    // ENUM을 선언할 때는 무조건 String Type으로 지정해야됨.
    // ENUM이 중간에 추가될 경우 ORIGIN타입의 경우 숫자로 관리되기 때문에 망함
    private DeliveryStatus status; // enum으로 READY, COMP

}
