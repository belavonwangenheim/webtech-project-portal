package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
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

    public JobOffer(Long jobID, String title, String description, String location, String phone, String email, double salary, LocalDate startDate, int durationInDays) {
        this.jobID = jobID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.startDate = startDate;
        this.durationInDays = durationInDays;
    }
}
