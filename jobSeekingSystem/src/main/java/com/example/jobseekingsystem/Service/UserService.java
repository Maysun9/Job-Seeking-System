package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Api.ApiException;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //get all user
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    // add a user
    public void addUser(User user){
        if(user == null){
            throw new ApiException("sorry, user not found");
        }
        userRepository.save(user);
    }

    //update a user
    public void updateUser(Integer id, User user){
        User u=userRepository.findUserById(id);
        if(u==null){
            throw new ApiException("Sorry, user not found");
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());

        userRepository.save(u);
    }

    //delete a user
    public void deleteUser(Integer id){
        // نشيك اذا اليوزر موجود
        User u = userRepository.findUserById(id);
        if(u == null){
            throw new ApiException("Sorry, user not found");
        }
        //اذا موجود بيحذف
        userRepository.delete(u);
    }

    //--------------------------------------------------------------END CRUD---------------------------------------------------------------------
}
