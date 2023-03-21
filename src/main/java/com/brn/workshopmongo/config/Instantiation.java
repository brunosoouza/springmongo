package com.brn.workshopmongo.config;

import com.brn.workshopmongo.domain.Post;
import com.brn.workshopmongo.domain.User;
import com.brn.workshopmongo.repositorys.PostRepository;
import com.brn.workshopmongo.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

/**
 * classe criada com o proposito de limpar a colecao com base no que foi configurado
 * no repository
 *
 * */

@Configuration //indica ao spring que isso é uma configuração
public class Instantiation implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll(); //deleta tudo da colecao do repository

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));


        postRepository.deleteAll();

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", maria);

        postRepository.saveAll(Arrays.asList(post1, post2));


    }
}
