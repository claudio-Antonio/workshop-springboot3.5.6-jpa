package com.exemplospring.course.services;

import com.exemplospring.course.entities.User;
import com.exemplospring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // faz com que a classe seja um componente especifico da camda de serviço e possa ser injetada com Autowired
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        // Optional e uma classe que e um container que representa um valor que pode ou nao estar presente, findById retorna um valor Optional
        Optional<User> obj = repository.findById(id);
        return obj.get(); // metodo que retorna um obj do tipo User
    }
}
