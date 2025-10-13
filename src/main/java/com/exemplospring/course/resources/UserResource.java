package com.exemplospring.course.resources;

import com.exemplospring.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // serve para falar que e um recurso web que e implementado por um controlador Rest
@RequestMapping(value = "/users") // serve para dar um nome para esse recurso, um caminho basicamente
public class UserResource {
    /* endpoint para acessar os users
    ResponseEntity<T>: tipo especifico do Spring para retornar respostas de requisições web
    @GetMapping: serve para indicar que o metodo abaixo responde a requisição GET do HTTP
    */
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "99999999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
