package com.exemplospring.course.resources;

import com.exemplospring.course.entities.User;
import com.exemplospring.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // serve para falar que e um recurso web que e implementado por um controlador Rest
@RequestMapping(value = "/users") // serve para dar um nome para esse recurso, um caminho basicamente
public class UserResource {
    @Autowired
    private UserService service;
    /* endpoint para acessar os users
    ResponseEntity<T>: tipo especifico do Spring para retornar respostas de requisições web
    @GetMapping: serve para indicar que o metodo abaixo responde a requisição GET do HTTP
    */
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    /*No GetMapping entre parenteses esta o endpoint em que vai passar o id para fazer a busca
    * Para o Spring aceitar o id como argumento na url precisa-se da annotation @PathVariable*/
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User u = service.findById(id);
        return ResponseEntity.ok().body(u);
    }
}
