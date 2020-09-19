package com.shop_management.shop_management.commons;

public enum Status {
    accept("accept"),
    unaccept("unaccept");

    private final String store;

    private Status(String store) {

        this.store = store;
    }

    public String getStatus() {

        return store;
    }
}
