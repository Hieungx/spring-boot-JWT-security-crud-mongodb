package com.nthieucmc.springjwtmongodb.repository;

import java.util.Optional;

import com.nthieucmc.springjwtmongodb.models.ERole;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nthieucmc.springjwtmongodb.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
