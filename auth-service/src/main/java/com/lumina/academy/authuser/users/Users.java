package com.lumina.academy.authuser.users;

import com.lumina.academy.authuser.users.converters.CpfConverter;
import com.lumina.academy.authuser.users.converters.EmailConverter;
import com.lumina.academy.authuser.users.converters.PasswordConverter;
import com.lumina.academy.authuser.users.converters.PhoneNumberConverter;
import com.lumina.academy.authuser.users.enums.UserStatus;
import com.lumina.academy.authuser.users.enums.UserType;
import com.lumina.academy.authuser.users.valueobject.Cpf;
import com.lumina.academy.authuser.users.valueobject.PhoneNumber;
import jakarta.persistence.*;
import com.lumina.academy.authuser.domain.Base.BaseEntity;
import com.lumina.academy.authuser.users.valueobject.Email;
import com.lumina.academy.authuser.users.valueobject.Password;

@Entity
@Table(name = "tb_usuario")
public class Users extends BaseEntity {

    @Column(name = "nome_usuario", nullable = false)
    private String userName;

    @Column(name = "primeiro_nome", nullable = false)
    private String firstName;

    @Column(name = "sobrenome", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @Convert(converter = EmailConverter.class)
    private Email email;

    @Column(name = "senha", nullable = false)
    @Convert(converter = PasswordConverter.class)
    private Password password;

    @Column(name = "telefone")
    @Convert(converter = PhoneNumberConverter.class)
    private PhoneNumber phoneNumber;

    @Column(name = "cpf", nullable = false, unique = true)
    @Convert(converter = CpfConverter.class)
    private Cpf cpf;

    @Column(name = "url_foto_perfil")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private UserType userType;

    public Users() {
        super();
    }


    public Users(
            String userName,
            String firstName,
            String lastName,
            Cpf cpf,
            Email email,
            Password password,
            UserType userType,
            UserStatus status
    ) {
        super();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.status = status;
    }
}
