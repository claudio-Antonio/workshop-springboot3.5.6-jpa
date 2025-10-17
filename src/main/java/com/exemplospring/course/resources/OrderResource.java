package com.exemplospring.course.resources;

import com.exemplospring.course.entities.Order;
import com.exemplospring.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrderResource {

    /*Nos Controllers usamos um obj da camada de serviços porque os mesmos podem ter regras de negocio, por isso não usamos diretamente
    * da camada de repository.*/
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order o = service.findById(id);
        return ResponseEntity.ok().body(o);
    }
}
