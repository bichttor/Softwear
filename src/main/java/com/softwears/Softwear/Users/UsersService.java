package com.softwears.Softwear.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
   @Autowired
    private UsersRepository repo;
     
    public List<Users> getAllusers(){
        return repo.findAll();
    }

    public Users getuserId(int id){
        return repo.findById(id).orElse(new Users());
    }
    public void addUser(Users user){
        repo.save(user);
    }

    public void updateuser(Users user){
        repo.save(user);
    }

    public void deleteuser(int id){
        repo.deleteById(id);
    }

}
