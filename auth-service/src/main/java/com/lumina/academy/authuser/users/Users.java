package com.lumina.academy.authuser.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.lumina.academy.authuser.domain.Base.BaseEntity;
import com.lumina.academy.authuser.users.valueobject.Email;
import com.lumina.academy.authuser.users.valueobject.Password;

@Entity
@Table(name = "tb_usuario")
public class Users extends BaseEntity {

    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private Email email;
    @Column(name = "senha", nullable = false)
    private Password password;

}
