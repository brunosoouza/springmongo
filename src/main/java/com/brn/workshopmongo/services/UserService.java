package com.brn.workshopmongo.services;

import com.brn.workshopmongo.domain.User;
import com.brn.workshopmongo.dto.UserDTO;
import com.brn.workshopmongo.repositorys.UserRepository;
import com.brn.workshopmongo.services.exception.ObjectNofFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll(){
      return repo.findAll();
    }

    public User findById(String id){
        Optional<User> findById = repo.findById(id);
        if(!findById.isPresent()){
            throw new ObjectNofFoundException("Objeto não encontrado");
        }
        return findById.get();
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id){
        findById(id); //aproveitando as validações do metodo find ja prontas para não reescreve codigo
        repo.deleteById(id);
    }
}
