package com.softwears.Softwear.Users;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repo;

    public List<Address> getAllAddresses(){
        return repo.findAll();
    }

    public Address getAddressId(int id){
        return repo.findById(id).orElse(new Address());
    }   

    public void addAddress(Address address){
        repo.save(address);
    }

    public void updateAddress(Address address){
        repo.save(address);
    }

    public void deleteAddress(int id){
        repo.deleteById(id);
    }
}


