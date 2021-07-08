package com.nthieucmc.springjwtmongodb.service;

import com.nthieucmc.springjwtmongodb.dto.UserDTO;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

    UserDTO getByUsername(String username);

    List<UserDTO> getListUser();

    BaseResponseDTO editUser(UserDTO userDTO,String password);

    BaseResponseDTO deleteUserByUsername(String username);

    BaseResponseDTO deleteUserById(String Id);
}
