package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
// Lombok Annotation um code zu reduzieren, (@Data) für Getter, Setter & toString Methoden.
public class JobOffer {
    private Long jobID;
    private String title;
    private String description;
    private String location;
    private String phone;
    private String email;
    private double salary;
    private LocalDate startDate;
    private int durationInDays;

}
