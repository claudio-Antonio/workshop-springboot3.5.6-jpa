package com.exemplospring.course.resources;

import com.exemplospring.course.entities.User;
import com.exemplospring.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    /*Quando se quer inserir um novo recurso, se usa o metodo HTTP POST, e no controlador Rest, @PostMapping.
    *@RequestBody: serve para dizer que o corpo de um Json deve ser automaticamente desserializado e vinculado ao parâmetro user do metodo
    * controlador insert.
    * Quando se esta inserindo um novo recurso deve-se retornar o codigo HTTP 201.
    * No padrão HTTP quando se retorna um codigo 201, retorna junto um cabeçalho contendo o endereço do novo recurso inserido.
    * Para gerar esse novo endereço se usa um obj URI com alguns metodos, um deles sendo o path que serve para montar o padrão da url com
    * o novo id. Outro metodo eh o buildAndExpand, ele espera o obj que tem o novo id criado. Por fim, converte todo esse corpo para uri.*/
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User u = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(uri).body(u);
    }
}
