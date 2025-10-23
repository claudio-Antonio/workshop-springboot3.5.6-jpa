package com.exemplospring.course.services;

import com.exemplospring.course.entities.User;
import com.exemplospring.course.repositories.UserRepository;
import com.exemplospring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // faz com que a classe seja um componente especifico da camada de serviço e possa ser injetada com Autowired
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        // Optional e uma classe que e um container que representa um valor que pode ou nao estar presente, findById retorna um valor Optional
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    /*getReferenceById: monitora o obj entity com o novo id para posteriormente trabalhar com ele e depois fazer uma operação no BD.*/
    public User update(Long id, User obj) {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
