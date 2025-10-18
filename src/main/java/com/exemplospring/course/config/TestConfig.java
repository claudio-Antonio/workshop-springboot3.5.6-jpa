package com.exemplospring.course.config;

import com.exemplospring.course.entities.Category;
import com.exemplospring.course.entities.Order;
import com.exemplospring.course.entities.User;
import com.exemplospring.course.entities.enums.OrderStatus;
import com.exemplospring.course.repositories.CategoryRepository;
import com.exemplospring.course.repositories.OrderRepository;
import com.exemplospring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
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

    /*Para inserir dados usamos obj da camada de repository pois estes não tem regras de negócio(como os da camada de service).*/
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
