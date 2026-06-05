package com.lumina.academy.authuser.users;

import com.lumina.academy.authuser.users.converters.CpfConverter;
import com.lumina.academy.authuser.users.converters.EmailConverter;
import com.lumina.academy.authuser.users.converters.PasswordConverter;
import com.lumina.academy.authuser.users.converters.PhoneNumberConverter;
import com.lumina.academy.authuser.users.enums.UserGender;
import com.lumina.academy.authuser.users.enums.UserStatus;
import com.lumina.academy.authuser.users.enums.UserType;
import com.lumina.academy.authuser.users.valueobject.Cpf;
import com.lumina.academy.authuser.users.valueobject.PhoneNumber;
import jakarta.persistence.*;
import com.lumina.academy.authuser.domain.Base.BaseEntity;
import com.lumina.academy.authuser.users.valueobject.Email;
import com.lumina.academy.authuser.users.valueobject.Password;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users extends BaseEntity {

    @Column(name = "nome_usuario", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "primeiro_nome", nullable = false, length = 200)
    private String firstName;

    @Column(name = "sobrenome", nullable = false, length = 200)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    @Convert(converter = EmailConverter.class)
    private Email email;

    @Column(name = "senha", nullable = false, length = 255)
    @Convert(converter = PasswordConverter.class)
    private Password password;

    @Column(name = "telefone", length = 20)
    @Convert(converter = PhoneNumberConverter.class)
    private PhoneNumber phoneNumber;

    @Column(name = "cpf", nullable = true, unique = true, length = 11)
    @Convert(converter = CpfConverter.class)
    private Cpf cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false, length = 1)
    private UserGender gender;

    @Column(name = "url_foto_perfil")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private UserType userType;

    @Column(name = "data_nascimento")
    private LocalDate birthDate;


}
