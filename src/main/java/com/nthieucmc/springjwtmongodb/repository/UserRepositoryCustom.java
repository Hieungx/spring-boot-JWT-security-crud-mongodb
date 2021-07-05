package com.nthieucmc.springjwtmongodb.repository;

import com.nthieucmc.springjwtmongodb.dto.UserDTO;
import com.nthieucmc.springjwtmongodb.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCustom {
    User findUserByUsername(String username);
}
