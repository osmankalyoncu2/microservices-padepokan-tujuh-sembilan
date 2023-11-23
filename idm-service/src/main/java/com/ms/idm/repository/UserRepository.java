package com.ms.idm.repository;

import com.ms.idm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByAccountNumber(String acountNumber);
    Optional<User> findUserByIdentityNumber(String indetityNumber);
}
