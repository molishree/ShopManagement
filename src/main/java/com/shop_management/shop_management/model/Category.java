package com.shop_management.shop_management.model;

import com.shop_management.shop_management.commons.Status;
import com.shop_management.shop_management.commons.Type;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID categoryId;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public UUID getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {

        this.categoryId = categoryId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public Type getType() {

        return type;
    }

    public void setType(Type type) {

        this.type = type;
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {

        this.status = status;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + ", type=" + type + ", status=" + status + "]";
    }

}
