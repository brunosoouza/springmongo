package com.brn.workshopmongo.resources;

import com.brn.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource  {
    @GetMapping
    public ResponseEntity<List<User>> findAll(){ //retorna uma entidade do spring com cabeçalhos
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User Alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = Arrays.asList(maria,Alex);
        return ResponseEntity.ok().body(list); //o ok retorna o codigo 200
    }
}
