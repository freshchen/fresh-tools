package com.example.tools.persistence.repository;

import com.example.tools.persistence.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author darcy
 * @since 2020/10/25
 **/
@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {

    Optional<Password> findByName(String name);
}
