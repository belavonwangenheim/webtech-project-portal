package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;
import java.time.LocalDate;

@Data
// Lombok Annotation um code zu reduzieren, (@Data) für Getter, Setter & toString Methoden.
public class JobOffer {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String phone;
    private String email;
    private double salary;
    private LocalDate startDate;
    private int durationInDays;

}
