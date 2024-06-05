package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String email;
    private String location;
    private String salary;
    private String jobType; // Vollzeit, Teilzeit, etc.
    private String requirements;
    private LocalDate startDate;
    private LocalDate endDate;
}
