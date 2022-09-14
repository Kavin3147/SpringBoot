package com.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.audit.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
