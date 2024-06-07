package de.htw.berlinwebtech.webtechprojectportal.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String address;

    // Neuer Konstruktor, der nur die ID setzt
    public AppUser(Long id) {
        this.id = id;
    }

    // Beziehung zu Notification, ein Benutzer kann viele Benachrichtigungen haben
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Ignoriert die Sammlung während der Serialisierung
    private List<Notification> notifications;
}
