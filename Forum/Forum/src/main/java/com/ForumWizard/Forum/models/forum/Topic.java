package com.ForumWizard.Forum.models.forum;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar em branco.")
    @Size(max = 200, message = "O título deve ter no máximo 200 caracteres.")
    @Column(nullable = false, length = 200)
    private String title;

    @NotBlank(message = "O conteúdo não pode estar em branco.")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Topic() {}

    public Topic(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}