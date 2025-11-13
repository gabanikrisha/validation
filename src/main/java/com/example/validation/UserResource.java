package com.example.validation;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource
{
    @Autowired
    private UserService service;
    @GetMapping("/users")
    public List<User> retriveAllUsers()
    {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id) throws UserNotFoundException {
        User user= service.findOne(id);
        if(user==null)

            throw new UserNotFoundException("id: "+ id);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        User user= service.deleteById(id);
        if(user==null) throw new UserNotFoundException("id: " + id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
    {
        User sevedUser=service.save(user);
        User savedUser = service.save(user);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedUser.getId()).toUri();
        return ResponseEntity.created(location).body(savedUser);
    }
}
