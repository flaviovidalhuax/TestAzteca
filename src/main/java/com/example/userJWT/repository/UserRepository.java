package com.example.userJWT.repository;

import com.example.userJWT.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Override
    Optional<UserEntity> findById(Long aLong);


    List<UserEntity> findByNombre(String nombre);
}
