package org.hm.dto;

public class Order {

    private Long id;
    private String customer;

    public Order(Long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }
}