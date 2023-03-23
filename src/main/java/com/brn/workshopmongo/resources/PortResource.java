package com.brn.workshopmongo.resources;

import com.brn.workshopmongo.domain.Post;
import com.brn.workshopmongo.resources.util.URL;
import com.brn.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PortResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj); //o ok retorna o codigo 200
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text); //removendo a decodificação %20 recebido
        List<Post> list = service.findByTititle(text);
        return ResponseEntity.ok().body(list);
    }
}
