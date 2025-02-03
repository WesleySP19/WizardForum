package com.ForumWizard.Forum.models.user;

import com.ForumWizard.Forum.models.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "O email deve ser válido.")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    @Column(nullable = false, length = 100)
    private String password;

    @NotNull(message = "O tipo de usuário não pode ser nulo.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    public User() {}

    public User(String name, String email, String password, UserType userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
}