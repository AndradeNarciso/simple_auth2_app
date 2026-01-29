package com.andrade.simple_auth2_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrade.simple_auth2_app.domain.Role;


@Repository
public interface  RoleRepository extends JpaRepository<Role,Long> {
    
}
