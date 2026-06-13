package com.lumina.academy.authuser.infrastructure.persistence.users;

import com.lumina.academy.authuser.domain.users.entities.Users;
import com.lumina.academy.authuser.domain.users.valueobjects.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositoryJpa extends JpaRepository<Users, UUID> {

    @Query("SELECT u FROM Users u WHERE u.cpf = :cpf")
    Optional<Users> findByCpf(@Param("cpf") Cpf cpf);

    Optional<Users> findByEmail(String email);

    @Query("SELECT u FROM Users u WHERE u.firstName = :firstName AND u.lastName = :lastName")
    Optional<Users> FindByNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT u FROM Users u WHERE u.id = :id")
    Optional<Users> findById(@Param("id") UUID id);

}
