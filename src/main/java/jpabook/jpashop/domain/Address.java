package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

// 값타입은 값이 변경되면 안됨
// 따라서 @Setter를 제거하고, 생성자에서 모든 값을 초기화하여 변경불가능하도록
@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    public Address(String street, String city, String zipcode) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }
}
