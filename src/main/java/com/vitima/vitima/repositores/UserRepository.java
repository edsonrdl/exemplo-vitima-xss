package com.vitima.vitima.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitima.vitima.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
