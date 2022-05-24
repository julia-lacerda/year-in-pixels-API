package br.anhembi.spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @PatchMapping
    public void savename(int id, String nome) {
        User user = new User(id,nome);
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
    public ResponseEntity<User> findById(int id) {
        User user = this.UserRepo.findById(id).orElse(null);
            return ResponseEntity.ok(user);

    }

}

