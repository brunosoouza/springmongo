package com.brn.workshopmongo.services;

import com.brn.workshopmongo.domain.Post;
import com.brn.workshopmongo.repositorys.PostRepository;
import com.brn.workshopmongo.services.exception.ObjectNofFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> findById = repo.findById(id);
        if(!findById.isPresent()){
            throw new ObjectNofFoundException("Objeto não encontrado");
        }
        return findById.get();
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> searchTitle(String text){
        return  repo.searchTitle(text);
    }
}
