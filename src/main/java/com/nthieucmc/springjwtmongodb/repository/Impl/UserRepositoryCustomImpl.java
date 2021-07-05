package com.nthieucmc.springjwtmongodb.repository.Impl;

import com.nthieucmc.springjwtmongodb.mapper.UserMapper;
import com.nthieucmc.springjwtmongodb.models.User;
import com.nthieucmc.springjwtmongodb.repository.UserRepositoryCustom;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public User findUserByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }
}
