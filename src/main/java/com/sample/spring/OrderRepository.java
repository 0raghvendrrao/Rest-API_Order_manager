package com.sample.spring;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends InMemoryRepository<Order> {
    protected void updateIfExists(Order original, Order updated) {
        original.setDescription(updated.getDescription());
        original.setCostInCents(updated.getCostInCents());
        original.setComplete(updated.isComplete());
    }
}