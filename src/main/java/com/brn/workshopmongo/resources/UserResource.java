package com.brn.workshopmongo.resources;

import com.brn.workshopmongo.domain.User;
import com.brn.workshopmongo.dto.UserDTO;
import com.brn.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(value = "/users")
public class UserResource  {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){ //retorna uma entidade do spring com cabeçalhos
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto); //o ok retorna o codigo 200
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); //o ok retorna o codigo 200
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){ //diz ao spring para pegar o body recebido
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = URI.create(obj.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/testeurl")
    public ResponseEntity<Void> testeUrl(){
        URI uri = URI.create("/www.google.com");
        return ResponseEntity.created(uri).build();
    }
}
