package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders") // Q1) 이건 왜 별도로 @Table을 선언했을까?
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    // 회원 한명당 주문 N개 가능(1-N)
    // N쪽이 연관관계의 주인이므로 FK를 가짐
    @JoinColumn(name="member_id") // member_id : One의 PK
    private Member member;

    @OneToMany(mappedBy = "order") // 주문 하나당 주문상품이 N개 가능. 1-N
    // 주문상품의 거울이 되는 주문상품리스트
    private List<OrderItems> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    // 1:1관계의 경우 어느쪽을 연관관계의 주인으로 두느냐가 중요함
    // 각각 장단점이 명확
    // 다만 강사의 경우, 조회를 더 많이 하는 도메인을 연관관계의 주인으로 둠
    private Delivery delivery;

    private LocalDateTime orderDate; // 자바8 이후부턴 애노테이션 처리없이 가능, 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // [ORDER, CANCEL]
}
