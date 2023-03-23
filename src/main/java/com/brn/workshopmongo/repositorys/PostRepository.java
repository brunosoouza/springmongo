package com.brn.workshopmongo.repositorys;

import com.brn.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    //metodo criado com base na doc do spring data
    //mais informações aqui https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongodb.repositories.queries
    List<Post> findByTitleContainingIgnoreCase(String text);
}
