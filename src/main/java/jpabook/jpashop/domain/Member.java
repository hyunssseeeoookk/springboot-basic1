package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name="member_id")
    private long id;

    private String name;

    @Embedded // Address클래스의 @Embeddable의 호출처에선 @Embedded로 사용
    private Address address;

    @OneToMany(mappedBy = "member")
    // Member의 입장에선 1:N관계이기 때문에
    // Order 테이블의 FK(member)가 바뀌면 이 orders 변수도 같이 변경됨.
    private List<Order> orders = new ArrayList<>();
}
