package com.fsb.pfe.serviceInterface;

import com.fsb.pfe.dto.UserDto;
import com.fsb.pfe.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User addUser(UserDto u);
    User getUser(int idUser);
    User updateUser(User u);
    void deleteUser(int idUser);
}
