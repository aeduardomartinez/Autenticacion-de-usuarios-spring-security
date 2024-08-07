package com.autenticacion.user.repository;

import com.autenticacion.user.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findUserEntityByUsername(String username);



}