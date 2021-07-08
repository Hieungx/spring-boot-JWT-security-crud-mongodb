package com.nthieucmc.springjwtmongodb.controller;

import com.nthieucmc.springjwtmongodb.dto.UserDTO;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import com.nthieucmc.springjwtmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get-by-username")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<UserDTO> getByUsername(@RequestParam String username){
        UserDTO userDTO = userService.getByUsername(username);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/get-all-user")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> list = userService.getListUser();
        return ResponseEntity.ok(list);
    }

    @PutMapping("edit-user")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<BaseResponseDTO> editUser(@RequestBody UserDTO userDTO,
                                                    @RequestParam(required = false)String password){
        BaseResponseDTO response = userService.editUser(userDTO,password);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete-user-by-username")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<BaseResponseDTO> deleteUser(@RequestParam String username){
        BaseResponseDTO response = userService.deleteUserByUsername(username);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete-user-by-id")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<BaseResponseDTO> deleteUser(@RequestBody UserDTO userDTO){
        BaseResponseDTO response = userService.deleteUserById(userDTO.getId());
        return ResponseEntity.ok(response);
    }
}
