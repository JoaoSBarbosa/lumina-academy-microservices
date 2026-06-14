package com.lumina.academy.authuser.users.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lumina.academy.authuser.users.entity.converters.CpfConverter;
import com.lumina.academy.authuser.users.entity.converters.EmailConverter;
import com.lumina.academy.authuser.users.entity.converters.PasswordConverter;
import com.lumina.academy.authuser.users.entity.converters.PhoneNumberConverter;
import com.lumina.academy.authuser.users.entity.enums.UserGender;
import com.lumina.academy.authuser.users.entity.enums.UserStatus;
import com.lumina.academy.authuser.users.entity.enums.UserType;
import com.lumina.academy.authuser.users.entity.vo.Cpf;
import com.lumina.academy.authuser.users.entity.vo.PhoneNumber;
import jakarta.persistence.*;
import com.lumina.academy.authuser.shared.Base.BaseEntity;
import com.lumina.academy.authuser.users.entity.vo.Email;
import com.lumina.academy.authuser.users.entity.vo.Password;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
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

    @JsonIgnore
    @Convert(converter = PasswordConverter.class)
    @Column(name = "senha", nullable = false, length = 255)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM=yyyy HH:mm:ss")
    private LocalDate birthDate;


}
