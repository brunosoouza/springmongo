package com.brn.workshopmongo.services;

import com.brn.workshopmongo.domain.User;
import com.brn.workshopmongo.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll(){
      return repo.findAll();
    }
}
