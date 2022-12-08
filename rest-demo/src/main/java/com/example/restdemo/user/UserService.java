package com.example.restdemo.user;

import com.example.restdemo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> getAll();

  User create(User user);

  Optional<User> update(int id, User newUser);

  void delete(int id);
}
