package com.lumina.academy.authuser.user.infrastructure.persistence;

import com.lumina.academy.authuser.user.domain.User;
import com.lumina.academy.authuser.user.domain.vo.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM UserEntity u WHERE u.cpf = :cpf")
    Optional<User> findByCpf(@Param("cpf") Cpf cpf);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.firstName = :firstName AND u.lastName = :lastName")
    Optional<User> findByNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT u FROM UserEntity u WHERE u.id = :id")
    Optional<User> findById(@Param("id") UUID id);

}
