package com.softwears.Softwear.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public void updateUser(Users user){
        repo.save(user);
    }
    
    public void deleteuser(int id){
        repo.deleteById(id);
    }
    public void updateAddress( int userId, String street, String city, String state, int zipCode, String country){ 
        Users user = repo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Address address = new Address(street, city, state, zipCode, country);
        user.setAddress(address);
        repo.save(user);   
    }
    public void updateUserCredentials(int userId, String email, String password){
        Optional<Users> optionalUser = repo.findById(userId);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setUserEmail(email);
            if (password != null && !password.isEmpty()) {
                // Encrypt the password before saving it
                String encryptedPassword = new BCryptPasswordEncoder().encode(password);
                user.setUserPassword(encryptedPassword);
            }
            repo.save(user);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
    }
    public Users findByuserEmail(String userEmail) {
        return repo.findByuserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + userEmail));
    }
    
}
