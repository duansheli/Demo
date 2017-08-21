package com.fluffy.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fluffy.entity.User;

/**
 * JpaRepository
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameLike(String username);

    List<User> findByUsernameNotLike(String username);

}