package com.brn.workshopmongo.resources;

import com.brn.workshopmongo.domain.User;
import com.brn.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource  {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){ //retorna uma entidade do spring com cabeçalhos
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); //o ok retorna o codigo 200
    }
}
