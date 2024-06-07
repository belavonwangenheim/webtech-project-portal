package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @Column(name = "read", nullable = false)
    private boolean isRead;

    private LocalDateTime timestamp;

    // Beziehung zu AppUser, viele Benachrichtigungen können einem Benutzer gehören
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;
}
