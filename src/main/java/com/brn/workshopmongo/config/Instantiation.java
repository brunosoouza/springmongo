package com.brn.workshopmongo.config;

import com.brn.workshopmongo.domain.User;
import com.brn.workshopmongo.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * classe criada com o proposito de limpar a colecao com base no que foi configurado
 * no repository
 *
 * */

@Configuration //indica ao spring que isso é uma configuração
public class Instantiation implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll(); //deleta tudo da colecao do repository

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));
    }
}
