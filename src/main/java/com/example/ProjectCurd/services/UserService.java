package com.example.ProjectCurd.services;

import com.example.ProjectCurd.entity.Users;

import java.util.List;

public interface UserService {
    public Users create(Users users);

    public List<Users> getAll();

    public Users getOneUser(int id);

    public Users update(Users users);

    public void delete(int id);
}
