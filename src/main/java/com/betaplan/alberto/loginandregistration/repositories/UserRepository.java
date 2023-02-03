package com.betaplan.alberto.loginandregistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.betaplan.alberto.loginandregistration.models.User;

/////////////////////////////////////////////////////////////
//	USER REPOSITORY
/////////////////////////////////////////////////////////////

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUserName(String userName);
}