package com.sample.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
    @InjectMocks
    OrderController orderController = new OrderController();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    OrderRepository repository;

    @Mock
    OrderResourceAssembler assembler;


    @Test
    public void testFindAllOrders(){
      //given
        //add the behavior of calc service to add two numbers
        when(repository.findAll()).thenReturn(new ArrayList<>());
        when(assembler.toResourceCollection(any())).thenReturn(new ArrayList<>());
        when(assembler.toResource(any())).thenReturn(new OrderResource(new Order()));
       //when
            orderController.findAllOrders();
        //then
        //test the add functionality
        Assert.assertEquals(orderController.findAllOrders(), new ResponseEntity<>(assembler.toResourceCollection(any()), HttpStatus.OK));
        verify(repository,times(1)).findAll();
        verify(assembler,times(2)).toResourceCollection(any());

    }
    @Test
    public void testCreateOrder() {
        //given
        when(repository.create(any())).thenReturn(new Order());
        when(assembler.toResource(any())).thenReturn(new OrderResource(new Order()));
        //when
        orderController.createOrder(new Order());

    }
}