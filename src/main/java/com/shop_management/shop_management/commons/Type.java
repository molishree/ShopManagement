package com.shop_management.shop_management.commons;

public enum Type {
    essential("essential"),
    nonessential("nonessential");

    private final String store;

    private Type(String store) {

        this.store = store;
    }

    public String getStatus() {

        return store;
    }
}
