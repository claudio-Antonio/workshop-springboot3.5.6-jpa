package com.exemplospring.course.resources;

import com.exemplospring.course.entities.Product;
import com.exemplospring.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> p = service.findAll();
        return ResponseEntity.ok().body(p);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product p = service.findById(id);
        return ResponseEntity.ok().body(p);
    }
}
