package com.fsb.pfe.services;

import com.fsb.pfe.dto.UserDto;
import com.fsb.pfe.entities.User;
import com.fsb.pfe.repository.UserRepository;
import com.fsb.pfe.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository ur;

    @Override
    public List<User> getAllUsers() {
        return ur.findAll();
    }

    @Override
    public User addUser(UserDto u) {
        User user = this.fromDto(u);
        return ur.save(user);
    }

    @Override
    public User getUser(int idUser) {
        return ur.findById(idUser).orElse(null);
    }

    @Override
    public User updateUser(User u) {
        return ur.save(u);
    }

    @Override
    public void deleteUser(int idUser) {
        ur.deleteById(idUser);
    }

    public static  User fromDto(UserDto userDto)
    {
        User  user  =  new User();
        user.setCin(Integer.getInteger( userDto.getCin()));
        user.setMail(userDto.getMail());
        user.setPoste(userDto.getPoste());
        user.setName(userDto.getName());
        user.setCode(userDto.getCode());
        return user;
    }

    public static  UserDto fromModel(User userDto)
    {
     if(userDto ==null)
         return null;
        UserDto  user  =  new UserDto();
        user.setCin(userDto.getCin().toString());
        user.setMail(userDto.getMail());
        user.setPoste(userDto.getPoste());
        user.setName(userDto.getName());
        user.setCode(userDto.getCode());
        user.setPassword(userDto.getPassword());
        user.setActive(userDto.isActive());


        return user;
    }

    public UserDto  getUserByCode(UserDto userDto)
    {
        Optional<User> user =this.ur.findUserBycode(userDto.getCode());
        if(user.isPresent())
        {
            return this.fromModel(user.get());
        }
        return null;
    }
}
