package jpabook.jpashop.domain.Item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("B")
public class Book extends Item{
    private String artist;
    private String etc;
}
