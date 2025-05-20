package jpabook.jpashop.domain.Item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속받은 엔티티를 한테이블에 다 넣는 방식으로 만들기
@DiscriminatorColumn(name = "dtype") // dtype으로 구분하기 dtype이 BOOK이면~, dtype이 ALBUM이면~
@Getter @Setter
public abstract class Item { // Q2) 어라??? abstract 추상클래스로 만드네?
    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
