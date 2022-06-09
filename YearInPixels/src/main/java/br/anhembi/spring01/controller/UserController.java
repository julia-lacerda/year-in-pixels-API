package br.anhembi.spring01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import br.anhembi.spring01.model.User;
import br.anhembi.spring01.repository.UserRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/epixel")
public class UserController {
    @Autowired
    private UserRepo UserRepo;

    @PutMapping
    public void saves(int id, int humor, String data, String texto) {
        User user = new User(id,humor,data,texto);
        this.UserRepo.save(user);
    }

    @PostMapping
    public void redefinir(int id) {
        int humor = 0;
        String data = null;
        String texto = null;
        User User = new User(id,humor, data, texto);
        this.UserRepo.save(User);

    }

    public boolean findToComplete(@PathVariable int id){
        if(this.UserRepo.findById(id).isEmpty()){
            return true;
        }else
        return false;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> user = this.UserRepo.findAll();
        return ResponseEntity.ok(user);
    }

}

