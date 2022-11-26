package com.example.ProjectCurd.services.serviceImp;

import com.example.ProjectCurd.entity.Users;
import com.example.ProjectCurd.repository.ProductRepo;
import com.example.ProjectCurd.repository.UserRepo;
import com.example.ProjectCurd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {


    private UserRepo userRepo;
    @Autowired
    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Users create(Users users) {
        return userRepo.save(users);
    }

    @Override
    public List<Users> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Users getOneUser(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Users update(Users users) {
        return userRepo.save(users);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
