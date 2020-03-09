package com.sample.spring;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {
    @JsonUnwrapped
    private final Order order;
    public OrderResource(Order order) {
        this.order = order;
    }
}