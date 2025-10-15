package com.exemplospring.course.config;

import com.exemplospring.course.entities.User;
import com.exemplospring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/*
* A classe TestConfig serve para popular o banco h2 com alguns dados, apenas para teste
* @Configuration: serve para falar pro spring que esta e uma classe de configiração
* @Profile("nome do profile"): serve para o spring entender que e uma configuração especifica para o perfil de nome "test"
*/
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired // faz a injeção de dependencia automaticamente
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
