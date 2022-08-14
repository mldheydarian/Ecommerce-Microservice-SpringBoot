package com.milad.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name="order_item",
        uniqueConstraints =
        @UniqueConstraint( name = "orderitem-unique-constraint",columnNames={"order_id", "product_id"})
)
public class OrderItem extends BaseEntity implements Serializable {

    private static final Long serialVersionUID=1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderitem_id", nullable = false,updatable = false)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable = false, updatable = false)
    private Order order;

    @Column(name = "product_id", nullable = false, updatable = false)
    private Long procuctId;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;


}
