package com.example.restdemo.controller;

import com.example.restdemo.entity.User;
import com.example.restdemo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping()
  public ResponseEntity<List<User>> getAll() {
    return ResponseEntity.ok(userService.getAll());
  }

  @PostMapping()
  public ResponseEntity<User> create(@RequestBody User user) {
    userService.create(user);
    return ResponseEntity.created(URI.create("/users/" + user.getId())).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Optional<User>> update(@PathVariable int id, @RequestBody User user) {
    userService.update(id, user);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteUser(@PathVariable int id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
