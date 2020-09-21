package com.shop_management.shop_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Sales {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID salesId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Item item;

    public UUID getSalesId() {

        return salesId;
    }


    public void setSalesId(UUID salesId) {

        this.salesId = salesId;
    }


    public float getAmount() {

        return amount;
    }


    public void setAmount(float amount) {

        this.amount = amount;
    }


    public int getQuantity() {

        return quantity;
    }


    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }


    public Item getItem() {

        return item;
    }


    public void setItem(Item item) {

        this.item = item;
    }


    @Override
    public String toString() {
        return "Sales [salesId=" + salesId + ", amount=" + amount + ", quantity=" + quantity + ", item=" + item + "]";
    }

}
