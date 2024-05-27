package org.nhom1.agilecarrentall.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class WishItem {
    @EmbeddedId
    private WishItemId wishItemId;
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    private Car car;
}
