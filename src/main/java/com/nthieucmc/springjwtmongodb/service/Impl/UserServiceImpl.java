package com.nthieucmc.springjwtmongodb.service.Impl;

import com.nthieucmc.springjwtmongodb.constant.ErrorCode;
import com.nthieucmc.springjwtmongodb.dto.UserDTO;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import com.nthieucmc.springjwtmongodb.exception.CustomException;
import com.nthieucmc.springjwtmongodb.mapper.UserMapper;
import com.nthieucmc.springjwtmongodb.models.User;
import com.nthieucmc.springjwtmongodb.repository.UserRepository;
import com.nthieucmc.springjwtmongodb.service.UserService;
import com.nthieucmc.springjwtmongodb.validation.ValidationResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    PasswordEncoder encoder;

    @Resource
    UserRepository userRepository;

    @Resource
    UserMapper userMapper;

    @Override
    public UserDTO getByUsername(String username) {
        ValidationResult validationResult = validateUserExisted(username);
        if (!validationResult.isSuccessful()) {
            throw new CustomException(validationResult.getCode(), validationResult.getMessage());
        }
        User user = userRepository.findUserByUsername(username);

        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getListUser() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = userMapper.toListDTO(users);
        return userDTOS;
    }

    @Override
    public BaseResponseDTO editUser(UserDTO userDTO, String password) {
        ValidationResult validationResult = validateUserExisted(userDTO.getUsername());
        if (!validationResult.isSuccessful()) {
            throw new CustomException(validationResult.getCode(), validationResult.getMessage());
        }
        User oldUser = userRepository.findUserByUsername(userDTO.getUsername());
        oldUser.setEmail(userDTO.getEmail());
        if (!ObjectUtils.isEmpty(password)) {
            oldUser.setPassword(encoder.encode(password));
        }
        userRepository.deleteById(new ObjectId(userDTO.getId()));
        userRepository.save(oldUser);

        return new BaseResponseDTO();
    }

    @Override
    public BaseResponseDTO deleteUserByUsername(String username) {
        ValidationResult validationResult = validateUserExisted(username);
        if (!validationResult.isSuccessful()) {
            throw new CustomException(validationResult.getCode(), validationResult.getMessage());
        }
        userRepository.delete(userRepository.findUserByUsername(username));
        return new BaseResponseDTO();
    }

    @Override
    public BaseResponseDTO deleteUserById(String Id) {
        ValidationResult validationResult = validateUserExisted(userRepository.findById(new ObjectId(Id)).get().getUsername());
        if (!validationResult.isSuccessful()) {
            throw new CustomException(validationResult.getCode(), validationResult.getMessage());
        }
        userRepository.deleteById(new ObjectId(Id));
        return new BaseResponseDTO();
    }

    private ValidationResult validateUserExisted(String username) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setSuccessful(true);
        if (ObjectUtils.isEmpty(userRepository.findByUsername(username))) {
            validationResult.setSuccessful(false);
            validationResult.setCode(ErrorCode.USER_NOT_FOUND);
            validationResult.setMessage("User not found");
        }
        return validationResult;
    }
}
