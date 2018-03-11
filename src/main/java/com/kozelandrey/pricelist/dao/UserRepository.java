package com.kozelandrey.pricelist.dao;

import com.kozelandrey.pricelist.data.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<String, User> {

}
